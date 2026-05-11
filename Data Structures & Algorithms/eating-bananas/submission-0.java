class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       
        
           int left = 1;
           int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canEatAll(piles, h, mid)) {
                result = mid;    // This speed works, but let's try to find a smaller one
                right = mid - 1;
            } else {
                left = mid + 1;  // Too slow! Increase the speed
            }
        }

        return result;

    }
    private boolean canEatAll(int[] piles, int h, int k) {
        long hoursSpent = 0; 
        for (int pile : piles) {
            // Calculate ceiling of (pile / k)
            // (pile + k - 1) / k is a common trick for ceiling division
            hoursSpent += (pile + k - 1) / k;
        }
        return hoursSpent <= h;
    }
}
