class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        if( m < n ) return gcdOfStrings(str2 , str1);

        for( int len = n ; len > 0 ; len-- ){
            if( n % len != 0 || m % len != 0 ) continue;

            boolean equal = true;
            int i = 0;
            int j = 0;

            while( (i + len - 1) < n && j + len - 1 < m && equal ){
                for( int k = 0 ; k < len ; k++ ){
                    if( str1.charAt(k) == str1.charAt(i) && str1.charAt(k) == str2.charAt(j) ){
                        i++;
                        j++;
                    }
                    else {
                        equal = false;
                        break;
                    }
                }
            }

            while( j + len - 1 < m && equal ){
                for( int k = 0 ; k < len ; k++ ){
                    if( str1.charAt(k) == str2.charAt(j) ){
                        j++;
                    }
                    else {
                        equal = false;
                        break;
                    }
                }
            }

            if( equal ) return str1.substring(0 , len);
        }

        return "";
    }
}