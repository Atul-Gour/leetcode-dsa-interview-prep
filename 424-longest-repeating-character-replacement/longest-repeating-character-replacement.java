class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int alphabet[]=new int[26];
        int left=0;
        int right = 0;
        int maxFreq=0;
        int ans=0;

        for(right=0;right<n;right++){
            char c= s.charAt(right);
            alphabet[c-'A']++;
            maxFreq= Math.max(maxFreq, alphabet[c-'A']);

            while((right-left+1)-maxFreq>k){
                alphabet[s.charAt(left)-'A']--;
                left++;
            }

            ans= Math.max(ans, (right-left+1));

        }

        return ans;
    }
}