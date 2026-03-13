import java.util.*;

class Solution {

    private void findMap(int index, int elements, int sum, int[] nums,
                         ArrayList<Integer>[] list) {

        list[elements].add(sum);

        if (index == nums.length) return;

        findMap(index + 1, elements, sum, nums, list);
        findMap(index + 1, elements + 1, sum + nums[index], nums, list);
    }

    private ArrayList<Integer>[] helper(int[] nums) {

        int n = nums.length;

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        findMap(0, 0, 0, nums, list);

        return list;
    }

    public int minimumDifference(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        int total = 0;
        for (int x : nums) total += x;

        ArrayList<Integer>[] left =
                helper(Arrays.copyOfRange(nums, 0, half));

        ArrayList<Integer>[] right =
                helper(Arrays.copyOfRange(nums, half, n));

        for (int i = 0; i <= half; i++) {
            Collections.sort(right[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= half; i++) {

            ArrayList<Integer> list1 = left[i];
            ArrayList<Integer> list2 = right[half - i];

            for (int a : list1) {

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