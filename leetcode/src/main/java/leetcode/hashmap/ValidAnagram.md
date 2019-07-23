## 242. Valid Anagram

### Desc

Given two strings *s* and *t* , write a function to determine if *t* is an anagram of *s*.

**Example 1:**

```
Input: s = "anagram", t = "nagaram"
Output: true
```

**Example 2:**

```
Input: s = "rat", t = "car"
Output: false
```

**Note:**
You may assume the leetcode.string contains only lowercase alphabets.

**Follow up:**
What if the inputs contain unicode characters? How would you adapt your solution to such case?



### 描述

验证变位词

### 思路



拿数组当hash表 ,字母 => 对应次数,统计两次，一次增加，一次减少。如果hash数组里最后存在不为0的项，那就不是换位词。

```java
 /**
     * 拿数组当hash表 ,字母 =》 对应次数
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 一共26个字母
        int[] alphabet = new int[26];
        //s.charAt(i) - 'a' 这也算一个小点
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;

    }
```

