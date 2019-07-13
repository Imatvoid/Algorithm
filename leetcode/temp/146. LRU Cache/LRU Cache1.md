

使用数组实现

两个数组 一个keyTable;一个vauleTable；

capacity,nowLoadNum 当前元素数量。

code
```java

import java.util.Arrays;

public class LRUCache {

    private int capacity;
    private int nowLoadNum;
    private int[] keyTable;
    private int[] valueTable;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyTable = new int[capacity];
        Arrays.fill(keyTable,-1);
        valueTable = new int[capacity];
        nowLoadNum =0;
    }

    public int get(int key) {
        int index = -1;
        for (int i = 0; i < nowLoadNum; i++) {
            if (keyTable[i] == key) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            int temp1 = keyTable[index];
            int temp2 = valueTable[index];
            for (int i = index; i < nowLoadNum-1; i++) {
                keyTable[i] = keyTable[i+1];
                valueTable[i] = valueTable[i+1];
            }
            keyTable[nowLoadNum-1] = temp1;
            valueTable[nowLoadNum-1] = temp2;

            return valueTable[nowLoadNum-1];
        }

        return -1;

    }

    public void put(int key, int value) {
        //如果已经存在
        int index = -1;
        for (int i = 0; i < nowLoadNum; i++) {
            if (keyTable[i] == key) {
                index = i;
                valueTable[index]=value;
                break;
            }
        }
        if(index!=-1) {
            int temp1 = keyTable[index];
            int temp2 = valueTable[index];
            for (int i = index; i < nowLoadNum-1; i++) {
                keyTable[i] = keyTable[i+1];
                valueTable[i] = valueTable[i+1];
            }
            keyTable[nowLoadNum-1] = temp1;
            valueTable[nowLoadNum-1] = temp2;
            return;
        }


         //如果不存在，需丢弃元素
        if(nowLoadNum==capacity){
            for (int i = 0; i < capacity-1; i++) {
                keyTable[i ] = keyTable[i+1];
                valueTable[i ] = valueTable[i+1];
            }
            keyTable[capacity-1] = key;
            valueTable[capacity-1] = value;

            return;
        }

       //如果不存在，不需要丢弃元素
        keyTable[nowLoadNum]=key;
        valueTable[nowLoadNum]=value;

        nowLoadNum++;
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public static void main(String[] args) {
    LRUCache cache = new LRUCache( 2 /* capacity */ );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4
}
}

```

