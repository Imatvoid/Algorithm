## 背景

Twitter-Snowflake算法产生的背景相当简单，为了满足Twitter每秒上万条消息的请求，每条消息都必须分配一条唯一的id，这些id还需要一些大致的顺序（方便客户端排序），并且在分布式系统中不同机器产生的id必须不同。



## 实现核心

把时间戳，工作机器id，序列号组合在一起。

![snowflake-64bit](assets/分布式自增ID 雪花算法/snowflake-64bit.jpg)

除了最高位bit标记为不可用以外，其余三组bit占位均可浮动，看具体的业务需求而定。默认情况下41bit的时间戳可以支持该算法使用到2082年，10bit的工作机器id可以支持1023台机器，序列号支持1毫秒产生4095个自增序列id。



## 结构

snowflake的结构如下(每部分用-分开):

```
0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000
```

第一位为未使用，接下来的41位为毫秒级时间(41位的长度可以使用69年)，

然后是5位datacenterId和5位workerId(10位的长度最多支持部署1024个节点） 

最后12位是毫秒内的计数（12位的计数顺序号支持每个节点每毫秒产生4096个ID序号）

一共加起来刚好64位，为一个Long型。(转换成字符串长度为18)







## 参考

https://github.com/souyunku/SnowFlake