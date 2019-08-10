import leetcode.linkedlist.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Prac {


    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Prac().search(new int[]{1,3},3));

    }

    public int search(int[] nums, int target) {


        int left = 0;
        int right = nums.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            //左边有序 小 - 大
            if (nums[mid] > nums[right]) {

                if (nums[left] <= target && nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }


        }

        return -1;
    }


}
