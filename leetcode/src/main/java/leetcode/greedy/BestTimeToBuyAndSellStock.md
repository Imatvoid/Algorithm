# 121.  Best Time to Buy and Sell Stock



tags: 

- leetcode 
- leetcode-leetcode.easy
- leetcode.greedy

## Desc

Say you have an leetcode.array for which the *i*th element is the price of a given stock on day *i*.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), leetcode.design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

**Example 1:**

```
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
```

**Example 2:**

```
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
```



## 描述

给定一个数组，它的第 *i* 个元素是一支给定股票第 *i* 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。





## 思路



对于第i天,记录前i-1天最小值,计算最大收益.

把当前值加入比较,更新最小值.

```java
 public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0){
            return 0;
        }
        // 记录数组最小值 
        int min = prices[0];
        int res = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i]-min>res){
                res = prices[i]-min;
            }
            // 更新最小值
            if(prices[i] < min){
                min = prices[i];
            }
        }
        return res;
    }
```

