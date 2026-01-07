class Solution {
    boolean canPut(boolean col[], boolean[] diag1 ,boolean[] diag2 , int i , int j ){
        int n = col.length;
        if(col[j])return false;
        if(diag1[ (i - j) + (n - 1) ])return false;
        if(diag2[ (i + j) ])return false;
        return true;
    }
    void solve(List<List<String>> ans, boolean col[], boolean[] diag1 ,boolean[] diag2 , int i , List<String> curr){
        int n = col.length;

        if(i >= n)return;

        for(int j = 0 ; j < n ; j++){
            if(!canPut(col , diag1 , diag2 , i , j)) continue;
            
            col[j] = true;
            diag1[ (i - j) + (n - 1) ] = true;
            diag2[ (i + j) ] = true;

            //putting in ans
            StringBuilder sb = new StringBuilder();

            for(int x = 0 ; x < n ; x++){
                if( x != j )sb.append(".");
                else sb.append("Q");
            }

            curr.add(sb.toString());

            if(i == n-1){
                ans.add(new ArrayList<>(curr));
            }
            //end of putting

            solve(ans , col , diag1 , diag2 , i+1 , curr);

            curr.remove(curr.size() - 1);

            col[j] = false;
            diag1[ (i - j) + (n - 1) ] = false;
            diag2[ (i + j) ] = false;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean col[] = new boolean[n];
        boolean diag1[] = new boolean[2*n - 1];
        boolean diag2[] = new boolean[2*n - 1];

        List<List<String>> ans = new ArrayList<>();

        solve(ans , col , diag1 , diag2 , 0 , new ArrayList<>());
        return ans;
    }
}