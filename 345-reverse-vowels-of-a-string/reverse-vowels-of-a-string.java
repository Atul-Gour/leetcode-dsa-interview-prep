class Solution {

    private boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);

        return ch == 'a' ||
            ch == 'e' ||
            ch == 'i' ||
            ch == 'o' ||
            ch == 'u';
    }
    
    private void swap( StringBuilder sb , int i , int j ){
        char temp = sb.charAt(i);
        sb.setCharAt(i , sb.charAt(j));
        sb.setCharAt(j , temp);
    }

    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);

        int j = sb.length() - 1;

        while( j >= 0 && !isVowel(sb.charAt(j)) ){
            j--;
        }

        if( j < 0 ) return s;

        for( int i = 0 ; i < s.length() && i < j ; i++ ){

            if( !isVowel(sb.charAt(i)) ) continue;

            swap( sb , i , j );
            j--;

            while( j >= 0 && j > i && !isVowel(sb.charAt(j)) ){
                j--;
            }

        }

        return sb.toString();
    }
}