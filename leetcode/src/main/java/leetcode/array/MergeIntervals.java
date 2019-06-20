package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length < 2)
            return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });

        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));


        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] top = result.get(result.size() - 1);
            if (top[1] < intervals[i][0]) {
                result.add(intervals[i]);
            } else {
                top[1] = Math.max(top[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}
