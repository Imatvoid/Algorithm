`17. Letter Combinations of a Phone Number`

<https://leetcode.com/problems/letter-combinations-of-a-phone-number/>

`17. 电话号码的字母组合`

<https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/>


### 描述
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

![](https://assets.leetcode-cn.com/aliyun-lc-upload/original_images/17_telephone_keypad.png)


示例:
```
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

### 思路

典型dfs


```java

    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> res = new LinkedList<>();

    public List<String> letterCombinations(String digits) {
        // 边界条件
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        dfs(digits, 0, new StringBuilder());
        return res;
    }

    void dfs(String digits, int start, StringBuilder sb) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }

        //  for (int i = start; i < digits.length(); i++) {

        char[] cs = map.get(digits.charAt(start)).toCharArray();
        for (char c : cs) {
            sb.append(c);
            dfs(digits, start + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        // }

    }
``` 
