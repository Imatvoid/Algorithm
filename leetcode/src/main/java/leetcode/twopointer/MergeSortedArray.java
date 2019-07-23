package leetcode.twopointer;

public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        int i = m-1,j=n-1;
        int k = m+n-1;
        // k 永远不会将i的值覆盖，在A[i]的值被使用之前。因为k = m + n-1 极限情况是一直k-- j--，那么k会=m;
        while (i>=0 && j>=0){
            A[k--]=A[i]>B[j] ?A[i--] :B[j--];
        }

        // B还有没用完的 A数组中的已经都往后移了
        while (j>=0){
            A[k--]=B[j--];
        }
    }
}
