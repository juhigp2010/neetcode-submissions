class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result=new int[nums.length-k+1];
        for(int i=0;i<(nums.length-k+1);i++)
        {
            result[i]=maximum(nums,i,i+k);
        }
        return result;
        
    }
    public static int maximum(int[] arr,int low,int high)
    {
        int max=arr[low];
       for(int i=low;i<high;i++)
       {
           if(arr[i]>max)
           {
               max=arr[i];
           }
       }
       return max;
    }
}
