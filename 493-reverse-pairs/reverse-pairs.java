class Solution {
    public int reversePairs(int[] nums){
        int n = nums.length;
        if(n <= 1) return 0;
        
        ArrayList<Long> list = new ArrayList<>();
        for(int i : nums){
            list.add((long)i);
        }
        Collections.sort(list, Collections.reverseOrder());
        int ans = 0;
        
        for(int i = n - 1 ; i > 0 ; i--){
            long curr = nums[i];
            
            // Binary search to find curr (faster than linear search)
            int index = Collections.binarySearch(list, curr, Collections.reverseOrder());
            
            list.remove(index);
            
            if(list.isEmpty()){
                continue;
            }
            
            long toFind = curr * 2;
            
            if(list.get(0) <= toFind){
                continue;
            }
            
            // Binary search for first element <= toFind
            int left = 0, right = list.size() - 1;
            int pos = -1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(list.get(mid) > toFind){
                    pos = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            if(pos >= 0) ans += pos + 1;
        }
        return ans;
    }
}