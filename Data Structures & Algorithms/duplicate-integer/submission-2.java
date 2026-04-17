class Solution {
    public boolean hasDuplicate(int[] nums) {

        if(nums.length==0 | nums.length==1)
        return false;

        HashSet<Integer> al=new HashSet();

        for( int n : nums)
        {
            if(al.contains(n))
            return true;
            else
            al.add(n);
        }

    return false;
        
    }
}