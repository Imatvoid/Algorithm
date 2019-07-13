package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {

        if(envelopes == null || envelopes.length==0){
            return 0;
        }

        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
//        System.out.println(list.toString());
//        int dp [] = new int[envelopes.length];
//        Arrays.fill(dp,1);
//
//        for (int i = 0; i <envelopes.length ; i++) {
//            for (int j = 0; j < i ; j++) {
//                if(list.get(i).w>list.get(j).w && list.get(i).h>list.get(j).h) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        for(int i=0;i<dp.length;i++){
//            System.out.println(dp[i]);
//        }
//        return res;
        int dp [] = new int[envelopes.length];
        dp[0] = envelopes[0][1];
        int len=0;
        for (int i = 1; i < envelopes.length; i++) {
           int v = envelopes[i][1];
           if(dp[len]<v){
               dp[++len] = v;
           }
           else {
               int index = binarySearch(dp, len, v);
               dp[index] = v;
           }
        }

        return len+1;

    }

    /**
     * 二分查找 查找插入位置 不小于
     * @param dp
     * @param len
     * @param val
     * @return
     */
    private int binarySearch(int[] dp, int len, int val) {
        int start = 0;
        while(start <= len) {
            int mid = start + (len - start) / 2;

            if(dp[mid] < val) {
                start = mid + 1;
            }
            else {
                len = mid - 1;
            }
        }
        return start;
    }


}
