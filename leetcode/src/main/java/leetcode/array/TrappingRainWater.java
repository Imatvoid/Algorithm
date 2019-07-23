package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrappingRainWater {

    public int trapTimeLimited(int[] height) {
        if(height==null || height.length <2){
            return 0;
        }


        int res = 0;


        int  []copy = Arrays.copyOf(height,height.length);
        Arrays.sort(copy);
        int pre = copy[copy.length-2];

        for (int i = 1; i <=pre ; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < height.length; j++) {
                if(height[j]>=i){
                    list.add(j);
                }
            }
            if(list.size()>=2){
                for (int k = 1; k < list.size(); k++) {
                    res += list.get(k)-list.get(k-1)-1;
                }
            }
        }

        return res;

    }
}
