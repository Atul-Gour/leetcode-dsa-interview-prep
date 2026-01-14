class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int z[] = new int[n];
        int l = 0, r = 0;
        int index = -1;
        int maxLength = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(z[i - l], r - i + 1);
            }

            while (z[i] + i < n && s.charAt(z[i] + i) == s.charAt(z[i]))
                z[i]++;

            if (z[i] + i - 1 > r) {
                l = i;
                r = z[i] + i - 1;
            }

        }

        for (int i = 0 ; i < n ; i++) {
            if(z[i] > maxLength && i + z[i] -1 == n - 1 ){
                index = i;
                maxLength = z[i];
            }
        }

        return index == -1 ? "": s.substring(0, maxLength);

    }
}