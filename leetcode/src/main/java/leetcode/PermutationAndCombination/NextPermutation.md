`31. Next Permutation`

<https://leetcode-.com/problems/next-permutation/>

`31. 下一个排列`

<https://leetcode-cn.com/problems/next-permutation/>

### 描述
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。

````
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
````
### 思路

这道题让我们求下一个排列顺序，由题目中给的例子可以看出来，如果给定数组是降序，则说明是全排列的最后一种情况，则下一个排列就是最初始情况，可以参见之前的博客 Permutations。我们再来看下面一个例子，有如下的一个数组
````
1　　2　　7　　4　　3　　1

下一个排列为：

1　　3　　1　　2　　4　　7
````

那么是如何得到的呢，我们通过观察原数组可以发现，如果从末尾往前看，数字逐渐变大，到了2时才减小的，然后我们再从后往前找第一个比2大的数字，是3，那么我们交换2和3，再把此时3后面的所有数字转置一下即可，步骤如下：
````
1　　2　　7　　4　　3　　1

1　　3　　7　　4　　2　　1

1　　3　　1　　2　　4　　7
````

```java
 public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        boolean flag = false;
        for (int i = nums.length - 1; i >= 1; i--) {
            if(nums[i]>nums[i-1]){
                flag= true;
                for(int j=nums.length-1;j>0;j--){
                    if(nums[j]>nums[i-1]){
                        int temp = nums[i-1];
                        nums[i-1]=nums[j];
                        nums[j]=temp;
                        break;
                    }
                }

                reverse(i, nums.length-1,nums);
                break;
            }

        }
        if(!flag){
            reverse(0,nums.length-1,nums);
        }

    }


    public void reverse(int start, int end, int[] nums) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
```

