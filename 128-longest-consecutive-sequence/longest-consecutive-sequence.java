class Solution {

    static class DSU{
        HashMap<Integer , Integer> parent;
        HashMap<Integer , Integer> size;
        int maxSize ;

        DSU(){
            parent = new HashMap<>();
            size = new HashMap<>();
            maxSize = 1;
        }

        int find( int node ){
            if( parent.getOrDefault( node , node ) == node ) return node;
            parent.put( node , find( parent.get(node) ) );
            return parent.get(node);
        }

        boolean union( int a , int b ){
            int pa = find(a);
            int pb = find(b);

            if( pa == pb ) return false;

            int sa = size.getOrDefault( pa , 1 );
            int sb = size.getOrDefault( pb , 1 );

            if( sa <= sb ){
                parent.put( pa , pb );
                size.put( pb , sb + sa );
            }
            else{
                parent.put( pb , pa );
                size.put( pa , sb + sa );
            }

            maxSize = Math.max( maxSize , sb + sa );
            return true;
        }
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if( n == 0 ) return 0;

        HashSet<Integer> set = new HashSet<>();
        DSU dsu = new DSU();

        for( int ele : nums ){
            if( set.contains(ele) ) continue;

            dsu.parent.put(ele, ele);
            dsu.size.put(ele, 1);
            
            if( set.contains(ele - 1) ) dsu.union(ele , ele - 1);
            if( set.contains(ele + 1) ) dsu.union(ele , ele + 1);

            set.add( ele );
        }

        

        return dsu.maxSize;
    }
}