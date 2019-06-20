package leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO1 {

    /**
     *
     */
    class RandomizedSet {
        ArrayList<Integer> byIndex = new ArrayList<Integer>();
        HashMap<Integer, Integer> byValue = new HashMap<Integer, Integer>();
        Random rng = new Random();

        public RandomizedSet() {
        }

        public boolean insert(int val) {
            if (byValue.containsKey(val)) return false;
            byValue.put(val, byValue.size());
            byIndex.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!byValue.containsKey(val)) return false;
            byIndex.set(byValue.get(val), byIndex.get(byIndex.size() - 1));
            byValue.put(byIndex.remove(byIndex.size() - 1), byValue.get(val));
            byValue.remove(val);
            return true;
        }

        public int getRandom() {
            return byIndex.get(rng.nextInt(byIndex.size()));
        }

    }
}
