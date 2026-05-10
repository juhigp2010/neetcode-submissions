class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st= new Stack<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))  {
                int r = st.pop();
                int l = st.pop();
                
                switch (s) {
                    case "+": st.push(l + r); break;
                    case "-": st.push(l - r); break;
                    case "*": st.push(l * r); break;
                    case "/": st.push(l / r); break; 
                }
            } else {
                st.push(Integer.parseInt(s));
            }
        
        }
        return st.pop();
    }
}
