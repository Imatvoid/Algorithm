package leetcode.binsearch.findrange;

public class FindTheDuplicateNumber {
    /**
     * 改变原数组 但是很简单
     *
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
                i--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return nums[i];
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * nlogn find range 注意这里不是 find index left right 直接写枚举区间即可.
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        // 直接写区间
        int left = 1, right = n;
        // 结束left=right
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int i : nums) {
                if (i <= mid)
                    count++;
            }
            if (count > mid) {
                right = mid;

            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[]{1,2}));
    }

    /**
     * O(n)  链表成环
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int head = nums[0];
        while (head != slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return head;

    }
}
