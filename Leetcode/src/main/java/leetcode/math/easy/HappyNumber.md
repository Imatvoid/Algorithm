`202. Happy Number`
<https://leetcode.com/problems/happy-number/>

`202. 快乐数`
<https://leetcode.com/problems/happy-number/>

## 描述


## 思路

编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

示例: 
```
输入: 19
输出: true
解释: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```
## 思路

实现这个过程, 用set存储中间经历过的状态,如果重复返回false,否则继续

```java
public boolean isHappy(int n) {
        Set<Integer> set =new HashSet<>();
        while (true) {
            int a = getPow(n);
            if(set.contains(a)){
                return false;
            }
            if(a==1){
                return true;
            }
            set.add(a);
            n=a;
        }
    }

    public Integer getPow(int n) {
        int res = 0;
        while (n > 0) {
            res += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return res;
    }
```