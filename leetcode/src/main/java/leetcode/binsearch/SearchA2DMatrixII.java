package leetcode.binsearch;

public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0 ) {
            return false;
        }

        int row = matrix.length - 1, column = matrix[0].length - 1;
        int x = row, y = 0;

        while (x >= 0 && y <= column) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                return true;
            }
        }

        return false;
    }
}
