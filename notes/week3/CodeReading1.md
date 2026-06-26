CodeReading1

1. SampleFireBrigade.java 的 sense() 方法做了什么？

sense() 方法用于感知当前环境中的目标对象，遍历附近对象，根据条件筛选需要处理的目标，为后续提供信息

2. for (Iterator it = targets.iterator(); it.hasNext();) 这种语法叫什么？

这种写法叫做 Iterator（迭代器）遍历，它通过 hasNext() 判断是否还有元素，通过 next() 获取下一个元素

3. 为什么这里不用增强 for 循环？

因为 Iterator 可以在遍历过程中安全地删除元素或修改集合，而增强 for 循环不能安全地完成这些操作