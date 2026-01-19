class Solution {
    public int numberOfSubstrings(String s) {
        int n =  s.length();
        int arr[] = new int[3];
        int ans = 0;
        
        for(int i = 0 ; i < n ; i++ ){
            arr = new int[3];
            // System.out.println( "chechking " + i );
            int unique = 0;
            int j = i;
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
        }

        return ans;
    }
}