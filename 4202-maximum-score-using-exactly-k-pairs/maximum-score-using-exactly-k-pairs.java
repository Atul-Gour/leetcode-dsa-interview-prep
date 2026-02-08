class Solution {

    public long maxScore(int[] nums1, int[] nums2, int pairs) {

        int n = nums1.length;
        int m = nums2.length;

        long NEG = (long)-1e18;

        long[][] next = new long[m+1][pairs+1];
        long[][] curr = new long[m+1][pairs+1];

        // Base for i = n
        for(int j=0;j<=m;j++){
            for(int k=0;k<pairs;k++){
                next[j][k] = NEG;
            }
            next[j][pairs] = 0;
        }

        for(int i=n-1;i>=0;i--){

            // Only boundary initialization
            for(int k=0;k<pairs;k++){
                curr[m][k] = NEG;
            }
            curr[m][pairs] = 0;

            for(int j=m-1;j>=0;j--){

                curr[j][pairs] = 0;

                for(int k=pairs-1;k>=0;k--){

                    long skip1 = next[j][k];
                    long skip2 = curr[j+1][k];

                    long take =
                        (long)nums1[i] * nums2[j]
                        + next[j+1][k+1];

                    curr[j][k] =
                        Math.max(take, Math.max(skip1, skip2));
                }
            }

            long[][] temp = next;
            next = curr;
            curr = temp;
        }

        return next[0][0];
    }
}
