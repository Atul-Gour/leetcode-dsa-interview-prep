class Solution {

    static private int expand (char arr[] , int i , int j ){
        int n = arr.length;

        while( i >= 0 && j < n && arr[i] == arr[j] ){
            i--;
            j++;
        }

        return j - i - 1;

    }

    public String longestPalindrome(String s) {
        if( s == null || s.length() < 1 )return "";
        char arr[] = s.toCharArray();
        int n = arr.length;

        int start = 0;
        int end = 0;

        for( int i = 0  ; i < n ; i++ ){
            int oddLen = expand( arr , i , i );
            int evenLen = expand( arr , i , i + 1 );
            int len = Math.max(oddLen, evenLen);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start , end + 1);
    }
}