class Solution {
    public String mergeAlternately(String word1, String word2) {
        if(word1.length()==0 && word2.length()==0)
        return "";
        int i=0;
        StringBuffer sb=new StringBuffer();
      while(i<word1.length() && i<word2.length())
      {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
            i++;
      }
      while(i<word1.length())
      {
        sb.append(word1.charAt(i));
        i++;
      }
      while(i<word2.length())
      {
        sb.append(word2.charAt(i));
        i++;
      }
      return sb.toString();
    }
}