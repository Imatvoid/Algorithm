package leetcode.math;

public class Pow {
    public double myPow(double x, int n) {
        int m = n < 0 ? -(n + 1) : n;  //如果n是负数，要避免n=-2147483648溢出
        double p = 1;
        double q = x;
        while (m >= 1) {
            if ((m & 1) != 0) p *= q;  //一旦该位为1，那么将q乘入p中
            //System.out.println(q);
            q *= q;  //m每次除2，q就要变为平方
            m = m >> 1;
        }
        return n < 0 ? 1 / (p * x) : p;
    }
}
