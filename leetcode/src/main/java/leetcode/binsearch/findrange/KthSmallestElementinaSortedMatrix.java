package leetcode.binsearch.findrange;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {

    /**
     * 尽量少的空间复杂度,
     * 查找第一个不小于目标值的数字,
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int L = matrix[0][0], R = matrix[n - 1][n - 1];
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            int temp = search_lower_than_mid(matrix, n, mid);
            if (temp < k) L = mid + 1;
            else R = mid;
        }
        return L;
    }

    /**
     * 返回的是第一个大于x的数，前面数的个数。
     * @param matrix
     * @param n
     * @param x
     * @return
     */
    private static int search_lower_than_mid(int[][] matrix, int n, int x) {
        int i = n - 1, j = 0, cnt = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= x) {
                j++;
                cnt += i + 1;
            } else i--;
        }
        return cnt;
    }


    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 14, 15}};

        // System.out.println(search_lower_than_mid(nums,nums.length,8));

        //System.out.println(search_lower_than_mid(nums,nums.length,11));

        System.out.println(new KthSmallestElementinaSortedMatrix().kthSmallest(
                nums, 8));
    }


    /**
     * 堆, 优先级队列
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest2(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                heap.add(matrix[i][j]);
                if (heap.size() > k) heap.poll();
            }
        }
        return heap.poll();

    }
}
