package leetcode.binsearch;

import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix {

    /**
     * 尽量少的空间复杂度,
     * 查找第一个不小于目标值的数字,
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n =     matrix.length;

        // 查找第一个不小于目标值的数字
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1] ;
        // 二分查找的数组是从lo 到 hi
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = n-1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j+1);
            }

            if(count < k) lo = mid+1;
            else hi=mid-1;
        }
        return lo;

    }

    public static void main(String[] args) {
        new KthSmallestElementinaSortedMatrix().kthSmallest(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 14, 15}
        },8);
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
