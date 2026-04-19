class Solution {
    public int[] productExceptSelf(int[] nums) {

        int [] result =new int[nums.length];
        if(nums==null || nums.length==0)
        return result;
        result[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            result[i]=result[i-1]*nums[i-1];
        }
        int res1=1;
        for(int j=(nums.length-1);j>=0;j--)
        {
            result[j]=result[j]*res1;
            res1=res1*nums[j];
        }
        return result;
    }
}  
