package leetcode.add;

import java.util.LinkedList;

public class PlusOne {


    public int[] plusOne(int[] digits) {

        LinkedList<Integer> list = new LinkedList<Integer>();

        int plus[] = new int[]{1};
        int i = digits.length-1, j = plus.length-1;
        int over = 0;
        while (i >= 0|| j >= 0) {
            int a = (i >= 0) ? digits[i--] : 0;
            int b = (j >= 0) ? plus[j--] : 0;
            int sum = (a + b + over) % 10;
            over = (a + b + over) / 10;
            list.addFirst(sum);

        }
        if (over == 1) {
            list.addFirst(1);
        }
        int[] res = new int[list.size()];
        int k=0;
        for(int num :list){
            res[k++]=num;
        }
        return res;

    }

    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{1,2,3});
    }
}
