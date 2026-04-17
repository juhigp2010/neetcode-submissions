class Solution {
    public boolean isPalindrome(String s) {

        if(s.length()==1 | s.length()==0)
        return true;
      String cleanText=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
int left=0;
int right=cleanText.length()-1;

while(left<right)
{
    if(cleanText.charAt(left)!=cleanText.charAt(right))
    return false;
    left++;
    right--;
    
}
       return true; 
    }
}
