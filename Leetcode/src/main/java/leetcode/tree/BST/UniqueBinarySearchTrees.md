`96. Unique Binary Search Trees`

<https://leetcode.com/problems/unique-binary-search-trees/>

`96. 不同的二叉搜索树`

<https://leetcode-cn.com/problems/unique-binary-search-trees/>

## 描述

## 思路
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:
``````
Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
``````

## 思路

```
1 2 3 4 
选中2为根节点，可能的情况为 = G(1) * G(2)  笛卡尔积
```

```java
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
            //G(n)
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

```



https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-leetcode/