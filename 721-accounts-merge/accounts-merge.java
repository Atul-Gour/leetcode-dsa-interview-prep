class Solution {
    static class DSU{
        HashMap<String , String> parent;
        HashMap<String , Integer> rank;

        DSU(){
            this.parent = new HashMap<>();
            this.rank = new HashMap<>();
        }

        private String find( String s ){
            if( !parent.containsKey(s) ){
                parent.put( s , s );
                return s;
            }
            
            if( parent.get(s).equals(s) ) return s;
            parent.put( s , find( parent.get( s ) ) );
            return parent.get(s);
        }

        private void union( String a , String b ){
            String pa = find(a);
            String pb = find(b);

            int ra = rank.getOrDefault( pa , 1 );
            int rb = rank.getOrDefault( pb , 1 );

            if( ra < rb ){
                parent.put( pa , pb );
            }
            else if( rb < ra ){
                parent.put( pb , pa );
            }
            else{
                parent.put( pb , pa );
                rank.put( pb , rank.getOrDefault( pb , 0 ) + 1);
            }

        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap< String , String > owner = new HashMap<>();
        HashMap< String , List<String> > allEmails = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        DSU dsu = new DSU();


        for( List<String> account : accounts ){
            String name = account.get(0);

            for( int i = 1 ; i < account.size() ; i++ ){
                String email = account.get( i );
                owner.put( email , name );

                if( i < account.size() - 1 ){
                    String b = account.get( i + 1 );
                    dsu.union( email , b );
                }

            }
        }

        for( String key : owner.keySet() ){
            String parent = dsu.find(key);
            allEmails.computeIfAbsent( parent , f -> new ArrayList<>() ).add( key );
        }

        for( Map.Entry< String , List<String> > entry : allEmails.entrySet() ){
            String name = owner.get(entry.getKey());
            List<String> list = entry.getValue();
            Collections.sort(list);
            list.add(0, name);
            ans.add( list );
        }

        return ans;
    }
}