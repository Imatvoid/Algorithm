## CopyListWithRandomPointer
https://leetcode.com/problems/copy-list-with-random-pointer/

分身镜像法

我们需要拿到当前节点的拷贝，这是一个映射关系。

map 
node -> this node.deep.copy

map.get(node).next = map.get(node.next)