## CopyListWithRandomPointer
https://leetcode.com/problems/copy-list-with-random-pointer/

分身镜像法

我们需要拿到当前节点的拷贝，这是一个映射关系。

map 
listNode -> this listNode.deep.copy

map.get(listNode).next = map.get(listNode.next)