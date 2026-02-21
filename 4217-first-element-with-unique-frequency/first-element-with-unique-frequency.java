class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        HashMap<Integer , Integer> freq = new HashMap<>();
        int n = nums.length;
        

        for( int ele : nums ){
            freq.put( ele , freq.getOrDefault(ele , 0) + 1 );
        }

        for( int f : freq.values() ){
            map.put(f , map.getOrDefault( f , 0 ) + 1);
        }

        for( int ele : nums ){
            int currFreq = freq.get(ele);
            if( map.get(currFreq) == 1 )return ele;
        }
        return -1;
    }
}