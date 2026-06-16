class Solution {
    public String processStr(String s) {

        StringBuilder sb = new StringBuilder();

        for( char ch : s.toCharArray() ){

            switch( ch ){
                case '*' : {
                    if( !sb.isEmpty() ) sb.deleteCharAt( sb.length() - 1 );
                    break;
                }
                case '#' : {
                    sb.append(sb);
                    break;
                }
                case '%' : {
                    sb.reverse();
                    break;
                }
                default : {
                    sb.append(ch);
                    break;
                }
            }
            
        }

        return sb.toString();
    }
}