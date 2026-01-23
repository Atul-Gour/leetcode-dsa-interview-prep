class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort( boxTypes , (a , b) -> Integer.compare(b[1] , a[1]) );
        int occupied = 0;
        int i = 0;
        int ans = 0;

        while( occupied < truckSize && i < boxTypes.length ){
            int taking = Math.min( truckSize - occupied , boxTypes[i][0]);
            ans += (taking * boxTypes[i][1] );
            occupied += taking;
            i++;
        }

        return ans;
    }
}