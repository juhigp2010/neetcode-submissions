class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

    List<List<Integer>> al=new ArrayList();
    if(nums.length<=2)
    {
        return al;
    }
for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the current number is positive, no triplet can sum to 0.
            if (nums[i] > 0) break;

            // Skip the same value for the first element to avoid duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    al.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Increment left and decrement right while skipping duplicates.
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, move toward larger values.
                    left++;
                } else {
                    // Sum is too large, move toward smaller values.
                    right--;
                }
            }
        }
        return al;
    }
}
