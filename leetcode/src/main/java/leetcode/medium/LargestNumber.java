package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {

        Integer [] list = new Integer[nums.length];

        for(int i =0;i<nums.length; i++){
            list[i] = nums[i];
        }


        Arrays.sort(list, new Comparator<Integer>(){

            public int compare(Integer o1, Integer o2) {

                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                if(Long.parseLong(s1+s2) > Long.parseLong(s2+s1)){
                    return  -1;
                }else{
                    return  1;
                }

            }


        });

        StringBuilder sb = new StringBuilder();
        for(int i : list){
            sb.append(i);
        }


        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();

    }

    public static void main(String[] args) {
       System.out.println(new LargestNumber().largestNumber(new int[]{128,12}));
    }
}
