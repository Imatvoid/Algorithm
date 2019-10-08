package leetcode.greedy;

public class JumpGame {

    /**
     * 通用解法
     * @param nums
     * @return
     */
    public boolean canJumpII(int[] nums) {

        int n = nums.length;
        int cur=0,pre=0,i=0;
        int count = 0;
        while(cur<n-1){
            //count++;
            pre = cur;
            for(;i<=pre;i++){
                cur = Math.max(cur,i+nums[i]);
            }
            if(pre == cur){
                return false;
            }


        }
        return true;

    }


    /**
     * 不断更新最大可覆盖范围
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int maxCover = 0;
        for (int i = 0; i <= maxCover; i++) {
            int tempCover = i + nums[i];
            if (tempCover > maxCover) {
                maxCover = tempCover;
            }
            if (maxCover >= nums.length-1) {
                return true;
            }
        }
        return false;
    }


    /**
     * dfs超时
     */
    boolean res =false;
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        if(n==1){
            return  true;
        }

        dfs(nums,0,n-1);
        return  res;

    }
    void dfs(int[] nums,int nowIndex,int len){


        if((len-nowIndex)<=nums[nowIndex]){
            res = true;
            return;
        }
        // 不再继续遍历
        if(!res){

            int jumpLength = nums[nowIndex];
            while (jumpLength>0){
                if(nowIndex+jumpLength<len) {
                    dfs(nums, nowIndex + jumpLength, len);
                }

                jumpLength--;
            }

        }
    }
}
