class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for(int i : arr ){
            if(i > 0){

                st.push( i );
                
            }
            else{

                boolean destroyed = false;

                while( !destroyed && !st.isEmpty() && st.peek() > 0 && st.peek() <= Math.abs(i) ){
                    if( st.peek() == Math.abs(i) ){
                        st.pop();
                        destroyed = true;
                    }
                    else{
                        st.pop();
                    }
                }


                if(st.isEmpty() && !destroyed){
                    st.push( i );
                }
                else if(!st.isEmpty() && !destroyed && st.peek() < 0){
                    st.push(i);
                }

            }
        }
        int m = st.size();
        int ans[] = new int[m];

        for(int i = m - 1 ; i >= 0 ; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}