package leetcode.medium;

public class UniquePaths {


    public int uniquePaths(int m, int n) {

        // 保证m是比较大的 。
        if(m<n){
            int temp = n;
            n = m;
            m =temp;
        }
        int count1 = m+n-2;
        long sum1 = 1;
        //  m+n-2 ...m-1  不会溢出
        for(int i = count1; i>m-1 ;i--){
            sum1 *= i;
        }
        for(int i = n-1 ;i>=1;i--){
            sum1 /=i;
        }

        return (int)sum1;


    }

    public static void main(String[] args) {
       System.out.println( new UniquePaths().uniquePaths(13,23));
    }
}
