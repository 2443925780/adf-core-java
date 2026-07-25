-1. `AgentLauncher.java:104-109` 中 `.stream().map(...).collect(...)` 这段代码做了什么？请逐行解释
- List<Thread> threadList = this.connectors.stream()
  .map(connector -> new Thread(() -> {
  connector.connect(launcher, this.config, loader);
  })).collect(Collectors.toList());
  threadList.forEach(Thread::start);
- 这段代码的作用是遍历所有 Connector，为每一个 Connector 创建一个独立的 Thread，并将所有创建好的线程保存到 List 中
- List<Thread> threadList = this.connectors.stream()    
- this.connectors 是保存多个 Connector 的集合   .stream() 将集合转换成 Stream 流，方便对里面的每个元素进行处理。
- .map(connector -> new Thread(() -> {
- map() 的作用是： 将 Stream 中的每一个元素转换成新的对象
- connector -> new Thread(...) 表示每取出一个 Connector，就创建一个 Thread
- connector.connect(launcher, this.config, loader);
- 这是线程真正执行的内容,每个线程会调用自己的 Connector 的 connect() 方法，
负责连接对应的 Server。
- .collect(Collectors.toList());
- collect() 用于收集 Stream 的处理结果
这里把前面创建出来的多个 Thread 收集成一个 List
-2.为什么要给每个 Connector 启动一个独立线程？串行连接会有什么问题？
  因为每个 Connector 都需要连接 Server。
如果所有 Connector 使用同一个线程串行连接：
- Connector1连接Server
  ↓
  完成后
  ↓
  Connector2连接Server
  ↓
  完成后
  ↓
  Connector3连接Server
(1)连接效率低: 前一个 Connector 没有完成时，后面的 Connector 必须等待
(2)启动时间增加:多个连接无法同时进行，需要一个一个执行 
(3)影响 Agent 并发运行: RCRS 中存在多个 Agent，每个 Agent 需要同时运行自己的逻辑