class Solution {

    int[][] memo ;
    int ans = Integer.MAX_VALUE;

    private void find( String sb1 ,String sb2 , int i , int j , int cost){
        int n = sb1.length();
        int m = sb2.length();


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

        if( memo[i][j] <= cost ) return;
        memo[i][j] = cost;

        find( sb1 , sb2 , i , j + 1 , cost + 1 );//insert

        find( sb1 , sb2 , i + 1 , j , cost + 1 );//delete

        find( sb1 , sb2 , i + 1 , j + 1 , cost + 1 );//replace

    }

    public int minDistance(String word1, String word2) {
        int m = word2.length();
        int n = word1.length();
        memo = new int[n + 1][m + 1];

        for(int[] a : memo){
            Arrays.fill( a , Integer.MAX_VALUE );
        }
        
        find( word1 , word2 , 0 , 0 , 0);

        return ans;
    }
}