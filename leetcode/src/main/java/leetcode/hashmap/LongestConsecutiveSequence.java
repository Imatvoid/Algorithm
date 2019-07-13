package leetcode.hashmap;

import java.util.HashMap;

public class LongestConsecutiveSequence {

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
}
