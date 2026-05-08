class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int [] arr=new int[2*n];
int j=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=nums[i];
            arr[j+n]=nums[i];
            j++;
        }
        return arr;
        
    }
}