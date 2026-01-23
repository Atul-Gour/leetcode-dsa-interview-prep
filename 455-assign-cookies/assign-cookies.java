class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // Sort greed factors of children
        Arrays.sort(g);

        // Sort cookie sizes
        Arrays.sort(s);

        int n = g.length; // number of children
        int m = s.length; // number of cookies

        int i = 0; // pointer for children
        int j = 0; // pointer for cookies

        // Try to assign cookies to children
        while (i < n && j < m) {

            // If current cookie can satisfy current child
            if (s[j] >= g[i]) {
                i++; // child is satisfied
                j++; // cookie is used
            } else {
                // Cookie too small, try next bigger cookie
                j++;
            }
        }

        // Number of satisfied children
        return i;
    }
}