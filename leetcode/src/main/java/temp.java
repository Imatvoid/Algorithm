import java.util.*;

import static java.util.Arrays.copyOf;

public class temp {


    public int[][] merge(int[][] intervals) {


        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0)
            return new int[][]{};

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
//        Arrays.leetcode.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a1, int[] a2) {
//                return a1[0] - a2[0];
//            }
//        });


        ArrayList<int[]> res = new ArrayList<>();
        int[] prev = new int[]{0, 0};
        prev = intervals[0];
        int i = 1;
        while (i < intervals.length) {
            int[] cur = intervals[i];
            if (prev[1] < cur[0]) {
                res.add(prev);
                prev = cur;
                i++;
            } else {
                //int[] newCur = new int[]{Math.min(cur[0], prev[0]), Math.max(cur[1], prev[1])};

                prev[1] = Math.max(prev[1], cur[1]);
                // prev = newCur;
                i++;
            }
        }
        res.add(prev);

        return res.toArray(new int[res.size()][2]);
    }


    public int trap(int[] height) {
        Stack<Integer> st = new Stack();
        int i = 0, res = 0, n = height.length;
        while (i < n) {
            if (st.isEmpty() || height[i] <= height[st.peek()]) {
                st.push(i++);
            } else {
                int t = st.peek();
                st.pop();
                if (st.isEmpty()) continue;
                res += (Math.min(height[i], height[st.peek()]) - height[t]) * (i - st.peek() - 1);
            }
        }
        return res;

    }


    public int numDecodings(String s) {

        if (s.isEmpty() || (s.length() >= 1 && s.charAt(0) == '0')) return 0;


        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                dp[i + 1] = 0;
            } else {
                dp[i + 1] = dp[i];
            }

            if (i >= 1 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {

                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[n];

    }


    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                    continue;
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                    continue;
                }
                if (p.charAt(j) == '*') {
                    //a* only counts as empty
                    if( dp[i+1][j-1]){
                        dp[i+1][j+1] =true;
                        continue;
                    }

                    //a* only counts as empty
                    if (p.charAt(j-1) == s.charAt(i) || p.charAt(j-1) == '.') {
                        dp[i+1][j+1] = dp[i][j+1];  //in this case, a* counts as multiple a

                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }





        public static void main(String[] args) {

Integer.M

//        new temp().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
//
//        Random random = new Random();
//        ArrayList<int[]> res = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//           res.add(new int[]{random.nextInt(100),random.nextInt(100)});
//        }
//        Long start = System.nanoTime();
//        new temp().merge(res.toArray(new int[res.size()][2]));
//        System.out.println(System.nanoTime()-start);
//
//        res.clear();
//        start = System.nanoTime();
//        for (int i = 0; i < 1000; i++) {
//            res.add(new int[]{random.nextInt(1000),random.nextInt(1000)});
//        }
//        System.out.println(System.nanoTime()-start);
//
//        res.clear();
//        start = System.nanoTime();
//        for (int i = 0; i < 10000; i++) {
//            res.add(new int[]{random.nextInt(10000),random.nextInt(10000)});
//        }
//        System.out.println(System.nanoTime()-start);


//        1793296   64771817
//        1401815    1086015
//        2606232    2481080


    }






}
