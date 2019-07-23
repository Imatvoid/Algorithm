package leetcode.linkedlist;

public class DeleteNodeInaLinkedList {
    /**
     * 这还真的没什么营养,把值覆盖一下,然后删除下一个节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
