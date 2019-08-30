`39. Combination Sum`

<https://leetcode.com/problems/combination-sum/>

`39. 组合总和`

<https://leetcode-cn.com/problems/combination-sum/>

### 描述

给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:
```
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
```
示例 2:
```
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```

### 思路

```java
List<List<Integer>> res = new LinkedList();

    /**
     * candidates，不包含重复的数字 每个数可以用多次
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       dfs(candidates,new LinkedList<>(),0,target);
       return  res;

    }

    void dfs(int[] candidates, List<Integer> list, int start, int remain) {
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i <candidates.length ; i++) {
            list.add(candidates[i]);
            // 注意这是要传入i 这是组合
            dfs(candidates,list,i,remain-candidates[i]);
            list.remove(list.size()-1);

        }

    }
```

