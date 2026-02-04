class Solution {

    int[][] memo ;
    int ans = Integer.MAX_VALUE;

    private void find( StringBuilder sb1 ,StringBuilder sb2 , int i , int j , int cost){
        int n = sb1.length();
        int m = sb2.length();

        // System.out.print(i + " " + j + " " + cost + " " + memo[j] + " " + memo[m]);

        if(cost >= ans)return;

        while( i < n && j < m && sb1.charAt(i) == sb2.charAt(j) ){
            i++;
            j++;
        }

        if(i == n){
            ans = Math.min(ans, cost + (m - j));
            return;
        }

        if(j == m){
            ans = Math.min(ans, cost + (n - i));
            return;
        }

        if( memo[i][j] <= cost ) return ;
        memo[i][j] = cost;

        if( i == n || j == m ){
            ans = Math.min( ans , cost );
            return;
        }

        find( sb1 , sb2 , i , j + 1 , cost + 1 );//insert

        find( sb1 , sb2 , i + 1 , j , cost + 1 );//delete

        find( sb1 , sb2 , i + 1 , j + 1 , cost + 1 );//replace

    }

    public int minDistance(String word1, String word2) {
        StringBuilder sb1 = new StringBuilder(word1);
        StringBuilder sb2 = new StringBuilder(word2);
        int m = sb2.length();
        int n = sb1.length();
        memo = new int[n + 1][m + 1];

        for(int[] a : memo){
            Arrays.fill( a , Integer.MAX_VALUE );
        }
        
        find( sb1 , sb2 , 0 , 0 , 0);

        return ans;
    }
}