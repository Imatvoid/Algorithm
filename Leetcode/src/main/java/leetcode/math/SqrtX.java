package leetcode.math;

public class SqrtX {
    public int mySqrt(int x) {

//         double left =0;
//         double right =x+1;
//         while(right-left>0.001){
//           double t = (right+left)/2;
//           if(t*t<x){
//               left=t;
//           }else{
//               right=t;
//           }

//         }
//          System.out.println(left);
//          System.out.println(right);
//         return (int)right;

        if (x <= 1) return x;

        long left =0;
        long right =x+1;
        while(left<right){
            long t = left+(right-left)/2;
            System.out.println(t*t);
            if(t*t<=x){
                left=t+1;
            }else{
                right=t;
            }

        }
        // System.out.println(left);
        // System.out.println(right);
        return (int)(right-1);



    }

    int NewtonWork(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(new SqrtX().mySqrt(Integer.MAX_VALUE));
    }
}
