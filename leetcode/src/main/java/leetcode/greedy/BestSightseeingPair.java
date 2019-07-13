package leetcode.greedy;

public class BestSightseeingPair {

    // A[i] + A[j] + i - j
    // A[i] + i + A[j] - j
    // 做法完全一样,也是扫一遍数组,维护两个值,一个是a[i]+i的最大值,另一个是a[i]+a[j]+i-j的最大值.


    public int maxScoreSightseeingPair(int[] A) {
        int aii = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <A.length ; i++) {
            if(max < A[i]-i + aii){
                max =  A[i]-i + aii;
            }

            if(A[i]+i>aii) aii = A[i]+i;

        }
        return  max;

    }
}
