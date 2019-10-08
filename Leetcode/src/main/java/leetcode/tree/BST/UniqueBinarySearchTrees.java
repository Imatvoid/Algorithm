package leetcode.tree.BST;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangxu
 * @Date: 2019/10/4 下午1:14
 */
public class UniqueBinarySearchTrees {

    /**
     *
     * @param n
     * @return
     */
    public int numTreesDP(int n) {
        int[] G = new int[n + 1];
        //序列长度为 1 （只有根）或为 0 （空树）时，只有一种情况。  空树也要考虑
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    /**
     * 卡塔兰数 C=1  C = C * 2 * (2 * i + 1) / (i + 2);
     * @param n
     * @return
     */
    public int numTrees(int n) {
        // Note: we should use long here instead of int, otherwise overflow
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }



}
