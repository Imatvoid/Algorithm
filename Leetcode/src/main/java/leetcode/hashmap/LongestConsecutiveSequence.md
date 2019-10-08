## 128. Longest Consecutive Sequence



### Desc

Given an unsorted leetcode.array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(*n*) complexity.

**Example:**

```
Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
```



### 描述

最长连续子序列









### 思路

这道题不是dp哦 不是最长递增子序列

先将数组的值都加入hashmap

然后遍历数组，如果nums[i]在map中，则使用pre记录nums[i]-1,next记录nums[i]+1

不断从map中删除pre pre--

不断从map中删除next next++



最后 若上升序列为 1 2 3  则 pre =0 next =4  next-pre-1 = 3

```java
/**
     * 最长连续子序列  [100, 4, 200, 1, 3, 2] => 1 2 3 4
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }

        int resMax = 1;

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
                int pre = nums[i] - 1;
                int next = nums[i] + 1;
                while (map.remove(pre) != null) {
                    pre--;
                }
                while (map.remove(next) != null) {
                    next++;
                }
                // 若上升序列为 1 2 3  则 pre =0 next =4
                if (next - pre - 1 > resMax) {
                    resMax = next - pre - 1;
                }

            }
        }
        return resMax;
    }
```

