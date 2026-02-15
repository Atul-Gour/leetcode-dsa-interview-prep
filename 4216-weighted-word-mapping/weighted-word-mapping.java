class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for( String word : words ){
            int sum = 0;
            for( char ch : word.toCharArray() ){
                sum = sum + weights[ch - 'a'] ;
            }

            sum %= 26;
            sum = 25 - sum;
            sb.append( (char)(sum + (int)'a') );
        }
        return sb.toString();
    }
}