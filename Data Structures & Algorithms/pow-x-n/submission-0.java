class Solution {
    public double myPow(double x, int p) {
if(p==0)
return 1;
double res=1;
long n = Math.abs((long) p);
while(n>0)
      {
        if(n%2!=0)
        {
         res=res*x;}
      
      x=x*x; 
      n=n/2;
    }
    if(p>0)
    return res;
    else
    return 1/res;
}
}