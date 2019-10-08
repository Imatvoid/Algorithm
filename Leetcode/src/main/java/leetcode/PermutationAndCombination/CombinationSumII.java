package leetcode.PermutationAndCombination;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {


    List<List<Integer>> res = new LinkedList();
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
