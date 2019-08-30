`3. Longest Substring Without Repeating Characters`

<https://leetcode.com/problems/longest-substring-without-repeating-characters/>

`3. 无重复字符的最长子串`

<https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/>


###  描述

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:
```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```
示例 2:
```
输入: "bbbbb"
输出: 1
```
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
```
输入: "pwwkew"
输出: 3
```
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。



### 思路

经典的滑动窗口法.

```java
public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int res = 0;

        //至少两个元素
        int[] map = new int[128];
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (map[s.charAt(end)] == 0) {
                map[s.charAt(end)]++;
                if (end -start +1  > res) res = end -start +1;
                end ++;
            }else {
                //存在重复
                map[s.charAt(start)]--;
                start++;
            }
        }
       return  res;

    }
```