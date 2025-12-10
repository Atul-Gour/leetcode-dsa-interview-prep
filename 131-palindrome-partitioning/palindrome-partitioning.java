class Solution {
    boolean isSubstring(String s, int left, int right) {
        StringBuilder sb = new StringBuilder(s.substring(left, right + 1));
        return (sb.toString()).equals(sb.reverse().toString());
    }

    void find( HashMap<Integer , ArrayList<Integer>> map , List<List<String>> ans , List<String> curr , int index , String s){

        int n = s.length();

        if(index == n){
            ans.add( new ArrayList<>(curr));
            return;
        }else if(index > n || !map.containsKey(index)) return;

        ArrayList<Integer> list = map.get(index);

        for(int i: list){
            curr.add(s.substring(index , i+1));
            find ( map , ans , curr , i+1 , s );
            curr.remove( curr.size()-1 );
        }

    }

    public List<List<String>> partition(String s) {
        int n = s.length();

        List<List<String>> ans = new ArrayList<>();

        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();

        for(int i=0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(isSubstring( s , i , j )){
                    map.putIfAbsent(i , new ArrayList<>());
                    map.get(i).add(j);
                }
            }
        }
        System.out.print(map);
        find ( map , ans , new ArrayList<>() , 0 , s );
        return ans;
    }
}