class Solution {
    public boolean hasDuplicate(int[] nums) {

        if(nums.length==0 | nums.length==1)
        return false;

        HashSet<Integer> al=new HashSet();

        for( int i=0; i<nums.length; i++)
        {
            al.add(nums[i]);
        }

        if(nums.length==al.size())
        return false;

        return true;
        
    }
}