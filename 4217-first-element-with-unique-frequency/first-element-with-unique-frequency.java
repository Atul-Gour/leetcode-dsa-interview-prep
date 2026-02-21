class Solution {
    public int firstUniqueFreq(int[] nums) {

        int n = nums.length;
        int max = 0;
        for( int ele : nums ){
            max = Math.max( max , ele );
        }

        HashSet<Integer>[] freqNums = new HashSet[n + 1];
        int[] numFreq = new int[max + 1];

        for( int i = 0 ; i <= n ; i++ ){
            freqNums[i] = new HashSet<>();
        }        

        for( int ele : nums ){
            freqNums[numFreq[ele]].remove(ele);
            numFreq[ele]++;
            freqNums[numFreq[ele]].add( ele );
        }

        for( int ele : nums ){
            if( freqNums[numFreq[ele]].size() == 1 )return ele;
        }
        return -1;
    }
}