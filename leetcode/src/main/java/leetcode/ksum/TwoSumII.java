package leetcode.ksum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII {

    /**
     * 对比TwoSum其实没改动
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int [] res= new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i =0;i<nums.length;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }else{
                // 唯一是下标变了
                res[0] = map.get(target-nums[i])+1;
                res[1] = i+1;
                break;
            }
        }
        return  res;


    }
}
