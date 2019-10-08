package leetcode.bitmanipulation.singlenum;

public class SingleNumber {
    /**
     * Single Number
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res =0;
        for(int i:nums){
            res ^=i;
        }
        return res;

    }


    /**
     * Single Number II
     * @param nums
     * @return
     */
    public int singleNumberII(int[] nums) {
        int res = 0;
        for(int i=0;i<32;i++){
            int sum =0;
            for(int j=0;j<nums.length;j++){
                // 这一位是否是1，是1就加1
                sum += (nums[j]>>i)&1;
            }
            if(sum%3!=0){
                // 将这个位置置为1
                res |= (1<<i);
            }
        }
        return res;

    }


    /**
     * Single Number III
     * @param nums
     * @return
     */
    public int[] singleNumberIII(int[] nums) {
        // 异或的含义是每一位，不同为1
        int result[] = new int[2];
        // 得到res1异或res2
        int xor = nums[0];
        for (int i=1; i<nums.length; i++)
        {
            xor ^= nums[i];
        }

        //int bit = xor & ~(xor-1);

        // 取出最右边不为1的位置
        int bit = (xor & -xor);
        int num1 = 0;
        int num2 = 0;

        for (int num : nums)
        {   // 根据结果不同分组，即使其中一个组个数为1，也没关系，它就是我们要找的。
            // 一个数字与0的异或是它本身。
            if ((num & bit) > 0)
            {
                num1 ^= num;
            }
            else
            {
                num2 ^= num;
            }
        }

        result[0] = num1;
        result[1] = num2;
        return result;

    }





}
