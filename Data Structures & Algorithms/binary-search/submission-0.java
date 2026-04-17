class Solution {
    public int search(int[] nums, int x) {

        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==x)
            return mid;
            else if(x>mid)
            low=mid+1;
            else
            high=high-1;
        }
        return -1;
    }
}
