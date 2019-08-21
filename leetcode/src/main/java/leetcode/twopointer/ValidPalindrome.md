`125. Valid Palindrome`

<https://leetcode.com/problems/valid-palindrome/>
`125. 验证回文串`

<https://leetcode-cn.com/problems/valid-palindrome/>

## 描述
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
``````
输入: "A man, a plan, a canal: Panama"
输出: true
``````
示例 2:
``````
输入: "race a car"
输出: false
``````


## 思路

使用两个指针遍历就行,注意跳过非法字符.



```java
 public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.equals(" ")) {
            return true;
        }

        int i=0, j=s.length()-1;
        while (i<j) {
            while (i<j && !isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i<j && !isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            char l = Character.toLowerCase(s.charAt(i));
            char r = Character.toLowerCase(s.charAt(j));

            if (l != r) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
```






