class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        Queue<Integer> q = new LinkedList<>();

        int in[] = new int[numCourses];

        for(int i = 0 ; i < numCourses ; i++ ){
            adj[i] = new ArrayList<>();
        }
        for( int e[] : prerequisites ){
            adj[e[1]].add(e[0]);
        }
        
        for(int i = 0 ; i < numCourses ; i++){
            for(int neigh : adj[i]){
                in[neigh]++;
            }
        }
        
        for(int i = 0 ; i < numCourses ; i++){
            if( in[i] == 0 ){
                q.offer(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        
        boolean visited[] = new boolean[numCourses];
        
        while( !q.isEmpty() ){
            int curr = q.poll();
            
            for(int neigh : adj[curr]){
                in[neigh]--;
                if( in[neigh] == 0 ){
                    q.offer(neigh);
                }
            }
            
            ans.add(curr);
        }
        if( ans.size() != numCourses ){
            return new int[]{};
        }
        
        int answer[] = new int[ans.size()];
    
        for(int i = 0 ; i < numCourses ; i++ ){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }

}