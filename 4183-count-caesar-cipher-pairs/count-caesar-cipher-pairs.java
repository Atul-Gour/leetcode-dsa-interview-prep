class Solution {
    public long countPairs(String[] words) {
        for (int i = 0; i < words.length; i++) {
            var arr = words[i].toCharArray();
            int diff = 26 - (arr[0] - 'a');
            for (int j = 0; j < arr.length; j++) {
                arr[j] = (char) ('a' + (arr[j] - 'a' + diff) % 26);
            }
            words[i] = new String(arr);
        }
        var ans = 0L;
        var count = new HashMap<String, Integer>();
        for (String s : words) {
            ans += count.getOrDefault(s, 0);
            count.merge(s, 1, Integer::sum);
        }
        return ans;
    }
}