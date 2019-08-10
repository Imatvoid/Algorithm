package leetcode.binsearch.easy;

public class FirstBadVersion {
    /**
     * 典型的二分
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        //bool isBadVersion(version)
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // return left;
        return left; // 也行
    }

    /*
    只是为了本地放代码不报错.
     */
    boolean isBadVersion(int b) {
        return true;
    }
}
