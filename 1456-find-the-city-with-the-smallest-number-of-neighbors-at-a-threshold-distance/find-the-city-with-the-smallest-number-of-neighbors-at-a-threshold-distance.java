class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];
        for (int d[] : dist) {
            Arrays.fill(d, 100000);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = w;
            dist[v][u] = w;
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != 100000 && dist[k][j] != 100000) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int ans = n-1;
        int minReach = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reach = 0;
            for (int j = 0; j < n; j++) {
                if ( i != j && dist[i][j] <= distanceThreshold ) {
                    reach++;
                }
            }

            if( reach < minReach ){
                minReach = reach;
                ans = i;
            }else if( reach == minReach ){
                ans = Math.max( ans , i );
            }

        }
        return ans;
    }
}