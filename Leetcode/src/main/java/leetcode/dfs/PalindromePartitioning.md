`131. Palindrome Partitioning`

<https://leetcode.com/problems/palindrome-partitioning/>

`131. 分割回文串`

<https://leetcode-cn.com/problems/palindrome-partitioning/>


### 描述
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例:

输入: "aab"
输出:
````
[
  ["aa","b"],
  ["a","a","b"]
]
````

### 思路

dfs , start 思路

```java
List<List<String>> res = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {

        if (s.length() == 0) return res;
        dfs(new ArrayList<String>(), 0, s);
        return res;
    }

    public void dfs(List<String> temp, int start, String s) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(temp));
            return;
        }

        for (int i = 1; start + i <= s.length(); i++) {

            String t = s.substring(start, start + i);
            if (isPalin(t)) {
                temp.add(t);
                dfs(temp, start + i, s);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalin(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
```
