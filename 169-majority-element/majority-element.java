class Solution {
    public int majorityElement(int[] nums) {
        int element = 0;
        int freq = 0;

        for( int ele : nums ){
            if( freq == 0 ){
                element = ele;
                freq = 1;
            }
            else freq += (ele == element ? 1 : -1);
        }

        return element;
    }
}