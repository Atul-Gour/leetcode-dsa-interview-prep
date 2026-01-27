class Solution {

    private void dfs( int node , boolean[] visited ,  ArrayList< ArrayList<Integer>> adj , ArrayList<Integer> currProvince ){
        
        visited[node] = true;

        for( int u : adj.get( node )){
            if( !visited[u] ) dfs( u , visited , adj , currProvince );
        }

        currProvince.add(node);
    }

    private boolean check( ArrayList<Integer> currProvince , ArrayList< ArrayList<Integer>> adj ){
        int n = currProvince.size();

        for(int i : currProvince){
            if( adj.get(i).size() != n - 1 ) return false;
        }

        return true;
    }

    public int countCompleteComponents(int n , int[][] isConnected) {
        ArrayList< ArrayList<Integer>> adj = new ArrayList<>();

        for( int i = 0 ; i < n ; i++){
            adj.add( new ArrayList<>() );
        }

        for( int[] arr: isConnected ){
            int i = arr[0];
            int j = arr[1];
            adj.get(i).add(j);
            adj.get(j).add(i);
        }

        int ans = 0;
        boolean[] visited = new boolean[n];
        ArrayList<Integer> currProvince ;

        for(int i = 0 ; i < n ; i++){
            if( visited[i] )continue;
            
            currProvince = new ArrayList<>();
            dfs( i , visited , adj , currProvince);

            if( check( currProvince , adj ) )ans++;
        }

        return ans;
    }
}