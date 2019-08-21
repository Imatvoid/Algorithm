package leetcode.pqtk;

import java.util.*;

public class TopKFrequentWords {

    /**
     * 优先级队列
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> result = new LinkedList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(

                (a, b) -> {
                    return a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue();
                }
        );
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        while (result.size() < k) {
            result.addLast(pq.poll().getKey());
        }


        return result;

    }

    public static void main(String[] args) {
        System.out.println("a".compareTo("c"));
        System.out.println("a".compareTo("ccc"));
        System.out.println("a".compareTo("aa"));
    }
}
