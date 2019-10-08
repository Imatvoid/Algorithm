## HouseRobber

动态规划

抽象描述： 
一个系统，有若干状态，每个状态下有若干合法的操作,称为决策,决策会改变系统状态决策会带来收益（或费用） 
在初始状态下，求最终状态下最大收益 
在每个阶段，选择一些决策，状态随之改变 
收益只取决与当前状态和决策（无后效性）——不是马尔可夫 
使得系统达到终止状态时，总收益最大（或费用最小）

总收益一般指各阶段收益的总和
动态规划是在状态集合上的递推：f(new state)=f(old state)+payoff(decision)


实际等于递归加缓存


参考     
https://blog.csdn.net/zxm1306192988/article/details/80627205
https://www.cnblogs.com/mjbjtunlp/p/5930553.html