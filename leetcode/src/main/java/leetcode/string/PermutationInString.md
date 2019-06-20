## Permutation In String

tags: 

- leetcode 
- leetcode-leetcode.easy
- leetcode.string
- sliding-window

熟练度+1

#### 描述

Given two strings **s1** and **s2**, write a function to return true if **s2** contains the permutation of **s1**. In other words, one of the first leetcode.string's permutations is the **substring** of the second leetcode.string.

 

**Example 1:**

```
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
```

**Example 2:**

```
Input:s1= "ab" s2 = "eidboaoo"
Output: False
```

 

**Note:**

1. The input strings only contain lower case letters.
2. The length of both given strings is in range [1, 10,000].

#### 中文描述

s1是否包含反转的s2





#### 思路

滑动窗口法+hash