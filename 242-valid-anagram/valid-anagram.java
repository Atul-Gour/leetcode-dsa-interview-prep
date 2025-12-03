class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int character[] = new int[26];
        for(char i: s.toCharArray())character[i-'a']++;
        for(char i:t.toCharArray()){
            character[i-'a']--;
        }
        for(int i: character){
            if(i!=0)return false;
        }
        return true;
    }
}