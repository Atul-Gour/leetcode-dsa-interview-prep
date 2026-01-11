class Solution {
    public long countPairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        long ans = 0;

        for(String s : words){
            StringBuilder sb = new StringBuilder();
            int toDelete = s.charAt(0) - 'a';
            for(char ch: s.toCharArray()){
                int curr = ch - 'a' - toDelete;
                if(curr < 0)curr += 26;
                sb.append(curr);
                sb.append("#");
            }
            String sbString = sb.toString();
            ans += map.getOrDefault(sbString, 0);
            map.put(sbString, map.getOrDefault(sbString, 0) + 1);
        }
        return ans;
    }
}