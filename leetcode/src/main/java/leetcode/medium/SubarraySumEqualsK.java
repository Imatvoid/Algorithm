package leetcode.medium;

import java.util.HashMap;

public class SubarraySumEqualsK {


    /**
     * 暴力求解
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        for(int i = 0 ; i<n ; i++){
            int sum = nums[i];
            if (sum == k) ++res;
            for (int j = i + 1; j < n; ++j) {
                sum += nums[j];
                if (sum == k) ++res;
            }
        }
        return res;
    }

    /**
     * haspmap
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res += map.get(sum - k) == null ? 0 : map.get(sum - k);
            if(map.get(sum) == null){
                map.put(sum,1);
            }else{
                map.put(sum,( map.get(sum)+1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new SubarraySumEqualsK().subarraySum(new int[]{1,1,1},2);
    }

}


