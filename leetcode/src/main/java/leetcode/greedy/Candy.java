package leetcode.greedy;

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        // 边界条件
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int res = 0;
        res += ratings.length;
        int[] t = new int[ratings.length];
        Arrays.fill(t, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {

                int temp = Math.abs(t[i] - t[i - 1]) + 1;
                t[i] += temp;
                res += temp;
            }
        }

        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i] && t[i - 1] <= t[i]) {
                int temp = Math.abs(t[i] - t[i - 1]) + 1;
                t[i - 1] += temp;
                res += temp;
            }
        }
        return res;

    }

}
