package leetcode.dp.taildp;

public class ArithmeticSlices {
    //     public int numberOfArithmeticSlices(int[] A) {

//         int res = 0, len = 2, n = A.length;
//         for (int i = 2; i < n; ++i) {
//             if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
//                 ++len;
//             } else {
//                 if (len > 2) res += (len - 1) * (len - 2) * 0.5;
//                 len = 2;
//             }
//         }
//         if (len > 2) res += (len - 1) * (len - 2) * 0.5;
//         return res;

    //     }

    /**
     * DP 解法
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0, n = A.length;
        int dp [] = new int [n];
        for (int i = 2; i < n; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
            res += dp[i];
        }
        return res;
    }
}
