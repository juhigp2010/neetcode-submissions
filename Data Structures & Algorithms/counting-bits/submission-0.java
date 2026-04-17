class Solution {
    public int[] countBits(int n) {
     int [] arr=new int[n+1];
     int i=1;
     arr[0]=0;
     for(int j=1;j<n+1;j++)
     {
        int count=0;
        int x=j;
        while(x>0)
        {
            x=x&(x-1);
            count++;
        }
        arr[j]=count;
     }
return arr;
        
    }
}
