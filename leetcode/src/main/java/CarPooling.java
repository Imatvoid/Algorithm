import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < trips.length; i++) {
            int[] t = trips[i];

            int start = t[1];
            int end = t[2];
            for (int j = start; j <= end; j++) {

                List<Integer> l1= map.getOrDefault(j, new LinkedList<>());
                l1.add(t[0]);
                map.put(j,l1);
            }
            LinkedList<Integer> l2 = new LinkedList<>();
            map.getOrDefault(end, l2).add(-t[0]);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int sum = 0;
            for (int i : entry.getValue()) {
                sum += i;
            }
            if (sum > capacity) {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
       new CarPooling().carPooling(new int[][]{  {2,1,5},{3,3,7}},4);
    }
}
