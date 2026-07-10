

- `Collection<EntityID> unexploredBuildings` 为什么用 `Collection` 而不是 `List`？
'unexploredBuildings'实际使用的是' HashSet' '保存建筑物,由于建筑物不需要保持顺序，并且不能重复，使用' HashSet' 比 'List '更合适
- `EnumSet.of(...)` 是什么作用？对比普通 `Set` 有什么好处？
'EnumSet.of()' 用于快速创建一个包含指定枚举值的集合。'EnumSet' 是专门用于枚举类型的集合，只能存储枚举对象，因此类型更加安全。相比普通 'HashSet`,`EnumSet'内部采用位运算实现，占用内存更少，执行效率更高