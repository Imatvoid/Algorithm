package summary.sort;

import java.util.Arrays;

public class QuickSort3way {

    public static void main(String[] args) {
      new QuickSort3way().sortArray(new int[] {-1,2,-8,-10});
    }


    public int[] sortArray(int[] nums) {
        sort2(nums,0,nums.length-1);
        return nums;
    }
    public void sort(int[] input, int lowIndex, int highIndex) {


        if (lowIndex >= highIndex) return;

        int lt=lowIndex;
        int gt=highIndex;
        int i=lowIndex+1;

        int pivotValue=input[lowIndex];


        while (i<=gt){


            if (input[i]<pivotValue){
                exchange(input, i++, lt++);
            }
            else if (pivotValue<input[i]){
                exchange(input, i, gt--);
            }
            else{
                i++;
            }


        }

        sort (input, lowIndex, lt-1);
        sort (input, gt+1, highIndex);


    }
    void exchange(int [] arr,int i,int j){
        if(i==j) return;
        arr[i] =  arr[i] + arr[j];
        arr[j] =  arr[i] - arr[j];
        arr[i] =  arr[i] - arr[j];


    }


    public static void sort2(int[] a, int left, int right) {
        if (left >= right) return;

        // Pointers
        int less  = left;  // The index of the first element of center part
        int great = right; // The index before the first element of right part


        { // Partitioning with one pivot
            /*
             * Use the third of the five sorted elements as pivot.
             * This value is inexpensive approximation of the median.
             */
            int pivot = a[left];

            /*
             * Partitioning degenerates to the traditional 3-way
             * (or "Dutch National Flag") schema:
             *
             *   left part    center part              right part
             * +-------------------------------------------------+
             * |  < pivot  |   == pivot   |     ?    |  > pivot  |
             * +-------------------------------------------------+
             *              ^              ^        ^
             *              |              |        |
             *             less            k      great
             *
             * Invariants:
             *
             *   all in (left, less)   < pivot
             *   all in [less, k)     == pivot
             *   all in (great, right) > pivot
             *
             * Pointer k is the first index of ?-part.
             */
            for (int k = less; k <= great; ++k) {
                if (a[k] == pivot) {
                    continue;
                }
                int ak = a[k];
                if (ak < pivot) { // Move a[k] to left part
                    a[k] = a[less];
                    a[less] = ak;
                    ++less;
                } else { // a[k] > pivot - Move a[k] to right part
                    while (a[great] > pivot) {
                        --great;
                    }
                    if (a[great] < pivot) { // a[great] <= pivot
                        a[k] = a[less];
                        a[less] = a[great];
                        ++less;
                    } else { // a[great] == pivot
                        /*
                         * Even though a[great] equals to pivot, the
                         * assignment a[k] = pivot may be incorrect,
                         * if a[great] and pivot are floating-point
                         * zeros of different signs. Therefore in float
                         * and double sorting methods we have to use
                         * more accurate assignment a[k] = a[great].
                         */
                        a[k] = pivot;
                    }
                    a[great] = ak;
                    --great;
                }
            }

            /*
             * Sort left and right parts recursively.
             * All elements from center part are equal
             * and, therefore, already sorted.
             */
            sort2(a, left, less - 1);
            sort2(a, great + 1, right);
        }

    }


}
