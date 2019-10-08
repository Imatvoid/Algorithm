package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    DoublyLinkedList DLList;
    int capacity;
    Map<Integer, ListNode> cache;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.DLList = new DoublyLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        } else {
            ListNode node = cache.get(key);
            DLList.remove(node);
            DLList.addToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            if (cache.size() >= capacity) {
                ListNode toRemove = DLList.tail.prev;
                DLList.remove(toRemove);
                cache.remove(toRemove.key);
            }
            ListNode newNode = new ListNode(key, value);
            DLList.addToHead(newNode);
            cache.put(key, newNode);
        } else {
            ListNode node = cache.get(key);
            node.val = value;
            DLList.remove(node);
            DLList.addToHead(node);
        }
    }

}


class ListNode {
    int key, val;
    ListNode prev, next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoublyLinkedList {
    ListNode head, tail;
    int size = 0;

    DoublyLinkedList() {
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    void addToHead(ListNode listNode) {
        listNode.prev = head;
        listNode.next = head.next;
        head.next = listNode;
        listNode.next.prev = listNode;
        size++;
    }

    void remove(ListNode listNode) {
        listNode.prev.next = listNode.next;
        listNode.next.prev = listNode.prev;
        size--;
    }

    ListNode removeLast() {
        if (size > 0) {
            ListNode listNode = tail.prev;
            remove(listNode);
            return listNode;
        } else return null;
    }
}
