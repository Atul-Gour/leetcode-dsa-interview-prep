class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = nums1.length;
        int m = nums2.length;

        HashMap<Integer , Integer> map = new HashMap<>(); 

        for( int i = m - 1 ; i >= 0 ; i-- ){
            while( !stack.isEmpty() && nums2[stack.peek()] <= nums2[i] ){
                stack.pop();
            }

            if( stack.isEmpty() ){
                map.put( nums2[i] , -1 );
            }
            else map.put( nums2[i] , nums2[stack.peek()] );

            stack.push(i);
        }

        int ans[] = new int[n];

        for( int i = 0 ; i < n ; i++ ){
            ans[i] = map.get( nums1[i] );
        }

        return ans;
    }
}