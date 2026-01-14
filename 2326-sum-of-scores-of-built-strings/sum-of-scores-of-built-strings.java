class Solution {
    public long sumScores(String s) {
        int n = s.length();
        int z[] = new int[n];

        int l = 0 , r = 0;
        long ans = n;

        for(int i = 1 ; i < n ; i++){

            if(i <= r)
                z[i] = Math.min(z[i - l] , r - i + 1 );

            while(i + z[i] < n && s.charAt(i + z[i]) == s.charAt(z[i])) z[i]++;

            if(z[i] + i - 1 > r){
                l = i;
                r = z[i] + i - 1;
            }
        }

        for(int ele : z){
            ans += ele ;
        }

        return ans;

    }
}