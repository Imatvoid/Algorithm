package leetcode.dp;

import java.util.List;

public class Triangle {
    /**
     * 通用DP
     *
     * @param triangle
     * @return
     */
    public int minimumTotalDP(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int rowSize = triangle.size();

        int dp[][] = new int[rowSize + 1][rowSize + 1];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < rowSize; i++) {
            int colSize = i + 1;
            for (int j = 0; j < colSize; j++) {
                if (j == 0) {
                    dp[i + 1][j + 1] = dp[i - 1 + 1][j + 1] + triangle.get(i).get(j);
                } else if (j == colSize - 1) {
                    dp[i + 1][j + 1] = dp[i - 1 + 1][j - 1 + 1] + triangle.get(i).get(j);
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i - 1 + 1][j + 1], dp[i - 1 + 1][j - 1 + 1]) + triangle.get(i).get(j);
                }

                if (i == rowSize - 1 && dp[i + 1][j + 1] < res) {
                    res = dp[i + 1][j + 1];
                }

            }
        }

        // 打印DP数组 调试
//        for (int i = 0; i <dp.length ; i++) {
//            for (int j = 0; j <dp.length ; j++) {
//                System.out.print(dp[i][j]+ " " );
//            }
//            System.out.println();
//
//        }
        return res;


    }


    /**
     * DP O(N)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int rowSize = triangle.size();

        int dp[] = new int[rowSize];
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < rowSize; i++) {
            int colSize = triangle.get(i).size();

            for (int j = colSize - 1; j >= 0; j--) {
                // 第一个元素
                if (j == 0) {
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }
                // 倒数第一个元素
                else if (j == colSize - 1) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                }
                // 其他
                else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }
                if (i == rowSize - 1 && dp[j] < res) {
                    res = dp[j];
                }
            }
            // // 打印DP数组 调试
            //    for (int k = 0; k < dp.length; k++) {
            //        System.out.print(dp[k] + " ");
            //    }
            //   System.out.println();
        }


        return res;
    }


}
