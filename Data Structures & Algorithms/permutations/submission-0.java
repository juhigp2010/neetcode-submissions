class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, new ArrayList<>(), used, result);
        return result; 
    }
    private void backtrack(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
        // Base case: if the current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current)); // Create a deep copy of the current list
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // If the element is already used in the current permutation path, skip it
            if (used[i]) {
                continue;
            }

            // Make a choice
            current.add(nums[i]);
            used[i] = true;

            // Recurse to explore deeper paths
            backtrack(nums, current, used, result);

            // Undo the choice (backtrack)
            used[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
