class Solution {

    private void swap( int i , int j , int[] nums ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;

        while( j >= 0 && nums[j] == 2 ) j--;
        while( i < n && nums[i] == 0 ) i++;

        for( int k = i ; k < n && k <= j ; ){

            // System.out.println( i + " " + k + " " + j + " arr down " );
            // for( int ele : nums ) System.out.print( ele  + " " );
            // System.out.println();

            if( nums[k] == 2 ){
                swap( k , j , nums );
                j--;
                if( nums[k] == 0 ){
                    swap( i , k , nums );
                    i++;
                }
            }
            else if( nums[k] == 0 ){
                swap( k , i , nums );
                i++;
                if( nums[k] == 2 ){
                    swap( j , k , nums );
                    j--;
                }
            }

            if( nums[k] == 1 ) k++;
            else if( k <= i ) k++;

        }
    }
}