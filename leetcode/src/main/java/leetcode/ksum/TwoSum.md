1. Two Sum

<https://leetcode.com/problems/two-sum/>

1. 两数之和

<https://leetcode-cn.com/problems/two-sum/>


## Desc

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,  

Because nums[0] + nums[1] = 2 + 7 = 9,  
return [0, 1]  

## 中文描述
在一个数组中,找出两个数,他们的和是target,返回他们的下标。  

nums = [2, 7, 11, 15], target = 9,

return [0, 1]

## 思路
hashmap
```java
   /**
     * hash map
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int [] res= new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i =0;i<nums.length;i++){
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }else{
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                break;
            }
        }
        return  res;
    }
```


更推荐下边这种双指针

```java
 /**
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] sorted= new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);

        int left=0;
        int right= nums.length-1;

        while(left<right){
            if(sorted[left]+sorted[right]<target){
                left++;
            }
            else if(sorted[left]+sorted[right]>target){
                right--;

            }
            else{
                break; //found it! sorted[left]+sorted[right]==target
            }
        }
        //find the index in nums
        int index1 =-1;
        int index2= -1;

        for(int i=0; i<sorted.length; i++){
            if(nums[i]==sorted[left] || nums[i]==sorted[right]){
                if(index1 == -1){
                    index1=i;
                }
                else{
                    index2=i;
                }
            }
        }

        //leetcode.sort the final result
        int [] result= {index1, index2};
        Arrays.sort(result);
        return result;

    }
```


