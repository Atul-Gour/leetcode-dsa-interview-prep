class Solution {

    public long maxScore(int[] nums1, int[] nums2, int pairs) {

        int n = nums1.length;
        int m = nums2.length;

        long[][] curr = new long[m + 1][pairs + 1];
        long[][] next = new long[m + 1][pairs + 1];

        for (int j = 0; j <= m; j++) {
            for (int k = 0; k <= pairs; k++) {
                if (k == pairs) {
                    next[j][k] = 0;
                } else {
                    next[j][k] = Long.MIN_VALUE / 2;
                }
            }

        }
        for( int i = n - 1 ; i >= 0 ; i-- ){

            for(int j=0;j<=m;j++){
                for(int k=0;k<=pairs;k++){
                    if(k == pairs) curr[j][k] = 0;
                    else curr[j][k] = Long.MIN_VALUE / 2;
                }
            }

            for( int j = m - 1 ; j >= 0 ; j-- ){
                for( int k = pairs - 1 ; k >= 0 ; k-- ){
                    
                    long skip1 = next[j][k];

                    long skip2 = curr[j+1][k];

                    long take = (long) nums1[i] * nums2[j] + next[j+1][k+1];

                    curr[j][k] = Math.max(take, Math.max(skip1, skip2));
                    
                }
            }
            next = curr;
            curr = new long[m + 1][pairs + 1];
        }

        return next[0][0];
    }
}