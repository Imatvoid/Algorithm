<https://leetcode.com/problems/encode-and-decode-tinyurl/>
<https://leetcode-cn.com/problems/encode-and-decode-tinyurl/>


## 描述
生成短链接.

## 思路
做题可以使用byteToHexStr再截取.

在实际中,应该使用分布式发号器(Distributed ID Generator)
64位的整数能表示的范围184467440737亿远远大于全球网页数量45亿。

而且这样可以支持一个长网址对应多个短网址。一般而言，一个长网址，在不同的地点，不同的用户等情况下，生成的短网址应该不一样，这样，在后端数据库中，可以更好的进行数据分析。

为了方便转化为字符串,一般使用62进制,字符串的一位可以是大小写字母加数字共62个字母.

一个7位的字符串,62^7=3521614606208627=35216亿.


其他的办法大概还有取HASH值的前N位，碰撞，不重复就为短网址.这样性能不高。




## 参考
https://www.zhihu.com/question/20103344