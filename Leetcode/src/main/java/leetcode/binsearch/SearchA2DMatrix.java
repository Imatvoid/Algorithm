package leetcode.binsearch;

public class SearchA2DMatrix {

    /**
     * 暴力
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

       int m = matrix.length;
       int n = matrix[0].length;
       if(m == 0){
        return  false;
       }

       int index = -1;
       for(int i =1 ;i<m; i++){
           if(matrix[i][0] >= target ){
               index = i-1;
           }
       }
       if(index != -1){
           for(int i =0 ;i<n; i++){
               if(target == matrix[index][i]){
                  return true;
               }
           }

       }
       return  false;

    }

    /**
     * 二分
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col;

        while(left < right) {
            int mid = left + (right - left) / 2;
            int r = mid / col;
            int c = mid % col;
            if(matrix[r][c] == target) {
                return true;
            }

            if(matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
