class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums,new ArrayList<>(),result,0);
        return result;
    }
    private void subset(int[]nums,ArrayList<Integer> current,List<List<Integer>> result,int start)
    {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            subset(nums, current, result, i + 1);
            current.remove(current.size()-1);
        }
    }
}
