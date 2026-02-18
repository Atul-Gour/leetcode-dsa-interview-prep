class Solution {
    static private String findParent( String curr , HashMap<String , String> parent ){
        if( curr == parent.get(curr) ){
            return curr;
        }
        String newParent = findParent( parent.get(curr) , parent );
        parent.put(curr , newParent );
        return newParent;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String , String> parent = new HashMap<>();
        HashMap<String , String> name = new HashMap<>();
        HashMap<String , Integer> rank = new HashMap<>();
        HashMap<String , List<String> > emails = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for( List<String> account : accounts ){
            int maxRank = 0;
            String maxRankEmail = "";
            int m = account.size();

            for( int i = 1 ; i < m ; i++ ){
                int currRank = 0;
                String currEmail ;

                if( !rank.containsKey( account.get(i) ) ){
                    rank.put( account.get(i) , 0 );
                    parent.put( account.get(i) , account.get(i) );
                    currEmail = account.get(i);
                }
                else{
                    currEmail = findParent( account.get(i) , parent );
                    currRank = rank.get( currEmail );
                    
                }

                if( currRank >= maxRank ){
                    maxRank = currRank;
                    maxRankEmail = currEmail;
                }
            }

            for( int  i = 1 ; i < m ; i++){
                parent.put( findParent(account.get(i), parent) , maxRankEmail );
            }

            rank.put( maxRankEmail , maxRank + 1 );
            name.put( maxRankEmail , account.get(0) );
        }

        for( Map.Entry<String , String> entry : parent.entrySet() ){
            String main = findParent(entry.getValue() , parent );
            emails.computeIfAbsent( main , f -> new ArrayList<>() ).add(entry.getKey());
        }

        for( Map.Entry<String , List<String> > entry : emails.entrySet() ){
            List<String> value = entry.getValue();
            String na = name.get(entry.getKey());

            Collections.sort( value , (a , b) -> a.compareTo(b) );

            List<String> account = new ArrayList<>();
            account.add(na);
            account.addAll(value);

            ans.add(account);

        }

        // System.out.println(parent);
        // // System.out.println(rank);
        // // System.out.println(emails);
    
        return ans;
    }
}