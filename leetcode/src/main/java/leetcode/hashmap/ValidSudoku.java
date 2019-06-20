package leetcode.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
    /**
     * 嵌套hash
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        HashMap<Integer, HashSet<Character>> rowMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> regionMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    if (rowMap.get(i) == null) {
                        HashSet<Character> hset = new HashSet<>();
                        hset.add(board[i][j]);
                        rowMap.put(i, hset);
                    } else {
                        //
                        if (rowMap.get(i).contains(board[i][j])) {
                            return false;
                        }
                        rowMap.get(i).add(board[i][j]);

                    }

                    if (colMap.get(j) == null) {
                        HashSet<Character> hset = new HashSet<>();
                        hset.add(board[i][j]);
                        colMap.put(j, hset);
                    } else {
                        //
                        if (colMap.get(j).contains(board[i][j])) {
                            return false;
                        }
                        colMap.get(j).add(board[i][j]);

                    }


                    int region =(i/3+1)* (j/3+5);
                    if (regionMap.get(region) == null) {
                        HashSet<Character> hset = new HashSet<>();
                        hset.add(board[i][j]);
                        regionMap.put(region, hset);
                    } else {
                        //
                        if (regionMap.get(region).contains(board[i][j])) {
                            return false;
                        }
                        regionMap.get(region).add(board[i][j]);

                    }

                }


            }
        }

        return true;


    }

    public static void main(String[] args) {

        new ValidSudoku().isValidSudoku(new char[][]{
                {'.','.','5','.','.','.','.','.','6'},
                {'.','.','.','.','1','4','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','9','2','.','.'},
                {'5','.','.','.','.','2','.','.','.'},
                {'.','.','.','.','.','.','.','3','.'},
                {'.','.','.','5','4','.','.','.','.'},
                {'3','.','.','.','.','.','4','2','.'},
                {'.','.','.','2','7','.','6','.','.'}});
    }
}
