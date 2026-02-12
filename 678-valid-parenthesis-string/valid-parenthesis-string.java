class Solution {
    public boolean checkValidString(String s) {
        int maxOpen = 0;
        int minOpen = 0;

        for( int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if( ch == '(' ){
                maxOpen++;
                minOpen++;
            }
            else if( ch == ')' ) {
                maxOpen--;
                minOpen--;
            }else{
                minOpen--;
                maxOpen++;
            }

            if( maxOpen < 0 )return false;
            minOpen = Math.max(minOpen, 0);
        }

        return minOpen == 0;
    }
}