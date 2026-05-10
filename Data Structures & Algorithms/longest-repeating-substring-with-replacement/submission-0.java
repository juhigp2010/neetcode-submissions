class Solution {
    public int characterReplacement(String s, int k) {
       int[] counts = new int[26];
        
        int left = 0;
        int maxRepeatCount = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            int currentCount = ++counts[s.charAt(right) - 'A'];
            maxRepeatCount = Math.max(maxRepeatCount, currentCount);
            while ((right - left + 1) - maxRepeatCount > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
