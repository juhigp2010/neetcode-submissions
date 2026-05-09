class Solution {

    public String encode(List<String> strs) {
StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Format: <length> + "#" + <string>
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
      List<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int j = s.indexOf('#', i);
            int length = Integer.parseInt(s.substring(i, j));
            i = j + 1;
            res.add(s.substring(i, i + length));
                i += length;
        }
        
        return res;
    }
}
