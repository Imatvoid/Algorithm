`46. Permutations`

<https://leetcode.com/problems/permutations/>


`46. 全排列`

<https://leetcode-cn.com/problems/permutations/>

### 描述

Given a collection of distinct integers, return all possible permutations.

Example:

Input: `[1,2,3]`
Output:
```
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```
### 思路1

交换

```java
 List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        fullArray(nums, 0, nums.length - 1);
        return res;
    }


    private void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            //System.out.println(Arrays.toString(array));
            ArrayList<Integer> l = new ArrayList<Integer>();
            for (int i = 0; i < array.length; i++) {
                l.add(array[i]);
            }
            res.add(l);
        } else {
            for (int i = cursor; i <= end; i++) {
                swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                swap(array, cursor, i);
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
```

### 思路2

DFS

```java
   
     List<List<Integer>> res= new ArrayList<List<Integer>>();
    int [] flags;

    public List<List<Integer>> permute(int[] nums) {

           ArrayList<Integer> temp = new ArrayList<Integer>();
           flags = new int [nums.length];

           dfs(nums,temp,0,nums.length);

           return res;

    }

    void dfs(int [] nums,ArrayList<Integer> temp,int index,int length){

        if(temp.size()>=length){

            ArrayList<Integer> temp2 = new ArrayList<Integer>();
            temp2.addAll(temp);
            res.add(temp2);
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(flags[i]==0){
                flags[i]=1;
                temp.add(nums[i]);
                int size = temp.size();
                dfs(nums,temp,0,length);
                temp.remove(size-1);
                flags[i]=0;
            }
        }

    }
```


