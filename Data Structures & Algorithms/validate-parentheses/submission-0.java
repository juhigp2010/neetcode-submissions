class Solution {
    public boolean isValid(String s) {

        if (s == null || s.isEmpty() || s.length()%2 != 0) {
            return false;
        }

    Stack<Character> st=new Stack();
    for( char ch : s.toCharArray())
    {
        if(ch =='(' || ch =='{' || ch == '['){
         st.push(ch);
         }
        else{
         if(st.isEmpty())
           return false;
            
            char ch1=st.pop();
           if((ch==')' && ch1!='(') || (ch=='}' && ch1!='{') || (ch==']' && ch1!='['))
            return false;
         }
    
    }
    return st.isEmpty();
        
    }
}
