class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int j = 0;
        for(int i = 0 ; i < g.length ; i++){
            while( j < s.length && s[j] < g[i] ) j++;

            if(j == s.length)return i;
            else {
                j++;
            }

        }

        return g.length;
    }
}