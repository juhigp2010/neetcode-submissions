class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int count=0;
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                c=0;
            }
            else
            {
                c++;
                    count=Math.max(count,c);
            }
            

        }
        return count;
        
    }
}