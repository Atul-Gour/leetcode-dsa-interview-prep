import java.util.*;

class Solution {
    boolean calculate(int currSum, int targetSum, int index, int[] nums, Set<String> memo){
        if(currSum == targetSum) return true;
        if(currSum > targetSum || index >= nums.length) return false;

        String key = currSum + "," + index;
        if(memo.contains(key)) return false;  // already visited

        // Option 1: take current element
        if(calculate(currSum + nums[index], targetSum, index + 1, nums, memo)) return true;

        // Option 2: skip current element
        if(calculate(currSum, targetSum, index + 1, nums, memo)) return true;

        memo.add(key);
        return false;
    }

    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int num : nums) sum += num;

        if(sum % 2 != 0) return false;

        Set<String> memo = new HashSet<>();
        return calculate(0, sum / 2, 0, nums, memo);
    }
}
