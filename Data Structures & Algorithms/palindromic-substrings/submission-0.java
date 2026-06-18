class Solution {
    public int countSubstrings(String s) {
       if(s==null || s.length()==0)
       return 0;
       
        int totalCount = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindromes centered at index i
            totalCount += expandAndCount(s, i, i);
            
            // Case 2: Even length palindromes centered between i and i + 1
            totalCount += expandAndCount(s, i, i + 1);
        }

        return totalCount;
    
    }
    private int expandAndCount(String s, int left, int right) {
        int count = 0;
        
        // Expand outward as long as it's a valid palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; // Found a valid palindromic substring!
            left--;
            right++;
        }
        
        return count;
}
}