`171. Excel Sheet Column Number`

<https://leetcode.com/problems/excel-sheet-column-number/>

`171. Excel表列序号`

<https://leetcode-cn.com/problems/excel-sheet-column-number/>

## 介绍
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
```
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
```    

Example 3:
```
Input: "ZY"
Output: 701
```

## 思路

```java
     public int titleToNumber(String s) {
                 char[] cs = s.toCharArray();
                 int len = cs.length;

                 int res = 0;
                 int temp = 1;
                 for(int i = cs.length-1;i>=0;i--){
                     int t = cs[i]-'A'+1;
                     res += t * temp;
                     temp *= 26;
                 }
                 return  res;
        }

```