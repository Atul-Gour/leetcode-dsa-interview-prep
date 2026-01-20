class Solution {
    private int find(int[] nums , int k){
        int count = 0;
        int oddCount = 0;
        int l = 0;
        
        for(int r = 0 ; r < nums.length ; r++ ){
            if( nums[r] % 2 != 0 ){
                oddCount++;
            }

            while( oddCount > k ){
                if(nums[l] % 2 != 0){
                    oddCount--;
                }
                l++;
            }
            count += (r - l + 1);
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return find(nums , k) - find( nums , k - 1 );
    }
}