package leetcode.pqtk;

import java.util.*;

public class TopKFrequentElements {

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


    /**
     * 桶排序
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}
