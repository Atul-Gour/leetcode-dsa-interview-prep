class Solution {

    private void dfs( int[][] image , int i, int j, int color , int original , boolean[][] visited){
        int n = image.length;
        int m = image[0].length;

        if( i >= n || j >= m || j < 0 || i < 0 || image[i][j] != original || visited[i][j] ) return;

        visited[i][j] = true;
        image[i][j] = color;

        dfs( image , i , j + 1 , color , original , visited );
        dfs( image , i , j - 1 , color , original , visited );
        dfs( image , i + 1 , j , color , original , visited );
        dfs( image , i - 1 , j , color , original , visited );


    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];

        dfs( image , sr , sc , color , image[sr][sc] , visited );
        return image;
    }
}