`77. Combinations`

<https://leetcode.com/problems/combinations/>

`77. 组合`

<https://leetcode-cn.com/problems/combinations/>

### 描述

给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:
```
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```


### 组合

```java
 List<List<Integer>> combs = new ArrayList<List<Integer>>();
    public  List<List<Integer>> combine(int n, int k) {

        combine(new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public  void combine(List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
```