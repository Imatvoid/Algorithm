package leetcode.PermutationAndCombination;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
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


//------------------------------------------------------------------
    //List<List<Integer>> res= new ArrayList<List<Integer>>();
    int [] flags;

    public List<List<Integer>> permuteDFS(int[] nums) {

        flags = new int [nums.length];
        dfs(nums,new ArrayList<Integer>(),0,nums.length);
        return res;

    }

    void dfs(int [] nums,ArrayList<Integer> perms,int index,int length){

        if(perms.size()>=length){
            
            res.add(new  ArrayList<Integer>(perms));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(flags[i]==0){
                flags[i]=1;
                perms.add(nums[i]);
                int size = perms.size();
                dfs(nums,perms,0,length);
                perms.remove(size-1);
                flags[i]=0;
            }
        }

    }


}
