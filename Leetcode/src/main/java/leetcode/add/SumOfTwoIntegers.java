package leetcode.add;

public class SumOfTwoIntegers {


    public int getSum(int a, int b) {
        while (b != 0) {
            int originA = a;
            a = a ^ b;
            b = (originA & b) << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(-2,3));
    }

    public int getSum2(int a, int b) {

        return b==0 ? a:getSum((a^b),(a & b)<<1);
    }
}
