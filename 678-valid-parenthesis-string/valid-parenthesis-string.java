class Solution {
    Boolean[][] memo;
    
    public boolean checkValidString(String s) {
        memo = new Boolean[s.length()][s.length() + 1];
        return solve(s, 0, 0);
    }
    
    private boolean solve(String s, int index, int openCount) {
        if (openCount < 0) return false;
        if (index == s.length()) return openCount == 0;
        
        if (memo[index][openCount] != null) {
            return memo[index][openCount];
        }
        
        boolean result = false;
        char c = s.charAt(index);
        
        if (c == '(') {
            result = solve(s, index + 1, openCount + 1);
        } else if (c == ')') {
            result = solve(s, index + 1, openCount - 1);
        } else {
            result = solve(s, index + 1, openCount) ||
                     solve(s, index + 1, openCount + 1) ||
                     solve(s, index + 1, openCount - 1);
        }
        
        memo[index][openCount] = result;
        return result;
    }
}