class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1)
        return 1;
        int first=1;
        int second=1;
     for(int i=2;i<=n;i++)
     {
        int curr=first+second;
        first=second;
        second=curr;
     }
     return second;
    }
}
