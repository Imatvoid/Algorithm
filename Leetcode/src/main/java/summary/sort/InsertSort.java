package summary.sort;

import java.util.Arrays;

public class InsertSort {


    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr, int start, int end) {


        //插入排序  
        // /外循环规定从第二个元素开始，将元素插入到已排好的数组中  
        for (int i = start + 1; i <= end; i++) {
            // 用key来表示插入的元素，若直接用a[i]表示，a[j+1]操作会更改a[i]的值 
            int key = arr[i];
            // j表示从已排好序的数组的最右边开始比较
            int j = i - 1;
            while (j >= 0 &&  arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;

            }
            // 此时的a[j]代表着被插入元素左边相邻的那个元素
            arr[j + 1] = key;

        }


    }


    public static void main(String[] args) {
        int t[] = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        insertSort(t, 0, t.length - 1);
        System.out.println();

    }
}
