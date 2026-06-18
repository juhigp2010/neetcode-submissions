class Solution {
    public int maxProduct(int[] nums) {
      if (nums == null || nums.length == 0) {
            return 0;
        }
        int res=nums[0];
        int max=nums[0];
        int min=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int current=nums[i];
            if(current<0)
            {
                int temp=max;
                max=min;
                min=temp;
            }
            max=Math.max(current,max*current);
            min=Math.min(current,min*current);
            res=Math.max(res,max);
        }
        return res;
    }
}
