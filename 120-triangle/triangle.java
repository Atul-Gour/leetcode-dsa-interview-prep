class Solution {

    private boolean ifPossible(int i , int j){
        if(j < 0 || j > i)return false;
        else return true;
    }

    public int minimumTotal(List<List<Integer>> list) {
        int ans = 0;
        int n = list.size();
        int dp[][] = new int [n][n];

        for(int arr[] :dp){
            Arrays.fill( arr , Integer.MAX_VALUE);
        }

        for(int i = 0 ; i < n ; i++){
            dp[n-1][i] = list.get(n-1).get(i);
        }

        int newI ;
        int newJ ;

        for(int i = n - 1 ; i > 0 ; i-- ){

            newI = i-1;
            for(int j = 0 ; j <= i ; j++){

                newJ = j-1;
                if(ifPossible(newI , newJ))
                    dp[newI][newJ] = Math.min( dp[newI][newJ] , list.get(newI).get(newJ) + dp[i][j]);

                newJ = j;
                if(ifPossible(newI , newJ))
                    dp[newI][newJ] = Math.min( dp[newI][newJ] , list.get(newI).get(newJ) + dp[i][j]);
                
            }
            
        }

        return dp[0][0];
    }
}