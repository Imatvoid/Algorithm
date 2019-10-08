package leetcode.dp;

public class LongestSubstringWithoutRepeatingCharacters {


    /**
     * dp 内存超出限制  s太长了
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        if(n==0){
            return 0;
        }
        int dp[][] = new int[n+1][n+1];

        // 从1 到 n
        for(int i =1;i<n+1;i++){
            dp[i][i]=1;
        }
        int max = 1;

        for(int i =1;i<n+1;i++){

            for(int j=i+1;j<n+1;j++) {

                String s1 = s.substring(i-1, j-1>n?n:j-1);

                if(!s1.contains(s.charAt(j-1)+"")) {
                    dp[i][j] =  dp[i][j - 1] +1;
                }else{
                    dp[i][j]=0;
                }
                if(dp[i][j]>max){
                    max= dp[i][j];
                }

            }
        }

        return  max;
    }

    public static void main(String[] args) {

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }
}
