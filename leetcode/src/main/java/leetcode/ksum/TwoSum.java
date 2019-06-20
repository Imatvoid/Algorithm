package leetcode.ksum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * hash map
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
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                break;
            }
        }
        return  res;


    }

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] sorted= new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);

        int left=0;
        int right= nums.length-1;

        while(left<right){
            if(sorted[left]+sorted[right]<target){
                left++;
                continue;
            }
            else if(sorted[left]+sorted[right]>target){
                right--;
                continue;
            }
            else{
                break; //found it! sorted[left]+sorted[right]==target
            }
        }
        //find the index in nums
        int index1 =-1;
        int index2= -1;

        for(int i=0; i<sorted.length; i++){
            if(nums[i]==sorted[left] || nums[i]==sorted[right]){
                if(index1 == -1){
                    index1=i;
                }
                else{
                    index2=i;
                }
            }
        }

        //leetcode.sort the final result
        int [] result= {index1, index2};
        Arrays.sort(result);
        return result;

    }
}
