class Solution {

    void swap( int[] nums , int x , int y ){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    int solve( int nums[] , int index ){
        int n = nums.length;

        if( nums[index] == -1 ){
            nums[index] = index + 1;
            return -1;
        }

        if( nums[index] == index + 1 ) return index + 1;

        int temp = nums[index];
        nums[index] = index + 1;

        return solve( nums , temp - 1 );
    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for( int i = 0 ; i < n ; i++ ){
            int ele = nums[i];
            if( ele == i+1 ) continue;

            if( nums[ele - 1] == ele ) return ele;

            nums[i] = -1;
            int ans = solve( nums , ele - 1 );

            if( ans != -1 ) return ans;
        }

        return n;
    }
}

