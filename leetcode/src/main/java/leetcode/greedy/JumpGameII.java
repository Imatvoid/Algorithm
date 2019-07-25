package leetcode.greedy;

/**
 * @Author: yangxu
 * @Date: 19-7-26 上午7:32
 */
public class JumpGameII {

    public int jump(int[] nums) {
        int n = nums.length;

        int pre = 0,cur=0, res=0,i=0;
        while(cur<n-1){
            res++;
            pre =cur;
            for(;i<=pre;i++){
                cur = Math.max(cur,i+nums[i]);
            }
            if(pre == cur) return -1;


        }
        return res;

    }
}
