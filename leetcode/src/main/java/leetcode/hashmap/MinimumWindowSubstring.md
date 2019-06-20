## 76. Minimum Window Substring

### Desc

Given a leetcode.string S and a leetcode.string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

**Example:**

```
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
```

**Note:**

- If there is no such window in S that covers all characters in T, return the empty leetcode.string `""`.
- If there is such window, you are guaranteed that there will always be only one unique minimum window in S.





### 描述

最小窗口子串

这道题给了我们一个原字符串S，还有一个目标字符串T，让我们在S中找到一个最短的子串，使得其包含了T中的所有的字母，并且限制了时间复杂度为 O(n)





### 思路

滑动窗口，先向右拓展，再向左压缩。



https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems

