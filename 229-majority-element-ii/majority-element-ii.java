class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int a = -1;
        int aFreq = 0;
        int b = -1;
        int bFreq = 0;

        int n = nums.length;

        for( int ele : nums ){
            if( a == ele ){
                aFreq++;
            }
            else if( b == ele ){
                bFreq++;
            }
            else if(aFreq == 0 && b != ele){
                a = ele;
                aFreq = 1;
            }
            else if( bFreq == 0 ){
                b = ele;
                bFreq = 1;
            }
            else{
                aFreq--;
                bFreq--;
            }
        }

        aFreq = 0;
        bFreq = 0;

        for( int ele : nums ){
            if( a == ele ) aFreq++;
            else if( b == ele ) bFreq++;
        }

        List<Integer> ans = new ArrayList<>();

        if( aFreq > n/3 ) ans.add(a);
        if( bFreq > n/3 ) ans.add(b);

        return ans;
    }
}