15. 3Sum

<https://leetcode.com/problems/3sum/>

15. 三数之和

<https://leetcode-cn.com/problems/3sum/>
 

## Desc

Given an array `nums` of *n* integers, are there elements *a*, *b*, *c* in `nums` such that *a* + *b* + *c* = 0? Find all unique triplets in the array which gives the sum of zero.

**Note:**

The solution set must not contain duplicate triplets.

**Example:**

```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

## 描述

给定一个包含 *n* 个整数的数组 `nums`，判断 `nums` 中是否存在三个元素 *a，b，c ，*使得 *a + b + c =* 0 ？找出所有满足条件且不重复的三元组。

**注意：**答案中不可以包含重复的三元组。

```
例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

## 思路

先排序,然后找到一个数,再在剩余的数组里,找和为其相反数的两个数。

注意去除重复。

```java
List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            else {
                twoSum(nums, -nums[i], i);
            }
        }

        return res;

    }

    void twoSum(int[] nums, int target, int i) {

        int right = nums.length-1;
        int left =i+1;
        while(left<right){
            if(nums[left]+nums[right]<target){
                left++;
                continue;
            }
            else if(nums[left]+nums[right]>target){
                right--;
                continue;
            }
            else{
                ArrayList<Integer> t = new ArrayList<>();
                t.add(nums[i]);
                t.add(nums[left]);
                t.add(nums[right]);
                res.add(t);
                //处理重复的情况
                left++;
                right--;
                while(left<right && nums[left] == nums[left-1]) left++;
                while(left<right && nums[right] == nums[right+1]) right--;
            }
        }

    }
```
