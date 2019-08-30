package leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer one, Integer another) {

                String oneStr = String.valueOf(one);
                String anotherStr = String.valueOf(another);
                int len1 = oneStr.length();
                int len2 = anotherStr.length();
                int len = Math.min(len1, len2);

                int k = 0;
                while (k < len) {
                    if (oneStr.charAt(k) != anotherStr.charAt(k)) {
                        return oneStr.charAt(k) - anotherStr.charAt(k);
                    }
                    k++;
                }

                return len1 - len2;
            }
        });
        return list;
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(i, n, res);
        }
        return res;
    }

    /**
     * 10叉树
     * @param cur
     * @param n
     * @param res
     */
    public void dfs(int cur, int n, List<Integer> res) {
        if (cur > n)
            return;
        else {
            res.add(cur);
            for (int i = 0; i < 10; ++i) {
                if (10 * cur + i > n)
                    return;
                dfs(10 * cur + i, n, res);
            }
        }
    }
}
