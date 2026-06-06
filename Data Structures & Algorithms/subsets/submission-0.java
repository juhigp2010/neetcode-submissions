class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the backtracking process with an empty current subset and index 0
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add a copy of the current subset to the result list
        result.add(new ArrayList<>(currentSubset));

        // Explore further elements to create new subsets
        for (int i = start; i < nums.length; i++) {
            // 1. Include the current element
            currentSubset.add(nums[i]);
            
            // 2. Move to the next element and recurse
            backtrack(result, currentSubset, nums, i + 1);
            
            // 3. Backtrack: remove the element to try other combinations
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
