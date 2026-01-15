class Solution {

    public int minMovesToMakePalindrome(String s) {
        char[] a = s.toCharArray();
        int ans = 0;

        int l = 0, r = a.length - 1;

        while (l < r) {

            // already matched
            if (a[l] == a[r]) {
                l++;
                r--;
                continue;
            }

            // find partner for left
            int k1 = r;
            while (k1 > l && a[k1] != a[l]) k1--;

            // find partner for right
            int k2 = l;
            while (k2 < r && a[k2] != a[r]) k2++;

            // left has no partner → odd char
            if (k1 == l) {
                swap(a, l, l + 1);
                ans++;
                continue;
            }

            // right has no partner → odd char
            if (k2 == r) {
                swap(a, r, r - 1);
                ans++;
                continue;
            }

            int costLeft  = r - k1; // cost to fix left
            int costRight = k2 - l; // cost to fix right

            if (costLeft <= costRight) {
                while (k1 < r) {
                    swap(a, k1, k1 + 1);
                    ans++;
                    k1++;
                }
                l++;
                r--;
            } else {
                while (k2 > l) {
                    swap(a, k2, k2 - 1);
                    ans++;
                    k2--;
                }
                l++;
                r--;
            }
        }

        return ans;
    }

    private void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
