package leetcode.math;

import java.util.Arrays;

public class CountPrimes {


    /**
     * 求小于n的质数个数
     * @param n
     * @return
     */
    public int countPrimes(int n) {

        int res = 0;
        boolean []prime = new  boolean [n];
        Arrays.fill(prime,true);
        for (int i = 2; i*i < n; ++i) {
            if (prime[i]) {
                //++res;
                for (int j = 2; i * j < n; ++j) {
                    prime[i * j] = false;
                }
            }
        }
        // 2 - n-1
        for (int i = 2; i < n; i++) {
            if(prime[i]){
                res++;
            }
        }



        return res;

    }
}
