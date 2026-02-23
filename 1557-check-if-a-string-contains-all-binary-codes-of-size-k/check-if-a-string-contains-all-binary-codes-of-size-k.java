class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = (int)Math.pow(2 , k);
        boolean[] present = new boolean[n];

        if( s.length() < k )return false;
        int r = k;
        int l = 0;

        while( r < s.length() + 1 ){
            l = r - k;
            present[ Integer.parseInt(s.substring(l , r) , 2) ] = true;
            r++;
        }

        for( boolean ele : present ){
            if( !ele )return false;
        }

        return true;
    }
}