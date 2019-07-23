package leetcode.add;

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {

        return b==0 ? a:getSum((a^b),(a & b)<<1);
    }


    /**
     * 非递归版本
     */
    public int getSum2(int a, int b) {
        while (b!=0)
        {
            int c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }


}
