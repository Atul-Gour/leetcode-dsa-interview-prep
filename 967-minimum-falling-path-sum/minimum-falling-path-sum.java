class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int curr[] = new int[n];
        int next[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            next[i] = matrix[0][i];
        }
        

        for(int i = 0 ; i < n - 1 ; i++){
            curr = next;
            next = new int[n];
            Arrays.fill(next , Integer.MAX_VALUE);
            for(int j = 0 ; j < n ; j++){

                if(j-1 >= 0)
                    next[j-1] = Math.min ( next[j-1] , curr[j] + matrix[i+1][j-1]);
                    
                next[j] = Math.min ( next[j] , curr[j] + matrix[i+1][j]);

                if(j+1 < n)
                    next[j+1] = Math.min ( next[j+1] , curr[j] + matrix[i+1][j+1]);
                
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int ele : next){
            ans = Math.min(ans , ele);
        }
        return ans;
    }
}