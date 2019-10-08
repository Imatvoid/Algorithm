`283. Move Zeroes`
<https://leetcode.com/problems/move-zeroes/>

`283. 移动零`
<https://leetcode-cn.com/problems/move-zeroes/>

## 描述
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:
```
输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
```
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

## 思路1

采用重插入的方式
```java
public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
```


## 思路2

删除容易 , 只不过还要保持相对顺序。

我们可以采用压缩数组的方式,只要遇到0,就把之后的元素都向前复制一位。

```java
public void moveZeroes2(int[] nums) {


        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zip(nums, i);
                len--;
                i--;
            }

        }


    }

    public void zip(int[] nums, int index) {
        int temp = index;
        for (int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = 0;

    }
```


