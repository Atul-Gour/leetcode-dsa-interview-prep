class Solution {

    void solve ( int[][] grid , int i , int j , int parent){

        
        int n = grid.length;
        int m = grid[0].length;
        

        if(i >= n || j >= m || i < 0 || j < 0 || grid[i][j] == -1 || grid[i][j] <= parent + 1) return;

        

        grid[i][j] = parent + 1;

        solve ( grid , i - 1 , j , grid[i][j] );
        solve ( grid , i + 1 , j , grid[i][j] );
        solve ( grid , i , j + 1 , grid[i][j] );
        solve ( grid , i , j - 1 , grid[i][j] );
        
    }

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        ArrayList<List<Integer>> list = new ArrayList<>();
       
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(grid[i][j] == 1) {
                    fresh++;
                    grid[i][j] = Integer.MAX_VALUE;
                }
                else if(grid[i][j] == 2 ){
                    grid[i][j] = 0;
                    list.add( Arrays.asList(i, j) );
                }
                else grid[i][j] = -1;
            }
        }
        if(fresh == 0) return 0;

        if( list.isEmpty() )return -1;
        

        for(List<Integer> li : list ){

            int x = li.get(0);
            int y = li.get(1);
            grid[x][y] = 1;
            solve( grid , x , y , -1);
        }

        int ans = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(grid[i][j] == Integer.MAX_VALUE)return -1;
                
                ans = Math.max( ans , grid[i][j]);
            }
        }
        return ans;
    }
}