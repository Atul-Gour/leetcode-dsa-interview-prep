class Solution {
    static HashSet<Long> set ;

    private long[] toSortedLongArray(Set<Long> set) {
        long[] arr = new long[set.size()];
        int idx = 0;

        for (long val : set) {
            arr[idx++] = val;
        }

        Arrays.sort(arr);
        return arr;
    }

    private long justSmaller(long[] arr , long target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        long next = Long.MIN_VALUE;

        while(left <= right){
            int middle = left + ( right - left )/2;

            if(arr[middle] <= target){
                next = arr[middle];
                left = middle + 1;
            }else{
                right = middle -1;
            }
        }
        return next;
    }
    private long justGreater(long[] arr , long target){
        int n = arr.length;
        int left = 0;
        int right = n-1;
        long next = Long.MAX_VALUE;

        while(left <= right){
            int middle = left + ( right - left )/2;

            if(arr[middle] >= target){
                next = arr[middle];
                right = middle -1;
            }else{
                left = middle + 1;
            }
        }
        return next;
    }

    private int findAns(int n , HashMap<Integer , HashSet<Long>> map1, HashMap<Integer , HashSet<Long>> map2 , long total){
        int ans = Integer.MAX_VALUE;
        long target = total/2;

        for(int i = 0 ; i <= n ; i++){
            int j = n - i;

            if(!map1.containsKey(i) || !map2.containsKey(j))continue;

            long[] arr1 = toSortedLongArray(map1.get(i));
            long[] arr2 = toSortedLongArray(map2.get(j));

            for (long s1 : arr1) {
                long need = target - s1;

                long s2a = justSmaller(arr2, need);
                long s2b = justGreater(arr2, need);

                if (s2a != Long.MIN_VALUE)
                    ans = Math.min(ans, (int)Math.abs(total - 2 * (s1 + s2a)));

                if (s2b != Long.MAX_VALUE)
                    ans = Math.min(ans, (int)Math.abs(total - 2 * (s1 + s2b)));
            }
        }

        return ans;

    }

    private void solve(long currSum , int i , int elements , int arr[] , HashMap<Integer , HashSet<Long>> map){
        int n = arr.length;

        map.computeIfAbsent(elements , f -> new HashSet<>()).add(currSum);

        if(i >= n)return;
        long key = 0;

        key |= (long) i << 34;
        key |= (long) elements << 29;
        key |= (currSum + 300_000_000L);

        if(set.contains(key))return;

        solve(currSum , i + 1 , elements , arr , map);
        solve(currSum + arr[i] , i + 1  , elements + 1 , arr , map);

        set.add(key);
    }

    public int minimumDifference(int[] nums) {

        long total = 0;
        for(int  ele : nums ){
            total += ele;
        }

        int n = nums.length;

        int arr1[] = new int[n/2];
        for(int i = 0 ; i < n/2 ; i++ ){
            arr1[i] = nums[i];
        }

        int arr2[] = new int[n/2];
        for(int i = n/2 ; i < n ; i++ ){
            arr2[i - n/2] = nums[i];
        }

        set = new HashSet<>();
        HashMap<Integer , HashSet<Long>> map1 = new HashMap<>();
        solve(0 , 0 , 0, arr1 , map1);

        set = new HashSet<>();
        HashMap<Integer , HashSet<Long>> map2 = new HashMap<>();
        solve(0 , 0 , 0, arr2 , map2);


        return findAns(n/2 , map1 , map2 , total);
    }
}