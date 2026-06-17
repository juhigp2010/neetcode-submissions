class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0)
        return;
        if(k==0)
        return;
        if(k>nums.length)
        {
            k=k%nums.length;
        }
       for(int i=0;i<k;i++)
         {  rotateRight(nums);}
        
    }
    private static void rotateRight(int [] nums)
    {
       int temp=nums[nums.length-1];
       for(int i=nums.length-1;i>0;i--)
       {
            nums[i]=nums[i-1];
       }
       nums[0]=temp;
    }
}