import leetcode.linkedlist.ListNode;
import leetcode.tree.TreeNode;

import javax.crypto.spec.PSource;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Prac {

    public List<Integer> lexicalOrder(int n) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer one, Integer another) {

                String oneStr = String.valueOf(one);
                String anotherStr = String.valueOf(another);
                int len1=oneStr.length();
                int len2=anotherStr.length();
                int len = Math.min(len1,len2);

                int k = 0;
                while (k < len) {
                    if (oneStr.charAt(k) != anotherStr.charAt(k)) {
                        return oneStr.charAt(k) - anotherStr.charAt(k);
                    }
                    k++;
                }

                return len1-len2;
            }
        });
        return list;
    }

    static class A{
        private Boolean b;
//      自动拆箱,null拆箱报错
//        public boolean getB() {
//            return b;
//        }

        public Boolean getB() {
            return b;
        }
    }



    public static void main(String[] args) throws InterruptedException {
        //System.out.println("a".compareTo("ab"));
        //System.out.println("ac".compareTo("b"));

    }


}
