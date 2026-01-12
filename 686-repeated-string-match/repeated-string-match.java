class Solution {
    int ans = -1;
    public int repeatedStringMatch(String a, String b) {
        for(int i = 0 ; i < a.length() ; i++){
            if(a.charAt(i) == b.charAt(0)){
                solve( a , b , i);
                if(ans != -1)return ans;
            }
        }
        return ans;
    }

    private void solve(String a , String b, int x){
        int repeat = 1;
        for(int y = 0 ; y < b.length() ; y++){

            if(x == a.length()){
                x = 0;
                repeat++;
            }

            if(a.charAt(x) == b.charAt(y))x++;
            else return;

            if(y == b.length() - 1) ans = repeat;

        }
    }
    

}