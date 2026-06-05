class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        // dp[i] will store the maximum money we can rob from the first i houses
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the DP table
        for (int i = 2; i < n; i++) {
            // Option 1: Rob the current house (nums[i]) + loot from 2 houses ago (dp[i-2])
            // Option 2: Skip the current house and keep the loot from the previous house (dp[i-1])
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        // The last element contains the maximum possible loot for all houses
        return dp[n - 1];
    }
}
