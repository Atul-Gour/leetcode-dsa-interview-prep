class Solution {

    private void gen(int idx, int end, int[] arr, int cnt, long sum,
                     ArrayList<Long>[] res) {
        if (idx == end) {
            res[cnt].add(sum);
            return;
        }
        gen(idx + 1, end, arr, cnt, sum, res);
        gen(idx + 1, end, arr, cnt + 1, sum + arr[idx], res);
    }

    public int minimumDifference(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        int[] left = Arrays.copyOfRange(nums, 0, half);
        int[] right = Arrays.copyOfRange(nums, half, n);

        ArrayList<Long>[] L = new ArrayList[half + 1];
        ArrayList<Long>[] R = new ArrayList[half + 1];

        for (int i = 0; i <= half; i++) {
            L[i] = new ArrayList<>();
            R[i] = new ArrayList<>();
        }

        gen(0, half, left, 0, 0, L);
        gen(0, half, right, 0, 0, R);

        for (int i = 0; i <= half; i++) {
            Collections.sort(R[i]);
        }

        long total = 0;
        for (int x : nums) total += x;

        long ans = Long.MAX_VALUE;

        for (int i = 0; i <= half; i++) {
            int j = half - i;
            for (long a : L[i]) {
                long need = total / 2 - a;
                ArrayList<Long> list = R[j];

                int idx = Collections.binarySearch(list, need);
                if (idx < 0) idx = -idx - 1;

                if (idx < list.size())
                    ans = Math.min(ans, Math.abs(total - 2 * (a + list.get(idx))));
                if (idx > 0)
                    ans = Math.min(ans, Math.abs(total - 2 * (a + list.get(idx - 1))));
            }
        }

        return (int) ans;
    }
}
