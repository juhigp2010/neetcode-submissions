class Solution {
    public int[] replaceElements(int[] arr) {
        int [] res=new int[arr.length];
        res[arr.length-1]=-1;
        if(arr.length>1){
        res[arr.length-2]=arr[arr.length-1];
        int max=0;
        for(int i=arr.length-3;i>=0;i--)
        {
          int curr=Math.max(arr[i+1],arr[i+2]);
          max=Math.max(curr,max);
          res[i]=max;
        }
        }
        return res;
        }
    
}