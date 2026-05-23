class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int i=0;
        while(i<n)
        {
            int []arr =matrix[i];
            int low=0;
            int high=arr.length-1;
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(arr[mid]==target)
               { return true;
               }
                else if(arr[mid]<target)
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            i++;
        }
        return false;
    }
}
