/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node[] nodes ;

    private Node make( Node original ){

        if( original == null )return null;

        Node newNode = new Node( original.val );
        nodes[original.val] = newNode;

        for( Node neigh : original.neighbors ){
            Node temp = nodes[neigh.val];

            if( temp == null ){
                temp = make( neigh );
            }

            newNode.neighbors.add( temp );
        }

        return newNode;        
    }

    public Node cloneGraph(Node node) {
        nodes = new Node[101];

        return make(node);
    }
}