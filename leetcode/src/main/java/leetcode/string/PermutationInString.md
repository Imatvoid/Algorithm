
`567. Permutation in String`

<https://leetcode.com/problems/permutation-in-string/>

`567. 字符串的排列`

<https://leetcode-cn.com/problems/permutation-in-string/>


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

给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:
````
输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").
 
````
示例2:
````
输入: s1= "ab" s2 = "eidboaoo"
输出: False
 
````
注意：

输入的字符串只包含小写字母
两个字符串的长度都在 `[1, 10,000]` 之间


#### 思路

滑动窗口法+hash

一个字符串的排列可以转化为hash
```java
/**
     * 滑动窗口+hash
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int a[] = new int[26];
        int b[] = new int[26];
        for (char c : s1.toCharArray()) {
            a[c - 'a']++;
        }
        for (int i = 0; i < s2.length() && (i + s1Len-1) <s2.length(); i++) {

            for (int k = i; k < i + s1Len; k++) {
                b[s2.charAt(k) - 'a']++;
            }

            boolean flag = true;
            for (int j = 0; j < a.length; j++) {
                if (a[j] != b[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
            Arrays.fill(b, 0);

        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int s1Len = s1.length();
        int a[] = new int[26];
        int b[] = new int[26];
        for (char c : s1.toCharArray()) {
            a[c - 'a']++;
        }

        // 初始化滑动窗口
        for (int i = 0; i < s1Len; i++) {
            b[s2.charAt(i) - 'a']++;

        }
        if (Arrays.equals(a, b))
            return true;

        for (int i = s1Len; i <s2.length(); i++) {
            b[s2.charAt(i - s1Len) - 'a']--;
            b[s2.charAt(i) - 'a']++;
            if (Arrays.equals(a, b))
                return true;
        }


        return false;


    }
```