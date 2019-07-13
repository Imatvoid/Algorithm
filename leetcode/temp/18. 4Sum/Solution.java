class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
            ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 3; i++) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    int start = j + 1;
                    int end = nums.length - 1;

                    while (start < end) {
                        int sum = nums[i] + nums[j] + nums[start] + nums[end];
                        if (sum == target) {
                            ArrayList<Integer> p = new ArrayList<>();
                            p.add(nums[i]);
                            p.add(nums[j]);
                            p.add(nums[start]);
                            p.add(nums[end]);
                            if (!res.contains(p)) {
                                res.add(p);
                            }
                            
                        }
                        if (sum < target) {
                            start++;
                        } else {
                            end--;
                        }


                    }


                }
            }

            return res;
        }
}