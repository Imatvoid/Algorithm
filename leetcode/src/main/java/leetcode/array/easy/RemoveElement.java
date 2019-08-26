package leetcode.array.easy;

/**
 * @Author: yangxu
 * @Date: 2019/8/26 下午11:27
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        int len = A.length;
        for (int i = 0; i < len; ++i) {
            while (A[i] == elem && i < len) {
                A[i] = A[--len];
            }
        }
        return len;
    }
}
