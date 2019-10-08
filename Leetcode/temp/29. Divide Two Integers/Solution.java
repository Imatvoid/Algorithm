class Solution {
   
        
     public int divide(int dividend, int divisor) {

        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
            return Integer.MAX_VALUE;
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dividendAbs = (long) Math.abs(dividend+0.0);

        long divisorAbs =(long) Math.abs(divisor+0.0);

        int res = 0;
        while(dividendAbs >= divisorAbs){
              long temp = divisorAbs, multiple = 1;
            while (dividendAbs >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dividendAbs -= temp;
            res += multiple;

        }

        return sign == 1 ? res : -res;

    }
           
}