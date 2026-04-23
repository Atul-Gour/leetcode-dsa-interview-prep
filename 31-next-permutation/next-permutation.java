class Solution {

    private int find( int[] nums , int i , int j , int target ){
        int maxIndex = i;
        int max = 101;
        
        for( int z = i ; z <= j ; z++ ){
            if( nums[z] > target ){
                if( nums[z] <= max ){
                    max = nums[z];
                    maxIndex = z;
                }
            }
        }

        // System.out.println( i + " " + nums[i] + " " + target + " " + maxIndex + " " + max );

        return maxIndex;
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