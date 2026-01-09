class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs , (a , b)->{
            return a[1] - b[1];
        });
        int ans = 0;
        // for(int arr[]: pairs){
        //     System.out.println(arr[0] +" , "+ arr[1]);
        // }
        int last = Integer.MIN_VALUE;
        for(int arr[] : pairs){
            if(arr[0] <= last)continue;

            ans++;
            last = arr[1];
        }
        return ans;
    }
}