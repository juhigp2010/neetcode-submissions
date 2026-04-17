class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()==0 && t.length()==0)
        return true;
        if(s.length()!=t.length())
        return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        
        return Arrays.equals(sArr, tArr);
    }
    }

