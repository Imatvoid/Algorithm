`315. Count of Smaller Numbers After Self`

<https://leetcode.com/problems/count-of-smaller-numbers-after-self/>

`315. 计算右侧小于当前元素的个数`

<https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/>


### Desc

You are given an integer array *nums* and you have to return a new *counts* array. The *counts* array has the property where `counts[i]` is the number of smaller elements to the right of `nums[i]`.

**Example:**

```
Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
```

### 描述

在自己右边找出比自己小的数 

### 思路 1. 二分插入

从右边开始,进行插入排序.插入排序的index,也就是右边比自己小的数的个数。

注意,这里的二分是查找,第一个不小于target的数.
```java

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> t = new ArrayList<Integer>();
        Integer [] res= new Integer[n];
        for (int i = nums.length- 1; i >= 0; --i) {
            int left = 0, right = t.size()-1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (t.get(mid) < nums[i] ) left = mid+1;
                else right = mid - 1;
            }
            // i是应该插入的index,也是比自己小的数的count.
            res[i] = left;
            t.add(left, nums[i]);
        }
        return new ArrayList<Integer>(Arrays.asList(res));
    }

```



### 思路 2. 线段树

   

