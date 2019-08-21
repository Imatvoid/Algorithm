package leetcode.sort;

import java.util.Stack;

public class KthLargestElementInAnArray {

    /**
     * 非递归写法
     *
     * @param arr
     * @param k
     * @return
     */
    public int findKthLargest2(int[] arr, int k) {

        Stack<int[]> stack = new Stack<int[]>();

        stack.push(new int[]{0, arr.length - 1});
        while (!stack.isEmpty()) {
            int[] index = stack.pop();
            int pivotIndex = partition(arr, index[0], index[1]);
            if (pivotIndex == k - 1) {
                return arr[k - 1];
            }

            if (pivotIndex < k - 1) {
                stack.push(new int[]{pivotIndex + 1, index[1]});
            } else {
                stack.push(new int[]{index[0], pivotIndex - 1});
            }
        }

        return -1;


    }


    /**
     * 递归写法
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {


        int start = 0;
        int end = nums.length - 1;
        // 此步可以省略
        // k = nums.length - (k - 1);
        while (true) {
            int pivotIndex = partition(nums, start, end);

            if (pivotIndex == k - 1) {
                return nums[k - 1];
            }

            if (pivotIndex < k - 1) {
                start = pivotIndex + 1;
            } else {
                end = pivotIndex - 1;
            }
        }


    }

    /**
     * 单指针法
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    int partition(int[] arr, int start, int end) {
        // 这里都要用start

        // 选取一个基准
        int pivot = arr[start];

        // 基准的最终位置
        int mark = start;
        // 这里的start+1 和<=要小心
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > pivot) {
                // if (arr[i] < pivot) {
                mark++;
                int tmp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = tmp;
            }
        }

        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;


    }




    public static void main(String[] args) {
        new KthLargestElementInAnArray().partition(new int[]{3, 2, 1, 5, 6, 4}, 0, 5);

        int res = new KthLargestElementInAnArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 4);
        System.out.println(res);
    }


}
