1.Agent 从 main() 到 think() 的完整调用链
Main.main()：解析命令行、展开 -all/-local/-precompute 等别名，创建 AgentLauncher 并调用 start()
AgentLauncher 构造：
  调用 init()：
      initSystem() 注册 RCRS 实体/消息/属性工厂
  ConfigInitializer.getConfig(args) 合并 config/launch.cfg 和命令行参数
  initConnector() 加载 DefaultLoader，注册 6 个 Connector
AgentLauncher.start()：读取 kernel.host/kernel.port，创建 TCPComponentLauncher，为每个 Connector 创建独立线程并启动
ComponentLauncher.connect()：创建 TCPConnection，启动读/写线程，再调用 Agent 的 connect()
AbstractAgent.connect()：发送 AKConnect(requestID, 2, name, requestedEntityURNs)，等待 Kernel 回复
Kernel 根据请求的 URN 分配一个场景实体，返回 KAConnectOK
AbstractAgent.handleConnectOK()：调用 postConnect(c, agentID, entities, kernelConfig)
AbstractComponent.postConnect()：创建 WorldModel、合并 Kernel 配置，然后调用 ADF 的 Agent.postConnect()
ADF Agent.postConnect()：创建 WorldInfo、ScenarioInfo，确定 PRECOMPUTATION/PRECOMPUTED/NON_PRECOMPUTE
Platoon/Office.postConnect()：创建 AgentInfo、ModuleManager，初始化 rootTactics
握手完成后发送 AKAcknowledge，启动 MessageProcessor，开始接收 Kernel 消息
每回合 Kernel 发送 KASense
AbstractAgent.processMessage() 识别 KASense 后调用 processSense(sense)
Agent.processSense()：更新 WorldInfo、合并 ChangeSet，调用 think(time, changed, heard)
Agent.think(int, ChangeSet, Collection<Command>)：初始化通信、订阅频道、接收消息，最后调用抽象 think()
Platoon.think() 调用 rootTactics.think() 得到 Action，并通过 send(action.getCommand(...)) 发送动作命令；
Office.think() 只执行中心 Tactics，不发送物理动作。
2.`initConnector()` 注册了哪 6 种 Connector？分别对应什么角色？
ConnectorAmbulanceTeam：移动型 Ambulance Team，负责救人、搬运
ConnectorFireBrigade：移动型 Fire Brigade，负责灭火、救援
ConnectorPoliceForce：移动型 Police Force，负责清理道路障碍
ConnectorAmbulanceCentre：中心型 Ambulance Centre，负责调度 Ambulance Team
ConnectorFireStation：中心型 Fire Station，负责调度 Fire Brigade
ConnectorPoliceOffice：中心型 Police Office，负责调度 Police Force
3. `postConnect()` 和 `think()` 谁先被调用？为什么？
postConnect() 先被调用,postConnect() 是连接成功后的回调，只有连接建立、实体和控制权分配完成后才会触发。think() 位于每回合消息处理链路里， 
processSense(KASense) 调用，而 KASense 只有在 postConnect() 完成后、Agent 开始运行后才会收到。
4.如果 `think()` 内抛出了异常，会怎么样？
会被本地捕获并打印堆栈，不会抛给 Kernel，也不会让整个 Agent JVM 直接退出,
当前 tick 会继续执行后面的消息协调和通信发送，后续 tick 仍会继续调用 think()。
