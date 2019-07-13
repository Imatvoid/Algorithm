class Solution {
//    public int removeElement(int[] nums, int val) {

//             int len = nums.length;
//             for(int i =0;i<nums.length-(nums.length-len);i++){
//                 if(nums[i]==val){
//                     for(int j =i;j<nums.length-1;j++){
//                         nums[j]=nums[j+1];
//                     }
//                     i--;
//                     len--;
//                 }
//             }
//             return len;

//         }
    public int removeElement(int[] A, int elem) {
    int len = A.length;
    for (int i = 0 ; i< len; ++i){
        while (A[i]==elem && i< len) {
            A[i]=A[--len];
        }
    }
    return len;
}
}