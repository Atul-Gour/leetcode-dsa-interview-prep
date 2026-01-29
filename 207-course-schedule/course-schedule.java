class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] adj = new ArrayList[numCourses];
        int[] in = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : prerequisites) {
            adj[e[1]].add(e[0]);
            in[e[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) q.offer(i);
        }

        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int neigh : adj[curr]) {
                in[neigh]--;
                if (in[neigh] == 0) q.offer(neigh);
            }
        }

        return count == numCourses;
    }
}
