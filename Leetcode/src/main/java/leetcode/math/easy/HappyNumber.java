package leetcode.math.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yangxu
 * @Date: 2019/8/23 上午8:19
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set =new HashSet<>();
        while (true) {
            int a = getPow(n);
            if(set.contains(a)){
                return false;
            }
            if(a==1){
                return true;
            }
            set.add(a);
            n=a;
        }
    }

    public Integer getPow(int n) {
        int res = 0;
        while (n > 0) {
            res += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return res;
    }
}
