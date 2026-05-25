class Solution {
    public boolean isHappy(int n) {
        if(n==1)
        return true;
        int slow = n;
        int fast = getNext(n);
        
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);         // moves 1 step
            fast = getNext(getNext(fast)); // moves 2 steps
        }
        
        return fast == 1;
    }
    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            totalSum += d * d;
            n = n / 10;
        }
        return totalSum;
    }
}
