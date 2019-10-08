package leetcode.PermutationAndCombination;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    List<List<Integer>> combs = new ArrayList<List<Integer>>();
    public  List<List<Integer>> combine(int n, int k) {

        combine(new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public  void combine(List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}
