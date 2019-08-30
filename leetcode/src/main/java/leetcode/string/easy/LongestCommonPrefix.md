`14. Longest Common Prefix`

<https://leetcode.com/problems/longest-common-prefix/>

`14. 最长公共前缀`

<https://leetcode-cn.com/problems/longest-common-prefix/>

### 描述
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。
__
示例 1:
````
输入: ["flower","flow","flight"]
````
输出: "fl"

示例 2:
````
输入: ["dog","racecar","car"]
输出: ""
````
解释: 输入不存在公共前缀。

说明:

所有输入只包含小写字母 a-z 。

### 思路

没什么好办法,遍历即可.

```java
public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length ==0) return "";

        if(strs.length ==1 )return strs[0];

        String pre = strs[0];
        int i=1;
        while(i<strs.length){

            for(;i<strs.length;i++){
                if(!strs[i].startsWith(pre)){
                    pre = pre.substring(0,pre.length()-1);
                    break;
                }
            }

        }
        return pre;

    }
```