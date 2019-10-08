package leetcode.dp;

/**
 * @Author: yangxu
 * @Date: 2019/8/10 下午9:15
 */
public class PaintFence {

//      public int numWays(int n, int k) {
//          return process(n,k,1,false);
//      }

//      public int process(int n,int k,int i,boolean flag){

//          if(i==n && flag==true){
//              return k-1;
//          }
//          if(i==n && flag==false){
//              return k;
//          }
//          if(i==1){
//              return process(n,k,i+1,false)*k;
//          }
//          return flag==false?process(n,k,i+1,true)+process(n,k,i+1,false)*(k-1):process(n,k,i+1,false)*(k-1);
//      }
    //   public int numWays(int n,int k){
    //     if(n==0||k==0){
    //         return 0;
    //     }
    //     if(n==1){
    //         return k;
    //     }
    //     int[][] dp = new int[n+1][2];
    //     dp[n][0] = k;
    //     dp[n][1] = k-1;
    //     for(int i=n-1;i>1;i--){
    //         dp[i][0] = dp[i+1][1]+dp[i+1][0]*(k-1);
    //         dp[i][1] = dp[i+1][0]*(k-1);
    //     }
    //     dp[1][0] = dp[2][0]*k;
    //     dp[1][1] = dp[2][0]*k;
    //     return dp[1][0];
    // }

    // public int numWays(int n, int k) {
    //       if(n == 0 || k == 0) return 0;
    //       int[][] dp = new int[n][2];
    //       dp[0][0] = 0;
    //       dp[0][1] = k;
    //       // dp[i][0] 为第i个中重复颜色的方案数
    //       // dp[i][1] 为第i个中不重复颜色的方案数
    //       for(int i=1; i<n; i++) {
    //           dp[i][0] = dp[i-1][1];
    //           dp[i][1] = (dp[i-1][0] + dp[i-1][1]) * (k-1);
    //       }
    //       return dp[n-1][0] + dp[n-1][1];
    //   }



    public int numWays(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n==1) return k;

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;
        if(n <= 2){
            return dp[n];
        }
        for(int i = 3; i < n+1; i++){
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
    public int numWays1(int n, int k) {
        if(n == 0 || k == 0) return 0;
        if(n==1) return k;

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;
        dp[2] = k * k;
        if(n <= 2){
            return dp[n];
        }
        for(int i = 3; i < n+1; i++){
            dp[i] = (k - 1) * (dp[i - 2] + dp[i - 2]*k);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new PaintFence().numWays1(4,3));
        System.out.println(new PaintFence().numWays(4,3));
    }
}
