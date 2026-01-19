class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int a = arr[i];
            int b = -1;
            int bIndex = -1;
            int j = i;
            int currAns = 0;
            while(j < n){

                if(arr[j] == a || arr[j] == b ){
                    if(arr[j] == a && bIndex != -1 ){
                        bIndex = -1;
                    }
                    else if( arr[j] == b && bIndex == -1 ){
                        bIndex = j;
                    }
                    currAns++;
                }
                else if( b == -1){
                    b = arr[j];
                    bIndex = j;
                    currAns++;
                }else {
                    ans = Math.max( ans , currAns );
                    break;
                }
                j++;
            }
            if( j == n){
                ans = Math.max( ans , currAns );
                return ans;
            }
            // System.out.println(a + ", " + b +" = " + i + " , " +j  + " " + currAns);
            if(bIndex != -1) i = bIndex - 1;
        }
        return ans;
    }
}