package leetcode.hashmap;

import java.util.HashSet;

public class ContainsDuplicate {

    /*hash 或者排序*/
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int n : nums){
            // 常数时间复杂度
            if( !hset.contains(n) )
                hset.add(n);
            else
                return true;
        }
        return false;
    }
}
