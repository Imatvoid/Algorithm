package leetcode.design;

import java.util.HashMap;
import java.util.Map;


public class LFUCache {
    class Node {
        int key, val;
        Node prev, next;
        int cnt;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            cnt = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void addToHead(Node node) {
            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

    }

    int capacity, min;
    Map<Integer, Node> nodeMap;
    Map<Integer, DoublyLinkedList> countMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        } else {

            if (nodeMap.size() == capacity) {
                DoublyLinkedList lastList = countMap.get(min);
                nodeMap.remove(lastList.tail.prev.key);
                lastList.remove(lastList.tail.prev);
            }

            node = new Node(key, value);
            nodeMap.put(key, node);

            min = 1;
            DoublyLinkedList newList = countMap.getOrDefault(node.cnt, new DoublyLinkedList());
            newList.addToHead(node);
            countMap.put(node.cnt, newList);
        }
    }

    private void update(Node node) {
        DoublyLinkedList oldList = countMap.get(node.cnt);
        oldList.remove(node);
        if (node.cnt == min && oldList.size == 0) min++;
        node.cnt++;
        DoublyLinkedList newList = countMap.getOrDefault(node.cnt, new DoublyLinkedList());
        newList.addToHead(node);
        countMap.put(node.cnt, newList);
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
    }
}
