class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] chars = new int[127];
        int n = s.length();
        int max = 0;

        int l = 0;

        for (int r = 0 ; r < n ; r++) {

            int rIdx = s.charAt(r);
            chars[rIdx]++ ;

            while( chars[rIdx] > 1 && l <= n){
                chars[s.charAt(l)]--;
                l++;
            }
            
            max = Math.max(max, r - l + 1);

        }

        return max;
    }
}