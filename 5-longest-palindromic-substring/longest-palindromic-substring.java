class Solution {

    static private int expand (char arr[] , int i , int j ){
        int n = arr.length;

        while( i >= 0 && j < n && arr[i] == arr[j] ){
            i--;
            j++;
        }

        return j - i - 1;

    }

    public String longestPalindrome(String ss) {
        char arr[] = ss.toCharArray();
        int n = arr.length;

        String s = "";
        int maxLen = 0;

        for( int i = 0  ; i < n ; i++ ){
            int oddLen = expand( arr , i , i );
            if( oddLen > maxLen ){
                s = ss.substring(i - oddLen/2 , i + oddLen/2 + 1);
                maxLen = oddLen;
            }

            int evenLen = expand( arr , i , i + 1 );
            if( evenLen > maxLen ){
                s = ss.substring(i - evenLen/2 + 1 , i + evenLen/2 + 1);
                maxLen = evenLen;
            }
        }

        return s;
    }
}