
`692. Top K Frequent Words`

<https://leetcode-cn.com/problems/top-k-frequent-words/>

`692. 前K个高频单词`

<https://leetcode.com/problems/top-k-frequent-words/>

## 描述
给一非空的单词列表，返回前 k 个出现次数最多的单词。

返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

示例 1：
```
输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。   
```

示例 2：
```
输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
输出: ["the", "is", "sunny", "day"]
解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
    出现次数依次为 4, 3, 2 和 1 次。
```

注意：
```
假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
输入的单词均由小写字母组成。
```


## 思路
topK问题,优先级队列.    
TopK问题,先用map统计次数,然后使用优先级priorityQueue排序.     
注意这里的优先级队列,本质就是小顶堆,当然这个小的关系是你自己定义的.你总是可以得到一种比较关系的前K个元素.    
这里的传入比较关系函数是`a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()`    
也就是a大,就返回<0的值,就把它放到队列前面,如果a和b值相等,就按字典序排序.   


```java
/**
     * 优先级队列
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> result = new LinkedList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(

                (a, b) -> {
                    return a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue();
                }
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        while (result.size() < k) {
            result.addLast(pq.poll().getKey());
        }


        return result;

    }
```