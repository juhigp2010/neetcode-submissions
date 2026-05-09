class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashSet<Character> hs=new HashSet<>();
       int i = 0; // The starting index of our window
        int j = 0; // The ending index of our window
        int max = 0;

        while (j < s.length()) {
            char currentChar = s.charAt(j);

            // If the character is already in the set, 
            // slide the back (i) forward and remove characters
            while (hs.contains(currentChar)) {
                hs.remove(s.charAt(i));
                i++;
            }

            // Now that we know currentChar is not in the set, add it
            hs.add(currentChar);
            
            // Calculate the current window size (j - i + 1)
            max = Math.max(max, j - i + 1);
            
            // Move the front forward
            j++;
        }
        
        return max;
    }
}
