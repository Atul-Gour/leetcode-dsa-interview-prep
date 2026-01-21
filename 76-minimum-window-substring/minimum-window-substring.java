class Solution {
    public String minWindow(String s, String t) {
        int target[] = new int[128];
        for( char c : t.toCharArray()){
            target[c]++;
        }

        int current[] = new int[128];
        int length = 0;
        int n = s.length();
        int ansLength = Integer.MAX_VALUE;
        int start = -1;
        int l = 0;

        for(int r = 0 ; r < n ; r++){
            char ch = s.charAt(r);
            current[ch]++;

            if( target[ch] > 0 && target[ch] >= current[ch] )length++;

            while( length == t.length() ){
                if( r - l + 1 < ansLength ){
                    ansLength = r - l + 1;
                    start = l;
                }
                char leftCh = s.charAt(l);

                if( target[leftCh] > 0 && current[leftCh] <= target[leftCh] ) length--;

                current[leftCh]--;
                l++;
            }
        }
        return ansLength == Integer.MAX_VALUE ? "" : s.substring(start , start + ansLength );
    }
}