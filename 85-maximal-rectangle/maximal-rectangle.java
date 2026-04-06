class Solution {

    private int maxRectangle( int[] nums ){
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for( int i = 0 ; i < n ; i++ ){
            while( !st.isEmpty() && nums[st.peek()] >= nums[i] ){
                st.pop();
            }

            if( st.isEmpty() ) left[i] = -1;
            else left[i] = st.peek();
            
            st.push(i);
        }

        st.clear();

        for( int i = n-1 ; i >= 0 ; i-- ){
            while( !st.isEmpty() && nums[st.peek()] >= nums[i] ){
                st.pop();
            }

            if( st.isEmpty() ) right[i] = n;
            else right[i] = st.peek();
            
            st.push(i);
        }

        int maxRec = 0;

        for( int i = 0 ; i < n ; i++ ){
            maxRec = Math.max( maxRec , nums[i] * (right[i] - left[i] - 1) );
        }

        return maxRec;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] grid = new int[n + 1][m];
        
        for( int i = n - 1 ; i >= 0 ; i-- ){
            for( int j = 0 ; j < m ; j++ ){
                if( matrix[i][j] == '0' ) continue;
                grid[i][j] = grid[i+1][j] + (matrix[i][j] == '1' ? 1 : 0);
            }
        }


        int ans = 0;

        for( int i = 0 ; i < n ; i++ ){
            int maxRec = maxRectangle( grid[i] );
            ans = Math.max( ans , maxRec );
        }

        return ans;
    }
}