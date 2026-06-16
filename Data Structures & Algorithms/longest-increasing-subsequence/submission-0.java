class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
        return 0;
        if(nums.length==1)
        return 1;

        int [] tail =new int[nums.length];
        tail[0]=nums[0];
        int len=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>tail[len-1])
              { tail[len]=nums[i];
                len++;}
                else
                {
                    int c=cielIndex(tail,0,len-1,nums[i]);
                    tail[c]=nums[i];
                }
        }
        return len;
    }

    private static int cielIndex(int [] arr,int left, int right,int val)
    {
        while(left<right)
        {
            int mid =left+(right-left)/2;
            if(arr[mid]>=val)
            {
                right=mid;
            }
            else
            left=mid+1;
        }
        return right;
    }
    
}
