class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int currSum = 0;
        int count = 0;
        int l = 0;
        int a = -1;
        int r = 0;

        if(goal == 0){

            while(r < n ){
                while(l < n && nums[l] == 1 )l++;

                r = l;
                while(r < n && nums[r] == 0 )r++;
                int total = r - l ;
                count += ( (total + 1) * total ) / 2;
                l = r;
            }

            return count;
        }
        

        for(r = 0 ; r < n ;r++){
            currSum += nums[r];

            if(currSum == goal && a == -1){
                a = r;
            }

            if(r + 1 < n && currSum + nums[ r + 1 ] <= goal){
                continue;
            }
            else{
                if(a == -1 )a = r;
                while( l < n && currSum == goal ){
                    count += (r - a + 1);
                    currSum -= nums[l];
                    l++;
                }
                a = -1;
            }
        }
        
        return count;
    }   
}