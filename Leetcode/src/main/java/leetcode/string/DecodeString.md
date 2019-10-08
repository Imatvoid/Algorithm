`94. Decode String`

<https://leetcode-cn.com/problems/decode-string/>


`394. 字符串解码`

<https://leetcode.com/problems/decode-string/>

## 描述
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:
```
s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
```

## 思路
需要两个Stack,一个存放数字,一个存放str.

注意数字可能是123这种连续的.

一旦遇到`[`,就把res先保存起来. 遇到`]`则取出.与num*res叠加.
```java
 public String decodeString(String s) {
        Stack<Integer> numS = new Stack<>();
        Stack<String> resS = new Stack<>();

        char[] cs = s.toCharArray();
        String res = "";

        for (int i = 0; i < cs.length; i++) {
            if (Character.isDigit(cs[i])) {
                int count = 0;
                while (Character.isDigit(cs[i])) {
                    count = count * 10 + cs[i] - '0';
                    i++;
                }
                // 这里要小心
                i--;
                numS.push(count);
                continue;
            }
            if (cs[i] == '[') {
                resS.push(res);
                res ="";
                continue;
            }
            if (cs[i] == ']' ) {
                StringBuilder sb =new StringBuilder(resS.pop());
                int count = numS.pop();
                while (count>0){
                 count--;
                 sb.append(res);
                }
                res = sb.toString();
                continue;
            }
           res += cs[i];
        }
        return res;

    }

```