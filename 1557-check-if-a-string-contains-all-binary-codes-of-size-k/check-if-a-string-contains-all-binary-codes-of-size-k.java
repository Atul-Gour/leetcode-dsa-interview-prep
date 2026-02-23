class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) return false;

        int total = 1 << k;         
        boolean[] present = new boolean[total];

        int mask = total - 1;         
        int num = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            num = ((num << 1) & mask) | (s.charAt(i) - '0');

            if (i >= k - 1 && !present[num]) {
                present[num] = true;
                count++;
                if (count == total) return true;
            }
        }

        return false;
    }
}