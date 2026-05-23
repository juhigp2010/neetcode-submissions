class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n=matrix.length;
        int col=matrix[0].length;
        if (target < matrix[0][0] || target > matrix[n - 1][col - 1]) {
            return false;
        }
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
