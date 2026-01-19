class Solution {
    public int numberOfSubstrings(String s) {
        int n =  s.length();
        int arr[] = new int[3];
        int ans = 0;
        int j = 0;
        int unique = 0;
        
        for(int i = 0 ; i < n ; i++ ){
            // System.out.println( "chechking " + i );
            
            while(unique != 3 && j < n){
                int curr = s.charAt(j) - 'a';
                if( arr[curr] == 0 )unique++;
                arr[curr]++;
                j++;
            }
            if(unique == 3){
                // System.out.println(i + " , "+ j);
                ans += ( n - j + 1);
            }

            int curr = s.charAt(i) - 'a';
            arr[curr]--;
            if( arr[curr] == 0 )unique--;
        }

        return ans;
    }
}