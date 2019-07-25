<https://leetcode.com/problems/repeated-dna-sequences/>
<https://leetcode-cn.com/problems/repeated-dna-sequences/>

## 描述

所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。

示例:
```
输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

输出: ["AAAAACCCCC", "CCCCCAAAAA"]
```

## 思路

不想节省空间的话可以直接使用set,需要节省空间的话,可以把字符序列转成整数


通过对Dicsuss讨论的学习，发现有人说上面native方法超时是因为字符串存储浪费了太多的空间和时间，因此可以考虑用整数存储，即二进制方法。这个思路非常简单，这里一共有四个字母：A，C，G，T。我们转换整数的思路如下：

A = 00，C = 01，G = 10，T = 11。

int key = 0, key = key << 2 | code(A|C|G|T)。

这样我们就很容易把一个字符串转换为整数了，上面公式不清楚的话，可以直接看转换代码：

```java
 private static int hashCode(String str) {
        int hash = 0;

        for (int i = 0; i < str.length(); i ++) {
            hash = hash << 2 | mapInteger(str.charAt(i));
        }

        return hash;
    }

    private static int mapInteger(char ch) {
        switch (ch) {
        case 'A':
            // 00
            return 0;
        case 'C':
            // 01
            return 1;
        case 'G':
            // 10
            return 2;
        case 'T':
            // 11
            return 3;
        default :
            return 0;
        }
    }
```
