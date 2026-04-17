class Solution {
    public boolean hasDuplicate(int[] nums) {

        if(nums.length==0 | nums.length==1)
        return false;

        HashSet<Integer> al=new HashSet();

        for( int i=0; i<nums.length; i++)
        {
            if(al.contains(nums[i]))
            return true;
            else
            al.add(nums[i]);
        }

    return false;
        
    }
}