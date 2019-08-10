package leetcode.math;

/**
 * @Author: yangxu
 * @Date: 2019/8/10 下午2:55
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
