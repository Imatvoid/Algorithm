package leetcode.bitmanipulation;

class MajorityElement {

    /**
     * 一个数字和其他数字出现的次数不一样，都可以这样做。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int res =0;
        for(int i=0;i<32;i++){
            int sum =0;
            for(int n:nums){
                sum+= (n>>i)&1;
            }
            if(sum>(nums.length/2)){
                res |= 1<<i;
            }
        }
        return res;

    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElementMoore(int[] nums) {

        int res = 0, cnt = 0;
        for (int num : nums) {
            if (cnt == 0) {res = num; ++cnt;}
            else if(num == res) {++cnt;}
            else{
                --cnt;
            }
        }
        return res;

    }
}
