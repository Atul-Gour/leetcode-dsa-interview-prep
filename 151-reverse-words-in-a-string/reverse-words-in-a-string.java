class Solution {
    public String reverseWords(String s) {
        String[] arr = s.strip().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int  i = arr.length-1 ; i>=0 ; i--){
            if(arr[i].equals("")){
                System.out.println(" hell ");
                continue;
            }
            sb.append(arr[i].strip());
            sb.append(" ");
        }
        return sb.toString().strip();
    }
}