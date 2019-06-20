package leetcode.dp.easy;

public class MaximumSubarray {

    /**
     * 暴力  不推荐
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {

        int max =Integer.MIN_VALUE;

        for(int i = 0 ;i<nums.length;i++){
            int sum = 0;
            for(int j =i ;j<nums.length;j++){
                sum += nums[j];
                if(sum>max){
                    max =sum;
                }
            }
        }
        return  max;
    }


    public int maxSubArray1(int[] nums) {

        int len = nums.length;
        if (len == 0) {
            return 0;
        }


        int dp []  = new int[nums.length+1];
        dp[0]=nums[0];
        int max =nums[0];

        for(int i = 1;i<nums.length;i++){
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if(dp[i]>max){
                max = dp[i];
            }

        }

        return  max;
    }

    public int maxSubArray(int[] nums) {
        return divide(nums,0,nums.length-1);
    }
    public int divide(int[] nums,int start,int end){
        if(start>=end) return nums[start];//大于的情况就当是中间情况了
        int mid=(start+end)/2;
        int maxleft=divide(nums,start,mid-1);//左边最大和
        int maxright=divide(nums,mid+1,end);
        //计算包含中间的连续最大和
        int midl=nums[mid];
        for(int temp=mid-1,sum=nums[mid];temp>=start;temp--){//计算左边
            sum+=nums[temp];
            midl=midl>sum?midl:sum;
        }
        int midr=midl;
        for(int temp=mid+1,sum=midr;temp<=end;temp++){//计算右边
            sum+=nums[temp];
            midr=midr>sum?midr:sum;
        }
        return Math.max(maxleft,Math.max(maxright,midr));//最大子串在左边，最大子串在右边，或者包含中间那个数
    }


}
