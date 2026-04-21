class Solution {
    private boolean possible(int[] stones, int jump) {
        int n = stones.length;
        boolean[] taken = new boolean[n];
        int i = 0;
        
        while (i < n - 1) {
            int j = i + 1;
            while (j + 1 < n && stones[j + 1] - stones[i] <= jump) {
                j++;
            }
            if (stones[j] - stones[i] > jump) {
                return false;
            }
            taken[j] = true;
            i = j;
        }
        
        i = n - 1;
        for (int j = n - 2; j >= 0; j--) {
            if (!taken[j] || j == 0) {
                if (stones[i] - stones[j] > jump) {
                    return false;
                }
                i = j;
            }
        }
        
        return true;
    }

    public int maxJump(int[] stones) {
        int n = stones.length;
        int ans = stones[n - 1] - stones[0];
        int low = stones[1] - stones[0];
        int high = stones[n - 1] - stones[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(stones, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}