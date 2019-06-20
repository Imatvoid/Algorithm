---
title: 395. Longest Substring with At Least K Repeating Characters(至少有K个重复字符的最长子串)
date: 2019-05-13 17:06:09
tags:
- leetcode leetcode.medium
- sliding window
- bit operation
categories:
- leetcode

---

## Desc

https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

## 描述

找到给定字符串（由小写字符组成）中的最长子串 **T** ， 要求 **T** 中的每一字符出现次数都不少于 *k* 。输出 **T** 的长度。

<!--more-->

**示例 1:**

```
输入:
s = "aaabb", k = 3

输出:
3

最长子串为 "aaa" ，其中 'a' 重复了 3 次。
```

**示例 2:**

```
输入:
s = "ababbc", k = 2

输出:
5

最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
```



## 滑动窗口

### 思路

尺取法。

循环i：1~26，分别计算恰好包含i种字母并且每种字母出现的次数大于等于k个的最长子串长度。

没法直接使用尺取法，因为不满足区间单调性，但是使用如上的方法却是可以的，因为子串中包含的字母种类数是满足区间单调性的。

```java
public int longestSubstring(String s, int k) {
      char[] str = s.toCharArray();
        int[] counts = new int[26];
        int max = 0;
        int kinds, start, end;
        int idx, unique, noLessThanK;


        for (kinds = 1; kinds <= 26; kinds++) {
            Arrays.fill(counts, 0);
            start = 0;
            end = 0;
            // 当前已有的字母种类
            unique = 0;
            noLessThanK = 0;
            while (end < str.length) {
                if (unique <= kinds) {
                    idx = str[end] - 'a';
                    if (counts[idx] == 0)
                        unique++;
                    counts[idx]++;
                    if (counts[idx] == k)
                        noLessThanK++;
                    end++;
                }
                // 已经容纳满足够种类的字母，缩减窗口
                else {
                    idx = str[start] - 'a';
                    if (counts[idx] == k)
                        noLessThanK--;
                    counts[idx]--;
                    if (counts[idx] == 0)
                        unique--;
                    start++;
                }
                if (unique == kinds && unique == noLessThanK)
                    max = Math.max(end - start, max);
            }
        }

        return max;
    }
```





## 暴力+位操作优化

### 思路

对于子串问题的暴力遍历是枚举起始位置.   

for (int i = 0; i < s.length(); i++) 

   for (int j = i; j < s.length(); j++) 

然后我们得到一个substring, 可以判断这个子串符不符合条件,如果符合就更新.

当然这其中可以有一些优化,比如起始位置的枚举是i + k <= s.length().

判断子串符不符合条件,可以用位运算的方式优化.用一个int 32的数字,共32bit,取其中26个位置代表26个字母,如果字母个数>k,对应位置=0,

否则,对应位置等于1.最后判断数字是否等于0即可判断是否满足条件.

```java
public int longestSubstring(String s, int k) {

        if (s.length() < k) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i + k <= s.length(); i++) {
            int map[] = new int[26];
            int mask = 0;
            int max_idx = i;
            for (int j = i; j < s.length(); j++) {
                int t = s.charAt(j) - 'a';
                map[t]++;
                if (map[t] < k) mask |= (1 << t);
                else mask &= (~(1 << t));
                if (mask == 0) {
                    max_idx = j;
                    res = Math.max(res, j - i + 1);
                }
            }
            i = max_idx;
        }
        return res;
    }
```





## 参考

https://www.cnblogs.com/wangyiming/p/9614954.html