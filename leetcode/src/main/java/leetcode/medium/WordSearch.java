package leetcode.medium;

public class WordSearch {

    boolean res = false;
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        int [][] flags = new int [m][n];
        for(int i = 0 ;i< m ;i++){
            for(int j = 0 ;j< n ;j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(board,flags,i,j,word,0);
                }
                if(res){
                    break;
                }
            }

        }
        return  res;

    }

    /**
     * 暴力搜索 time limit exceeded 注意这不是找组合或者排列，有一种情况符合就可以停止了
     * @param board
     * @param flags
     * @param i
     * @param j
     * @param word
     * @param index
     */
    void dfs(char[][] board,int [][]flags,int i, int j,String word,int index){

        if(i<0 || i>m-1 || j<0 || j>n-1){
            return;
        }
        // 已经被使用
        if(flags[i][j] == 1){
            return;
        }
        if(board[i][j] == word.charAt(index) && index == word.length() -1){
            res =true;
            return;
        }
        if(board[i][j] == word.charAt(index)){
            flags[i][j] = 1;
            if(!res){
            dfs(board,flags,i+1,j,word,index + 1);
            }
            if(!res) {
                dfs(board, flags, i - 1, j, word, index + 1);
            }
            if(!res) {
                dfs(board, flags, i, j + 1, word, index + 1);
            }
            if(!res) {
                dfs(board, flags, i, j - 1, word, index + 1);
            }
            flags[i][j] = 0;
        }

    }
}
