package leetcode.binsearch;

public class MedianOfTwoSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        // 注意这里要除以2.0
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    /**
     *
     * @param nums1
     * @param i 数组nums1的开始位置
     * @param nums2
     * @param j 数组nums2的开始位置
     * @param k 查找第k个数字
     * @return
     */
    int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        // 数组nums1已经遍历完成 直接在nums2中查找.
        if(i>=nums1.length) return nums2[j+k-1];
        // 同上
        if(j>=nums2.length) return nums1[i+k-1];

        // 查找第1个元素,直接从两个数组头部返回
        if(k==1) return Math.min(nums1[i],nums2[j]);

        // 如果nums1中已经不存在第k/2个数字,
        // 比如nums1={0},
        //     nums2={0,1,2,3}
        //     查找第4个数字,k=4,k/2=2, i=0, j=0 ,i+k/2-1 = 1
        //     可以直接在nums2中排除0 1,因为无论nums1中的数字大还是小,都只有3个数字.
        //     所以nums2的起始j向后移动k/2,从index=2继续函数,第k-k/2=2个数字
        if (i+k/2-1 >= nums1.length){
            return findKth(nums1,i,nums2,j+k/2,k-k/2);
        }
        // 同上
        if (j+k/2-1 >= nums2.length){
            return findKth(nums1,i+k/2,nums2,j,k-k/2);
        }

        // 比如nums1={0,1},
        //     nums2={0,2,2,3}
        //     查找第4个数字,k=4,k/2=2, i=0, j=0 ,i+k/2-1 = 1
        //     由于nums1[1]>nums2[1],所以nums1的起始i向后移动k/2,从index=2继续函数,第k-k/2=2个数字
        if(nums1[i+k/2-1] < nums2[j+k/2-1]){
            return findKth(nums1,i+k/2,nums2,j,k-k/2);
        }else {
            return findKth(nums1,i,nums2,j+k/2,k-k/2);
        }

    }

}
