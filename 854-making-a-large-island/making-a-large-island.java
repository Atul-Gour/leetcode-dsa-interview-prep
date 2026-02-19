class DSU {

    HashMap<Long, Long> parent;
    HashMap<Long, Integer> rank;

    DSU() {
        parent = new HashMap<>();
        rank = new HashMap<>();
    }

    long find(long node) {
        if (parent.get(node) == node)
            return node;

        long newParent = find(parent.get(node));
        parent.put(node, newParent);
        return newParent;
    }

    boolean union(long a, long b) {
        long pa = find(a);
        long pb = find(b);

        if (pa == pb)
            return false;

        int ra = rank.get(pa);
        int rb = rank.get(pb);

        if (ra < rb)
            parent.put(pa, pb);
        else if (rb < ra)
            parent.put(pb, pa);
        else {
            parent.put(pa, pb);
            rank.put(pb, rank.get(pb) + 1);
        }

        return true;
    }
}

class Solution {

    static private long key(int a, int b) {
        return (long) a << 32 | b;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU();
        HashMap<Long , Integer> freq = new HashMap<>();
        long[][] matrix = new long[n][n];
        int[][] dirs = { { 0, -1 }, { -1, 0 } };
        
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    long key = (long) i << 32 | j;
                    dsu.parent.put(key, key);
                    dsu.rank.put(key, 0);

                    for (int d[] : dirs) {
                        int newX = i + d[0];
                        int newY = j + d[1];

                        if (newX < n && newX >= 0 && newY < n && newY >= 0 && grid[newX][newY] == 1) {
                            long newKey = (long) newX << 32 | newY;
                            dsu.union(key, newKey);
                        }
                    }

                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    long key = (long) i << 32 | j;
                    long keyP = dsu.find( key );
                    freq.put(keyP , freq.getOrDefault(keyP , 0) + 1 );
                    matrix[i][j] = keyP;
                    ans = Math.max(ans , freq.get(keyP));
                }
            }
        }

        int[][] dirss = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {

                    int currAns = 1;

                    HashSet<Long> set = new HashSet<>();

                    for( int[] d : dirss ){
                        int newX = i + d[0];
                        int newY = j + d[1];

                        if (newX < n && newX >= 0 && newY < n && newY >= 0 && grid[newX][newY] == 1) {
                            set.add(matrix[newX][newY]);
                        }
                    }

                    for( long key : set ){
                        currAns += freq.get(key);
                    }
                    
                    ans = Math.max(ans , currAns);
                }
            }
        }

        return ans;
    }
}
