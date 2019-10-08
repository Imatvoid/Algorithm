45. Jump Game II

<https://leetcode-cn.com/problems/jump-game-ii/submissions/>

45. 跳跃游戏 II

<https://leetcode.com/problems/jump-game-ii/submissions/>

## 描述
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:
```
输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。
```

## 思路

贪心算法:

此题的核心方法是利用贪婪算法Greedy的思想来解，想想为什么呢？ 

为了较快的跳到末尾，我们想知道每一步能跳的范围，这里贪婪并不是要在能跳的范围中选跳力最远的那个位置，因为这样选下来不一定是最优解，这么一说感觉又有点不像贪婪算法了。

我们这里贪的是一个能到达的最远范围，我们遍历当前跳跃能到的所有位置，然后根据该位置上的跳力来预测下一步能跳到的最远距离，贪出一个最远的范围，一旦当这个范围到达末尾时，当前所用的步数一定是最小步数。



```java
    public int jump(int[] nums) {
        int n = nums.length;

        int limit = 0, max = 0, res = 0, cur = 0;
        while (max < n - 1) {
            res++;
            limit = max;
            for (; cur <= limit; cur++) {
                max = Math.max(max, cur + nums[cur]);
            }
            if (limit == max) return -1;
        }
        return res;

    }
```
