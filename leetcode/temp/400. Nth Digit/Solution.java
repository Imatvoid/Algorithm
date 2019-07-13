class Solution {
    public int findNthDigit(int n) {
        int digit = 1 ;
        long len = 0;
        while(n>len){
            len = len +  (long)(9*digit*Math.pow(10,digit-1));
            digit++;
        }

        digit--;
        len-= (long)(9*digit*Math.pow(10,digit-1));
        n = n - (int)len;

        if(n%digit == 0){
            int num = (int)(Math.pow(10,digit-1))+ n/digit-1;
            String out   = String.valueOf(num);
            return out.charAt(out.length()-1)-'0';

        }else{
            int num = (int)(Math.pow(10,digit-1))+ n/digit-1;
            String out   = String.valueOf(++num);
            int p = n%digit;
            return  out.charAt(p-1)-'0';
        }

    }

}