class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates); // Crucial for skipping duplicates
        backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void backtrack(List<List<Integer>> results, List<Integer> currentList, int[] candidates, int remaining, int start) {
        if (remaining == 0) {
            results.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > remaining) break;

            currentList.add(candidates[i]);
            backtrack(results, currentList, candidates, remaining - candidates[i], i + 1);
            
            currentList.remove(currentList.size() - 1);
        }
    }
    
}
