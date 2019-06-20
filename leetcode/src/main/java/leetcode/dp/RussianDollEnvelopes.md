# 354. Russian Doll Envelopes

tags: 

- leetcode 

- leetcode-hard

- leetcode.dp



## Desc

You have a number of envelopes with widths and heights given as a pair of integers `(w, h)`. One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

**Note:**
Rotation is not allowed.

**Example:**

```
Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
```



## 描述

给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 `(w, h)` 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

**说明:**
不允许旋转信封。

**示例:**

```
输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出: 3 
解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
```



## 思路

### 前置

普通dp做法,dp数组初始化为1,因为只要输入不是空.

 [[1,1]] 返回 1

i代表排序后的第i个信封.此时遍历数组,思路类似LIS最长上升子序列问题.

```java
 if(list.get(i).w>list.get(j).w && list.get(i).h>list.get(j).h) {
    leetcode.dp[i] = Math.max(leetcode.dp[i], leetcode.dp[j] + 1);
 }
```





### 二分查找优化



使用二分查找法来优化速度，给信封排序，但是这次排序和上面有些不同，信封的宽度还是从小到大排，但是宽度相等时，我们让高度大的在前面。那么现在问题就简化了成了找高度数字中的LIS问题

原有排序

[5,4],[6,4],[6,7],[2,3]  -> [2,3] [5,4] [6,4] [6,7]

现在排序

[5,4],[6,4],[6,7],[2,3]  -> [2,3] [5,4] [6,7] [6,4]

```java
public int maxEnvelopes(int[][] envelopes) {

        if(envelopes == null || envelopes.length==0){
            return 0;
        }

        Arrays.leetcode.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
//        System.out.println(list.toString());
//        int leetcode.dp [] = new int[envelopes.length];
//        Arrays.fill(leetcode.dp,1);
//
//        for (int i = 0; i <envelopes.length ; i++) {
//            for (int j = 0; j < i ; j++) {
//                if(list.get(i).w>list.get(j).w && list.get(i).h>list.get(j).h) {
//                    leetcode.dp[i] = Math.max(leetcode.dp[i], leetcode.dp[j] + 1);
//                }
//            }
//            res = Math.max(res, leetcode.dp[i]);
//        }
//        for(int i=0;i<leetcode.dp.length;i++){
//            System.out.println(leetcode.dp[i]);
//        }
//        return res;
        int leetcode.dp [] = new int[envelopes.length];
        leetcode.dp[0] = envelopes[0][1];
        int len=0;
        for (int i = 1; i < envelopes.length; i++) {
           int v = envelopes[i][1];
           if(leetcode.dp[len]<v){
               leetcode.dp[++len] = v;
           }
           else {
               int index = binarySearch(leetcode.dp, len, v);
               leetcode.dp[index] = v;
           }
        }

        return len+1;

    }

    /**
     * 二分查找 查找插入位置 不小于
     * @param leetcode.dp
     * @param len
     * @param val
     * @return
     */
    private int binarySearch(int[] leetcode.dp, int len, int val) {
        int start = 0;
        while(start <= len) {
            int mid = start + (len - start) / 2;

            if(leetcode.dp[mid] < val) {
                start = mid + 1;
            }
            else {
                len = mid - 1;
            }
        }
        return start;
    }
```