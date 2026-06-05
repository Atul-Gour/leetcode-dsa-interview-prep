class Solution {
    class DSU{
        
        HashMap<Integer , Integer> rowParent;
        HashMap<Integer , Integer> colParent;
        HashMap<Integer , Integer> parent;
        HashMap<Integer , Integer> size;
        
        DSU(){
            this.rowParent = new HashMap<>();
            this.colParent = new HashMap<>();
            this.parent = new HashMap<>();
            this.size = new HashMap<>();
        }
        
        int find( int ele ){
            if( parent.get(ele) == ele ) return ele;

            int middle = find( parent.get(ele) );
            parent.put( ele , middle );
            return middle;
        }

        void add( int x , int y ){
            int key = x*10001 + y;

            parent.put( key , key );
            size.put(key , 1);

            if( rowParent.containsKey(x) ){
                union( key , rowParent.get(x) );
            }
            else{
                rowParent.put(x , key);
            }

            if( colParent.containsKey(y) ){
                union( key , colParent.get(y) );
            }
            else{
                colParent.put(y , key);
            }
        }
        
        void union( int a , int b ){
            
            int pa = find(a);
            int pb = find(b);
            
            if( pa == pb ) return;
            
            int sizePa = size.get(pa);
            int sizePb = size.get(pb);
            
            if( sizePa < sizePb ){
                parent.put(pa , pb);
                size.put( pb , sizePa + sizePb );
            }
            else{
                parent.put(pb , pa);
                size.put( pa , sizePa + sizePb );
            }            
        }
    }

    public int removeStones(int[][] stones) {
        
        DSU dsu = new DSU();

        for( int[] stone : stones ){
            dsu.add( stone[0] , stone[1] );
        }

        HashSet<Integer> allKeys = new HashSet<>();

        for( int key : dsu.parent.values() ){
            int keyParent = dsu.find(key);
            allKeys.add(keyParent);
        }

        int ans = 0;

        for( int key : allKeys ){
            ans += dsu.size.get(key) - 1;
        }

        return ans;
    }
}