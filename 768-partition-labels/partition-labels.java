class Solution {
    public List<Integer> partitionLabels(String s) {
        int start[] = new int[26];
        int end[] = new int[26];

        Arrays.fill(start , -1);

        int n = s.length() ;
        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            int ch = s.charAt(i) - 'a';

            if(start[ch] == -1){
                start[ch] = i;
                end[ch] = i;
            }else{
                end[ch] = i;
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            int last = end[s.charAt(i) - 'a'];
            for(int j = i ; j < n ; j++){

                int ch = s.charAt(j) - 'a';
                last = Math.max(last , end[ch]);
                if(last == j){
                    ans.add(j - i + 1);
                    i = j;
                    break;
                }
                
            }
        }
        return ans;
    }
}