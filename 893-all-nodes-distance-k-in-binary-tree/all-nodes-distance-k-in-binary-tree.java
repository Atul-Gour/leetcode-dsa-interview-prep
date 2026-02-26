/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    static private void dfs( TreeNode root , HashMap<Integer , HashSet<Integer>> edges ){
        if( root == null )return;

        int u = root.val;
        edges.putIfAbsent( u , new HashSet<>() );

        if( root.left != null ){
            int v = root.left.val;
            edges.computeIfAbsent( v , f -> new HashSet<>() ).add(u);
            edges.get(u).add(v);
            dfs( root.left , edges );
        }
        if( root.right != null ){
            int v = root.right.val;
            edges.computeIfAbsent( v , f -> new HashSet<>() ).add(u);
            edges.get(u).add(v);
            dfs( root.right , edges );
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer , HashSet<Integer>> edges = new HashMap<>();

        dfs(root , edges);
        Queue<int[]> q = new ArrayDeque<>();
        q.offer( new int[]{ target.val , -1 } );

        int length = 0;

        while( !q.isEmpty() && length < k ){
            int size = q.size();

            while( size-- > 0 ){
                int curr[] = q.poll();

                for( int neigh : edges.get(curr[0]) ){
                    if( neigh == curr[1] )continue;
                    q.add( new int[]{ neigh , curr[0] } );
                }
            }

            length++;
        }

        List<Integer> ans = new ArrayList<>();
        if( length == k ){
            while( !q.isEmpty() ){
                ans.add( q.poll()[0] );
            }
        }

        return ans;
    }
}