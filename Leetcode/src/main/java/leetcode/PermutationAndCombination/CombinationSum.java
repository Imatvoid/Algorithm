package leetcode.PermutationAndCombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.cnblogs.com/grandyang/p/4419259.html
 */
public class CombinationSum {


    List<List<Integer>> res = new LinkedList();

    /**
     * candidates，不包含重复的数字 每个数可以用多次
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       dfs(candidates,new LinkedList<>(),0,candidates.length,target);
       return  res;

    }

    void dfs(int[] candidates, List<Integer> list, int start, int n ,int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <n ; i++) {
            list.add(candidates[i]);
            // 注意这是要传入i 允许多次使用
            dfs(candidates,list,i,n,remain-candidates[i]);
            list.remove(list.size()-1);

        }

    }


    /**
     * 组合数的合2   candidates 包含重复数，但每个数只能用一次
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs2(candidates,new LinkedList<>(),0,target);
        return  res;
    }

    void dfs2(int[] candidates, List<Integer> list, int start, int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <candidates.length ; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            list.add(candidates[i]);
            // 注意这是要传入i+1 组合不能重复
            dfs2(candidates,list,i+1,remain-candidates[i]);
            list.remove(list.size()-1);

        }

    }
}
