package summary.sort;

import java.util.Stack;

public class QuickSort {

    /**
     * 非递归版本
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSortNoRecursion(int[] arr, int start, int end) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, end});
        while (!stack.isEmpty()) {
            int[] index = stack.pop();
            int pivotIndex = partition(arr, index[0], index[1]);

            // 这里两个条件判断
            if (index[0] < pivotIndex - 1) {
                stack.push(new int[]{index[0], pivotIndex - 1});
            }
            if (pivotIndex + 1 < index[1]) {
                stack.push(new int[]{pivotIndex + 1, index[1]});
            }
        }



    }

    /**
     * 递归版本
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    /**
     * 单边循环法
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] arr, int start, int end) {

        int mark = start;
        int pivot = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < pivot) {
                mark++;
                int temp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = temp;
            }
        }

        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 7, 5, 6, 2, 8, 1};
        quickSort(arr, 0, 7);
        System.out.println();
    }
}
