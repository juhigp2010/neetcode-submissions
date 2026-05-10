class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < n; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i <=(m - n); i++) {
            if (matches(s1Count, s2Count)) return true;
           if (i < m - n) {
        s2Count[s2.charAt(i + n) - 'a']++; // Pull in next
        s2Count[s2.charAt(i) - 'a']--;     // Drop first
    }
        }
        return false;
    }
    private boolean matches(int[] s1Count, int[] s2Count) {
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] != s2Count[i]) return false;
        }
        return true;
    }
}
