package leetcode.medium;

public class LargestRectangleInHistogram {


    public int largestRectangleArea(int[] heights) {

        int max = 0;
        for (int i = 0; i < heights.length; i++) {

            if ((i + 1 < heights.length) && heights[i] <= heights[i + 1]) {

                continue;
            }
            // 出现局部峰值

            int minlen = heights[i];

            for (int j = i; j >= 0; j--) {

                minlen = Math.min(heights[j], minlen);

                int area = minlen * (i - j + 1);

                max = area > max ? area :max;
            }


        }


        return max;

    }


}
