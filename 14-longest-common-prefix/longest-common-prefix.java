class Solution {
    public String longestCommonPrefix(String[] arr) {

        Arrays.sort(arr , (a , b) -> (
            Integer.compare(a.length() , b.length())
        ));
        StringBuilder sb = new StringBuilder(arr[0]);

        for(int i = 1 ; i < arr.length ; i++){
            String curr = arr[i];
            int len = 0;

            while(len < curr.length() && len < sb.length() && sb.charAt(len) == curr.charAt(len)){
                len++;
            }

            if ( len == 0 ) return "";
            sb.setLength(len);
            
        }
        return sb.toString();
    }
}