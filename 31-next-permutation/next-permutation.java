class Solution {

    private int find( int[] nums , int i , int j , int target ){
        
        for( int z = j ; z >= i ; z-- ){
            if( nums[z] > target ){
                return z;
            }
        }


        return i;
    }

    private void swap( int a , int b , int[] nums ){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse( int i , int[] nums ){
        int j = nums.length - 1;

        while( i < j ){
            swap( i , j , nums );
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int index = 0;
        int n = nums.length;

        for( int i = n - 2 ; i >= 0 ; i-- ){
            if( nums[i] < nums[i + 1] ){
                int b = find( nums , i + 1 , n - 1 , nums[i] );
                int a = i;
                swap( a , b , nums );
                reverse( i + 1 , nums );
                return;
            }
        }

        reverse( 0 , nums );
    }
}