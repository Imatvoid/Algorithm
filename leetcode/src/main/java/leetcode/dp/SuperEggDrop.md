---
title: 887. Super Egg Drop(鸡蛋掉落)
date: 2019-05-11 21:22:06
tags:
- LeetCode-Hard
- LeetCode-DP
categories:
- LeetCode
---



## Desc

[desc](https://leetcode.com/problems/super-egg-drop/)

## 描述

你将获得 `K` 个鸡蛋，并可以使用一栋从 `1` 到 `N`  共有 `N` 层楼的建筑。

每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。

你知道存在楼层 `F` ，满足 `0 <= F <= N` 任何从高于 `F` 的楼层落下的鸡蛋都会碎，从 `F` 楼层或比它低的楼层落下的鸡蛋都不会破。

每次*移动*，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 `X` 扔下（满足 `1 <= X <= N`）。

你的目标是**确切地**知道 `F` 的值是多少。

无论 `F` 的初始值如何，你确定 `F` 的值的最小移动次数是多少？

<!--more-->

**示例 1：**

```
输入：K = 1, N = 2
输出：2
解释：
鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
如果它没碎，那么我们肯定知道 F = 2 。
因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
```

**示例 2：**

```
输入：K = 2, N = 6
输出：3
```

**示例 3：**

```
输入：K = 3, N = 14
输出：4
```

**提示：**

1. `1 <= K <= 100`
2. `1 <= N <= 10000`

## 大意概括

经典的扔鸡蛋问题,常见2个鸡蛋100层楼



## 普通做法

### 思路

`O(K * N^2)`
首先，这个题比较绕。需要求一个最优决策使得步数最小，但是实际的步数是随着真实结果变化而变化的。
于是，为了保证在我们假设的步数内一定能够解完，我们可以假设每次决策都会得到最坏结果。

`leetcode.dp[n][k] `表示用k个鸡蛋测n层最少需要多少步。
我们可以枚举第一次在第i层扔鸡蛋，会得到两种结果:

1. 鸡蛋坏掉: 我们接下来需要面对的情形是: 用 k-1 个鸡蛋来测量 i-1 层，所以最少需要 `leetcode.dp[i-1][k-1] `步。
2. 鸡蛋没坏: 我们接下来要面对的情形是: 用 k 个鸡蛋来测量 n-i 层，所以最少需要` leetcode.dp[n-i][k] `步。
   因为我们总会面对最坏情况，所以，在第i层扔，会用 `max(leetcode.dp[i-1][k-1], leetcode.dp[n-i][k]) + 1` 步。

所以我们的递推式如下:
`leetcode.dp[n][k] = min{ max(leetcode.dp[i-1][k-1], leetcode.dp[n-i][k]) + 1 } (1 <= i <= n)`

```java
/**
     * 普通dp解法  O(KN^2)
     * @param K
     * @param N
     * @return
     */
    int superEggDrop(int K, int N) {
        int leetcode.dp[][] = new int [N+1][K+1];
        for (int i = 0; i <= N; i++) {
            leetcode.dp[i][0] = 0;
            leetcode.dp[i][1] = i;
        }

        for (int j = 2; j <= K; j++) {
            for (int i = 1; i <= N; i++) {
                leetcode.dp[i][j] = i;
                for (int k = 1; k < i; k++) {
                    leetcode.dp[i][j] = Math.min(leetcode.dp[i][j], Math.max(leetcode.dp[k-1][j-1], leetcode.dp[i-k][j]) + 1);
                }
            }
        }
        return leetcode.dp[N][K];
    }
```



## 更好的做法

### 思考

我们把这个问题换一种思路:
使用`leetcode.dp[m][k]`代表有K个鸡蛋,最多可以做M次移动,这时我们最多能判断出多少层中的结果.

DP递推等式是:
`leetcode.dp[m][k] = leetcode.dp[m - 1][k - 1] + leetcode.dp[m - 1][k] + 1`,
假设我们在X层扔鸡蛋,可以走M次,有K个鸡蛋
如果鸡蛋碎了, 我们能向下检查,层数是 `leetcode.dp[m - 1][k - 1]` .
如果没碎, 我们能向上检查,层数是`leetcode.dp[m - 1][k - 1]`.

𝑓𝑙𝑜𝑜𝑟(𝑒𝑔𝑔𝑠,𝑑𝑟𝑜𝑝𝑠)=𝑓𝑙𝑜𝑜𝑟(𝑒𝑔𝑔𝑠−1,𝑑𝑟𝑜𝑝𝑠−1)+𝑓𝑙𝑜𝑜𝑟(𝑒𝑔𝑔𝑠,𝑑𝑟𝑜𝑝𝑠−1)+1

```java
/**
     * O(KlogN) Time, O(NK) Space
     * @param K
     * @param N
     * @return
     */
    public int superEggDropBetter(int K, int N) {

        int[][] leetcode.dp = new int[N + 1][K + 1];
        int m = 0;
        while (leetcode.dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                leetcode.dp[m][k] = leetcode.dp[m - 1][k - 1] + leetcode.dp[m - 1][k] + 1;
        }
        return m;
    }
```



### 扩展

#### K=2,N=100
如果是K=2,N=100,那么可以比较形象的理解:

因为只有两个鸡蛋，所以第一个鸡蛋应该是按一定的间距扔，比如10楼，20楼，30楼等等，比如10楼和20楼没碎，30楼碎了，那么第二个鸡蛋就要做线性搜索，分别尝试21楼，22楼，23楼等等直到鸡蛋碎了，就能找到临界点。那么我们来看下列两种情况：

1. 假如临界点是9楼，那么鸡蛋1在第一次扔10楼碎掉，然后鸡蛋2依次遍历1到9楼，则总共需要扔10次。
2. 假如临界点是100楼，那么鸡蛋1需要扔10次，到100楼时碎掉，然后鸡蛋2依次遍历91楼到100楼，总共需要扔19次。

所以上述方法的最坏情况是19次，那么有没有更少的方法呢，上面那个方法每多扔一次鸡蛋1，鸡蛋2的线性搜索次数最多还是10次，那么最坏情况肯定会增加，所以我们需要让每多扔一次鸡蛋1，鸡蛋2的线性搜索最坏情况减少1，这样恩能够保持整体最坏情况的平衡，那么我们假设鸡蛋1第一次在第X层扔，然后向上X-1层扔一次，然后向上X-2层扔，以此类推直到100层，那么我们通过下面的公式求出X：

X + (X-1) + (X-2) + ... + 1 = 100 -> X = 14

所以我们先到14楼，然后27楼，然后39楼，以此类推，最坏情况需要扔14次。



#### K=3,N=100
如果是K=3,N=100,那么实际过程是:

我们可以求出实际M步数=9,那从几层开始尝试呢?

我们假设从X层开始扔,并且碎了,那么K=2,M=8,我们一定要可以确定剩余下面层中的结果

`DP[8][2]`可以覆盖的层数是36,可以用2个鸡蛋,8次,来确定下面的36层中的结果.

**所以X=37,我们第一次从37层开始丢.**

如果37层没碎,那么K=3,M=8,我们要再选一层X2丢

假设碎了,那么K=2,M=7,可以覆盖28层,所以X2=37+28+1=66,

**所以X2=66,我们第二次从66层开始丢**

如果66层没碎,那么K=3,M=7,我们要再选一层X3丢

假设碎了,那么K=2,M=6,可以覆盖21层,所以X3=66+21+1=88,

**所以X3=88,我们第三次从88层开始丢**

实际是先到37层, 然后66层, 88层.



## 参考

https://leetcode.math.stackexchange.com/questions/2012591/eggs-and-floors-puzzle-extended-generalized

https://sankalpiitr.wordpress.com/2012/03/02/the-2-eggs-problem-extended-to-3-eggs/