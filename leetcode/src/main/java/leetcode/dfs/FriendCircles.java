package leetcode.dfs;

public class FriendCircles {
    int visited[];

    public int findCircleNum(int[][] M) {
        int m = M.length;
        if (m == 0) {
            return 0;
        }
        int count = 0;
        visited = new int[M[0].length];
        for (int i = 0; i < m; i++) {
            if (visited[i] == 0) {
                dfs(M, i);
                count++;
            }
        }


        return count;
    }

    void dfs(int[][] M,int i){
        for(int j=0;j<M[0].length;j++){
            if(M[i][j]==1 && visited[j] == 0){
                visited[j]=1;
                dfs(M,j);
            }
        }
    }
}
