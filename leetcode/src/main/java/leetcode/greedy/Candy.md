# 135. Candy(分糖果问题)



## Desc

There are *N* children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to(根据) the following requirements:

- Each child must have at least one candy.
- Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

**Example 1:**

```
Input: [1,0,2]
Output: 5
Explanation: You can allocate(分配) to the first, second and third child with 2, 1, 2 candies respectively.
```

**Example 2:**

```
Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
```



## 描述

老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

示例 1:

输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
示例 2:

输入: [1,2,2]
输出: 4
解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。



### 传统的两轮遍历法

1. 先给每人发一个, res += ratings.length;
2. 从前向后遍历
3. 从后向前遍历

```java
 public int candy ( int[] ratings){
            // 边界条件
            if (ratings == null || ratings.length == 0) {
                return 0;
            }
            int res = 0;
            res += ratings.length;
            int[] t = new int[ratings.length];
            Arrays.fill(t,1);
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    
                    int temp =Math.abs(t[i]-t[i-1])+1;
                    t[i]+=temp;
                    res+=temp;
                }
            }
            
            for (int i = ratings.length - 1; i >= 1; i--) {
                // 这里注意
                if (ratings[i - 1] > ratings[i] && t[i-1] <= t[i]) {
                    int temp =Math.abs(t[i]-t[i-1])+1;
                    t[i-1]+=temp;
                    res+=temp;
                }
            }
            return res;

        }
```









