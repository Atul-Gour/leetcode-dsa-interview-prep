class Solution {
    public int residuePrefixes(String s) {
        int[] chars = new int[26];
        Arrays.fill(chars , -1);
        int distinct = 0;
        int ans = 0;
        int n = s.length();

        for(int  i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            
            if(chars[ch - 'a'] == -1){
                chars[ch - 'a'] = i;
                distinct++;
            }
            if( distinct == ((i+1) % 3))ans++;
        }
        return ans;
    }
}