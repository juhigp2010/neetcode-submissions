class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(String s, int start, List<String> currentList, List<List<String>> result) {
             if (start >= s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < s.length(); i++) {
           
            if (isPalindrome(s, start, i)) {
           
                currentList.add(s.substring(start, i + 1));
                
                backtrack(s, i + 1, currentList, result);
                
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
