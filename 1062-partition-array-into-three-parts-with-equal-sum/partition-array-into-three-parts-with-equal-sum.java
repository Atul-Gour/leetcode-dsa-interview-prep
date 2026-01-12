class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int total = 0;
        for (int x : arr) total += x;

        if (total % 3 != 0) return false;

        int target = total / 3;
        int curr = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];

            if (curr == target) {
                count++;
                curr = 0;
            }
        }

        return count >= 3;
    }
}
