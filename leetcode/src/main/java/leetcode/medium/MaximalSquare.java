package leetcode.medium;

public class MaximalSquare {


    int res = 0;

    public int maximalSquare(char[][] matrix) {



        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    countArea(matrix, i, j, m, n);
                }

            }
        }

        return res;

    }

    void countArea(char[][] matrix, int i, int j, int m, int n) {
        int len = 0;

        int temp1 = i;
        int temp2 = j;

        while (temp1 < m && temp2 < n && matrix[temp1][temp2] == 1) {
            len++;
            temp1++;
            temp2++;
        }
        boolean flag = true;

        for (int k = i; k < i + len - 1; k++) {
            for (int l = j; l < j + len - 1; l++) {
                if (matrix[k][l] != 1) {
                    flag =false;
                    break;
                }

            }
        }

        if ( flag && res < len * len) {
            res = len * len;
        }


    }
    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(
                new char[][]{{1, 1, 0, 1},
                             {1, 1, 0, 1},
                             {1, 1, 1, 1}}
                       ));
    }
}
