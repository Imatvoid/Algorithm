package leetcode.math.easy;

public class ReverseInteger {

    public int reverse(int x) {
        int res  = 0;
        int t =Math.abs(x);


        while(t>0){
            if(res>Integer.MAX_VALUE/10){
                return  0;
            }
            res = res*10 + t%10;
            t=t/10;
        }
        return x>0 ? res : -res;
    }
}
