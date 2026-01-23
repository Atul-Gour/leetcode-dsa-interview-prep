class Solution {
    public boolean canBeValid(String s, String locked) {

        if( s.length() % 2 != 0)return false;
        int minCount = 0 , maxCount = 0;

        for(int i = 0 ; i < s.length() ; i++){
            if(locked.charAt( i ) == '0'){
                minCount--;
                maxCount++;
            }else{
                if( s.charAt( i ) == '(' ){
                    minCount++;
                    maxCount++;
                }else{
                    minCount--;
                    maxCount--;
                }
            }

            if( maxCount < 0 ) return false;
            minCount = Math.max( minCount , 0 );
        }

        return minCount == 0;
    }
}