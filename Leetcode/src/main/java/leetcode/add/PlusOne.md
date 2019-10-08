原文链接:
<https://leetcode-cn.com/problems/plus-one/>
<https://leetcode.com/problems/plus-one/>
<!-- more -->
## 描述
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
```
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
```
示例 2:
```
输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
```

## 思路
和[leetcode-add](https://imatvoid.github.io/tag/41zWzzRyW/)标签下其他的题思路一样的,只不过输入换成了数组.
求和有两步操作:  
1.对应位相加,%进制,取得余数

2.如果有进位,/进制,拿到进位.

后面不过是迭代这两步操作.
一个小trick是,在最后,可能你还有一个进位,别忘了.

## 代码
```java
 public int[] plusOne(int[] digits) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        int plus[] = new int[]{1};
        int i = digits.length-1, j = plus.length-1;
        int over = 0;
        while (i >= 0|| j >= 0) {
            int a = (i >= 0) ? digits[i--] : 0;
            int b = (j >= 0) ? plus[j--] : 0;
            int sum = (a + b + over) % 10;
            over = (a + b + over) / 10;
            list.addFirst(sum);

        }
        if (over == 1) {
            list.addFirst(1);
        }
        int[] res = new int[list.size()];
        int k=0;
        for(int num :list){
            res[k++]=num;
        }
        return res;

    }
```
