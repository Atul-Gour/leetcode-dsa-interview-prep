class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int arr[][] = new int[n][m];

        for(int i = 0 ; i < n ; i++ ){
            for(int j = 0 ; j < m ; j++ ){
                arr[i][j] = matrix[i][j] - '0';
            }
        }

        for(int i = n-2 ; i >= 0 ; i-- ){
            for(int j = 0 ; j < m ; j++ ){
                if( arr[i][j] == 1 ){
                    arr[i][j] = arr[i + 1][j] + 1;
                }
            }
        }

        Stack<Integer> st = new Stack<>();
        int left[] = new int[m];
        int right[] = new int[m];
        int ans = 0;

        for(int a[] : arr){

            for(int i = 0 ; i < m ; i++){
                while(!st.isEmpty() && a[st.peek()] >= a[i] ){
                    st.pop();
                }

                if( st.isEmpty() )
                    left[i] = -1;
                else 
                    left[i] = st.peek();

                st.push(i);
            }

            st.clear();

            for( int i = m-1 ; i >= 0 ; i-- ){
                while(!st.isEmpty() && a[st.peek()] >= a[i] ){
                    st.pop();
                }

                if( st.isEmpty() )
                    right[i] = m;
                else 
                    right[i] = st.peek();

                st.push(i);
            }
            st.clear();

            for( int i = 0 ; i < m ; i++ ){
                ans = Math.max( ans , a[i] * ( right[i] - left[i] - 1 ) );
            }
        }
        return ans;
    }
}