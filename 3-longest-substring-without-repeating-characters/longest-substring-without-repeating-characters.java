class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set= new HashSet<>();
        int max=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(set.contains(s.charAt(j))){
                    max=Math.max(max,set.size());
                    set.clear();
                    break;
                }
                set.add(s.charAt(j));
            }
        }
        max=Math.max(max,set.size());
        for(char c:set){
            System.out.print(c+" ");
        }
        return max;
    }
}