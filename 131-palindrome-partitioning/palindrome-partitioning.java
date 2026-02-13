class Solution {

    void solve( int index , char[] arr , ArrayList<String> currList , List<List<String>> ans ){
        int n = arr.length;
        if( index >= n ){
            ans.add(new ArrayList<>( currList ));
            return ;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = index ; i < n ; i++){

            sb.append(arr[i]);
            StringBuilder reverseSb = new StringBuilder(sb);
            reverseSb.reverse();

            if( sb.compareTo(reverseSb) == 0 ){
                currList.add(sb.toString());
                solve( i + 1 , arr , currList , ans );
                currList.remove( currList.size() - 1 );
            }
        }

    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve( 0 , s.toCharArray() , new ArrayList<>() , ans );

        return ans;
    }
}