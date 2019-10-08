package leetcode.bitmanipulation.basic;

public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    /**
     * 把每一位取出来,看看是不是1，如果是1，就sum++
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int sum =0;
        for(int i=0;i<32;i++){
            sum +=(n>>i&1);
        }
        return sum;
    }
}
