class Solution {
    private ArrayList<String> splitExpression( String s ){

        int n = s.length();
        ArrayList<String> list = new ArrayList<>();

        int parenthesis = 0;
        StringBuilder sb = new StringBuilder();

        for( int i = 0 ; i < n ; i++ ){

            char ch = s.charAt(i);

            if( ch == '(' ){
                parenthesis++;
                sb.append(ch);
            }
            else if( ch == ')' ){
                parenthesis--;
                sb.append(ch);
            }
            else if( ch == ',' ){
                if( parenthesis == 0 ){
                    list.add( sb.toString() );
                    sb.setLength(0);
                }
                else sb.append(ch);
            }
            else sb.append( ch );
        }

        if( !sb.isEmpty() ) list.add(sb.toString());
        return list;
    }

    public boolean parseBoolExpr(String expression) {
        
        char ch = expression.charAt(0);

        if( ch == 't' ) return true;
        else if( ch == 'f' ) return false;
        else if( ch == '&' ){
            String subExpression = expression.substring( 2 , expression.length() - 1 );
            ArrayList<String> subExpressions = splitExpression( subExpression );

            for( String exp : subExpressions ){
                if( !parseBoolExpr( exp ) ) return false;
            }

            return true;
        }
        else if( ch == '|' ){
            String subExpression = expression.substring( 2 , expression.length() - 1 );
            ArrayList<String> subExpressions = splitExpression( subExpression );

            for( String exp : subExpressions ){
                if( parseBoolExpr( exp ) ) return true;
            }

            return false;
        }
        else if( ch == '!' ){
            String subExpression = expression.substring( 2 , expression.length() - 1 );

            return !parseBoolExpr(subExpression);
        }
        else return false;
    }
}