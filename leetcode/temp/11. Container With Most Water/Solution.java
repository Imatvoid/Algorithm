class Solution {
    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {

            int temp = end - start;
            int h = height[start] > height[end] ? height[end] : height[start];
            if (temp * h > max) {
                max = temp * h;
            }

            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }


        }
        return  max;


    }


}