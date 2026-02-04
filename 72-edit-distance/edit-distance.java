class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] next = new int[m + 1];

        // Base case dp[n][j]
        for(int j = 0; j <= m; j++){
            next[j] = m - j;
        }

        for(int i = n - 1; i >= 0; i--){

            int[] curr = new int[m + 1];

            // Base case dp[i][m]
            curr[m] = n - i;

            for(int j = m - 1; j >= 0; j--){

                if(word1.charAt(i) == word2.charAt(j)){
                    curr[j] = next[j + 1];
                }
                else{
                    curr[j] = 1 + Math.min(
                        curr[j + 1],      // insert
                        Math.min(
                            next[j],      // delete
                            next[j + 1]   // replace
                        )
                    );
                }
            }

            next = curr; // move row up
        }

        return next[0];
    }
}
