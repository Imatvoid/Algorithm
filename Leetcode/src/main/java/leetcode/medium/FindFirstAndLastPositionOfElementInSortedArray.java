package leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {


    public int[] searchRange(int[] nums, int target) {



        int ress = -1;
        int rese = -1;

        int start = 0 ,end =nums.length-1;

        while (start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] > target){
                end = mid -1;
                continue;
            }
            if(nums[mid] < target){
                start = mid + 1;
                continue;
            }
            int temp = mid;

            // equals
            while ( mid   <nums .length && nums[mid] == target){
                rese = mid ;
                mid ++;
            }


            mid =temp;

            while ( mid   >=0 && nums[mid] == target){
                ress = mid ;
                mid --;
            }
            break;



        }



        if(ress != -1  && rese != -1){
            return  new int[]{ress,rese};
        }

        return new int[]{-1,-1};


    }

    public static void main(String[] args) {
        System.out.println(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{2,2},3));
    }
}
