class Solution {
    public int subsetXORSum(int[] nums) {
        return getXORSum(nums, 0, 0);
    }
    private int getXORSum(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }

        int include = getXORSum(nums, index + 1, currentXOR ^ nums[index]);
        int exclude = getXORSum(nums, index + 1, currentXOR);
        return include + exclude;
    }
}