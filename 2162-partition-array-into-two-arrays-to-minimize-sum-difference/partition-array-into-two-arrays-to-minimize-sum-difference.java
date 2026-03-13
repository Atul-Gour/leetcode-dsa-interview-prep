class Solution {

    private void findMap( int index , int elements , int sum , int nums[] , HashMap<Integer , HashSet<Integer>> map ){
        int n = nums.length;
        map.computeIfAbsent( elements , f -> new HashSet<>() ).add(sum);
        if( index == n )return;

        findMap( index + 1 , elements , sum , nums , map );        
        findMap( index + 1 , elements + 1 , sum + nums[index] , nums , map );        
    }

    private HashMap<Integer , HashSet<Integer>> helper( int nums[] ){
        int n = nums.length;
        HashMap<Integer , HashSet<Integer>> map = new HashMap<>();
        findMap( 0 , 0 , 0 , nums , map );
        return map;
    }

    public int minimumDifference(int[] nums) {
        int n = nums.length;

        int half = n/2;
        int sum = 0;
        for( int ele : nums ) sum += ele;

        HashMap<Integer , HashSet<Integer>> map1 = helper( Arrays.copyOfRange( nums , 0 , half ) );
        HashMap<Integer , HashSet<Integer>> map2 = helper( Arrays.copyOfRange( nums , half , n ) );

        int ans = Integer.MAX_VALUE;
        for( int i = 0 ; i <= half ; i++ ){
            HashSet<Integer> set1 = map1.get(i);
            HashSet<Integer> set2 = map2.get(half - i);
            List<Integer> list2 = new ArrayList<>(set2);
            Collections.sort(list2);

            for(int a : set1){

                int target = sum/2 - a;

                int idx = Collections.binarySearch(list2, target);
                if(idx < 0) idx = -idx - 1;

                if(idx < list2.size())
                    ans = Math.min(ans, Math.abs(sum - 2*(a + list2.get(idx))));

                if(idx > 0)
                    ans = Math.min(ans, Math.abs(sum - 2*(a + list2.get(idx-1))));
            }
        }

        return ans;
    }
}