import java.util.*;

class Solution {

    private void findMap(int index, int elements, int sum, int[] nums,
                         HashSet<Integer>[] set) {

        set[elements].add(sum);

        if (index == nums.length) return;

        findMap(index + 1, elements, sum, nums, set);
        findMap(index + 1, elements + 1, sum + nums[index], nums, set);
    }

    private HashSet<Integer>[] helper(int[] nums) {

        int n = nums.length;

        HashSet<Integer>[] set = new HashSet[n + 1];

        for (int i = 0; i <= n; i++)
            set[i] = new HashSet<>();

        findMap(0, 0, 0, nums, set);

        return set;
    }

    public int minimumDifference(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        int total = 0;
        for (int x : nums) total += x;

        HashSet<Integer>[] left =
                helper(Arrays.copyOfRange(nums, 0, half));

        HashSet<Integer>[] right =
                helper(Arrays.copyOfRange(nums, half, n));

        ArrayList<Integer>[] sortedRight = new ArrayList[half + 1];

        for (int i = 0; i <= half; i++) {
            sortedRight[i] = new ArrayList<>(right[i]);
            Collections.sort(sortedRight[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= half; i++) {

            HashSet<Integer> set1 = left[i];
            ArrayList<Integer> list2 = sortedRight[half - i];

            for (int a : set1) {

                int target = total / 2 - a;

                int idx = Collections.binarySearch(list2, target);
                if (idx < 0) idx = -idx - 1;

                if (idx < list2.size())
                    ans = Math.min(ans,
                            Math.abs(total - 2 * (a + list2.get(idx))));

                if (idx > 0)
                    ans = Math.min(ans,
                            Math.abs(total - 2 * (a + list2.get(idx - 1))));
            }
        }

        return ans;
    }
}