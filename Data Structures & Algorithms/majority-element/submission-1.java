class Solution {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0)
        return 0;
        int count=1;
        int res=0;
        for(int j=1;j<nums.length;j++)
        {
            if(nums[res]==nums[j])
            {count++;}
            else
            {
                count--;
            }
            if(count==0)
            {
                res=j;
                count=1;
            }
        }
        return nums[res];
    }
}