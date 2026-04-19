class Solution {

    static class Node{
        int size , unique;

        Node( int size , int unique ){
            this.size = size;
            this.unique = unique;
        }
    }

    static void bfs( int iStart , int jStart , int[][] grid , Node[][] arr ){
        int n = grid.length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        ArrayList<int[]> cells = new ArrayList<>();
        int[][] dirs = {{0,1} , {1,0} , {0,-1} , {-1,0}};

        int size = 0;

        q.offer( new int[]{iStart , jStart} );
        arr[iStart][jStart] = new Node(-1, -1);

        while( !q.isEmpty() ){
            int curr[] = q.poll();
            int i = curr[0];
            int j = curr[1];
            size++;
            cells.add(new int[]{i, j});

            for( int[] d : dirs ){
                int newI = i + d[0];
                int newJ = j + d[1];
                if( newI < 0 || newI >= n || newJ < 0 || newJ >= n || arr[newI][newJ] != null || grid[newI][newJ] == 0 )continue;

                arr[newI][newJ] = new Node(-1, -1);
                q.offer( new int[]{newI , newJ} );
            } 
        }

        int unique = iStart * n + jStart;

        for (int[] cell : cells) {
            arr[cell[0]][cell[1]] = new Node(size, unique);
        }

    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Node[][] arr = new Node[n][n];
        int[][] dirs = {{0,1} , {1,0} , {0,-1} , {-1,0}};

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( grid[i][j] == 1 && arr[i][j] == null ){
                    bfs( i , j , grid , arr ); 
                }
            }
        }

        int ans = arr[0][0] == null ? 0 : arr[0][0].size;

        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( grid[i][j] == 1 ) continue; 

                HashSet<Integer> set = new HashSet<>();
                int curr = 1;

                for( int[] dir : dirs){
                    int newI = i + dir[0];
                    int newJ = j + dir[1];

                    if( newI < 0 || newI >= n || newJ < 0 || newJ >= n || grid[newI][newJ] == 0 )continue;
                    if( set.contains( arr[newI][newJ].unique ) ) continue;

                    set.add( arr[newI][newJ].unique );
                    curr += arr[newI][newJ].size;
                }

                ans = Math.max( ans , curr );
            }
        }

        return ans;

    }
}