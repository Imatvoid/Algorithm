package leetcode.math.easy;

/**
 * @Author: yangxu
 * @Date: 2019/8/21 上午9:18
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(x==0) return true;

        int res  = 0;
        int t =x;
        while(t>0){
            if(res>Integer.MAX_VALUE/10){
                return  false;
            }
            res = res*10 + t%10;
            t=t/10;
        }
        return res == x ;

    }
}
