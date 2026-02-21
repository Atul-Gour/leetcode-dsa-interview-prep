class Solution {
    public int firstUniqueFreq(int[] nums) {

        int n = nums.length;
        int max = 0;
        for( int ele : nums ){
            max = Math.max( max , ele );
        }

        int[] freqNums = new int[n + 1];
        int[] numFreq = new int[max + 1];       

        for( int ele : nums ){
            freqNums[numFreq[ele]]--;
            numFreq[ele]++;
            freqNums[numFreq[ele]]++;
        }

        for( int ele : nums ){
            if( freqNums[numFreq[ele]] == 1 )return ele;
        }
        return -1;
    }
}