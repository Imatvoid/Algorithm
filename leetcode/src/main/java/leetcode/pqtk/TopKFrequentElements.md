`347. Top K Frequent Elements`

<https://leetcode.com/problems/top-k-frequent-elements/>

`347. 前 K 个高频元素`

<https://leetcode-cn.com/problems/top-k-frequent-elements/>

## 描述
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:
``````
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
``````
示例 2:
``````
输入: nums = [1], k = 1
输出: [1]
``````
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

## 思路

topK问题,优先级队列.  
TopK问题,先用map统计次数,然后使用优先级priorityQueue排序.    
注意这里的优先级队列,本质就是小顶堆,当然这个小的关系是你自己定义的.你总是可以得到一种比较关系的前K个元素.    
这里的传入比较关系函数是`(a,b) -> b.getValue()-a.getValue()`,也就是a大,就返回<0的值,就把它放到队列前面.    


```java
public List<Integer> topKFrequent2(int[] nums, int k) {

        Map<Integer,Integer>  map = new HashMap<>();

        for(int i =0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        for (Map.Entry<Integer,Integer> e: map.entrySet()) {
            priorityQueue.add(e);
        }

        List<Integer> arrayList = new ArrayList<>();
        while (arrayList.size()<k){
            Map.Entry<Integer,Integer> e = priorityQueue.poll();
            arrayList.add(e.getKey());
        }
        return  arrayList;

    }
```