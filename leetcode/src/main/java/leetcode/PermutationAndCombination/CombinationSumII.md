`40. Combination Sum II`

<https://leetcode.com/problems/combination-sum-ii/>

`40. 组合总和 II`

<https://leetcode-cn.com/problems/combination-sum-ii/>

### 描述

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:
```
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```
示例 2:
```
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
```

### 思路

先排序,然后过滤。

```java
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
```
