class Solution {
    public int trap(int[] arr) {

        int n=arr.length;
        int[] lmax=new int[n];
        int[] rmax=new int[n];
        int res=0;
        lmax[0]=arr[0];
        rmax[n-1]=arr[n-1];
        for(int i=1;i<n;i++)
        {
            lmax[i]=Math.max(arr[i],lmax[i-1]);
        }
        
        for(int j=n-2;j>=0;j--)
        {
            rmax[j]=Math.max(arr[j],rmax[j+1]);
        }
        for(int i=0;i<n;i++)
        {
            res=res+ (Math.min(lmax[i],rmax[i]))-arr[i];
        }
        return res;
    }
}
