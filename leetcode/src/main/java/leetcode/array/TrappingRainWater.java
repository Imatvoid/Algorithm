package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TrappingRainWater {
    /**
     * 自我重复测试的空方法
     *
     * @param height
     * @return
     */
    public int trapTimeLimited2(int[] height) {
        return 0;
    }


    // ----------------------------------------答案------------------------------------------------------

    public int trap(int[] A) {

        if (A == null || A.length < 2) {
            return 0;
        }
        int L = 0;
        int R = A.length - 1;
        int lmax = -1;
        int rmax = -1;
        int water = 0;
        while (L < R) {

            lmax = Math.max(lmax, A[L]);
            rmax = Math.max(rmax, A[R]);
            if (lmax < rmax) {
                water += lmax - A[L];
                L++;
            } else {
                water += rmax - A[R];
                R--;
            }
        }
        return water;

    }


    public int trapTimeLimited(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int res = 0;


        int[] copy = Arrays.copyOf(height, height.length);
        Arrays.sort(copy);
        int pre = copy[copy.length - 2];

        for (int i = 1; i <= pre; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i) {
                    list.add(j);
                }
            }
            if (list.size() >= 2) {
                for (int k = 1; k < list.size(); k++) {
                    res += list.get(k) - list.get(k - 1) - 1;
                }
            }
        }

        return res;

    }


}
