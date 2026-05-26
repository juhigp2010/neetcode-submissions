class Solution {
    public String minWindow(String s, String t) {
      if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Map to store the frequency of characters in t
        int[] tMap = new int[128];
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }

        int left = 0;
        int right = 0;
        
        // Track the starting index and minimum length of the valid substring
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        // Number of characters from t that still need to be matched in the current window
        int count = t.length();

        // Move the right pointer to expand the window
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // If the character is part of t, decrement the required count
            if (tMap[rightChar] > 0) {
                count--;
            }
            // Decrement the frequency in our map/array
            tMap[rightChar]--;
            right++;

            // When all characters are matched, try to shrink the window from the left
            while (count == 0) {
                // Update the minimum window if the current one is smaller
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                // Increment the map count because this character is leaving the window
                tMap[leftChar]++;
                
                // If the character leaving was a critical part of string t, increase the required count
                if (tMap[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }

        // If minLen wasn't updated, it means no valid window was found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);}
}
