class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = (int) Math.pow(2, k);
        boolean[] present = new boolean[n];

        if (s.length() < k)
            return false;

        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            num = ((num << 1) & ((1 << k) - 1)) | (s.charAt(i) - '0');

            if (i >= k - 1) {
                present[num] = true;
            }
        }

        for (boolean ele : present) {
            if (!ele)
                return false;
        }

        return true;
    }
}