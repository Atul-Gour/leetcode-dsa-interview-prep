class Solution {
    public int almostPalindromic(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;

        for( int i = 0 ; i < s.length() ; i++ ){
            ans = Math.max( ans , findString( i , i , arr ) );
            ans = Math.max( ans , findString( i , i + 1 , arr ) );
        }

        return ans;

    }

    private int findString( int left , int right , char[] arr ){
        int n = arr.length;

        while( left >= 0 && right < n && arr[left] == arr[right] ){
            left--;
            right++;
        }

        if( left >= 0 || right < n ){
            return Math.max ( find( left - 1 , right , arr ) , find( left , right + 1 , arr ) );
        }
        else{
            return right - left - 1; 
        }
    }

    private int find( int left , int right , char[] arr ){
        int n = arr.length;

        while( left >= 0 && right < n && arr[left] == arr[right] ){
            left--;
            right++;
        }

        return right - left - 1; 

    }
}