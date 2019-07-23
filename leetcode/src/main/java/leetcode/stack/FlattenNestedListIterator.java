package leetcode.stack;

import java.util.*;

public class FlattenNestedListIterator {
    
    
      public interface NestedInteger {
 
              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();
 
              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();
 
              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }




    public class NestedIterator implements Iterator<Integer> {

          Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {

            for(int i = nestedList.size()-1;i>=0; i--){
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty()) {
                NestedInteger curr = stack.peek();
                if(curr.isInteger()) {
                    return true;
                }
                stack.pop();
                for(int i = curr.getList().size() - 1; i >= 0; i--) {
                    stack.push(curr.getList().get(i));
                }
            }
            return false;
        }
    }

    public class NestedIterator2 implements Iterator<Integer> {
        private Queue<Integer> queue;

        public NestedIterator2(List<NestedInteger> nestedList) {
            queue = new LinkedList<>();
            NestToQueue(nestedList);
        }

        private void NestToQueue(List<NestedInteger> nestedList) {
            for (NestedInteger item : nestedList) {
                if (item.isInteger()) {
                    queue.add(item.getInteger());
                } else {
                    NestToQueue(item.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
