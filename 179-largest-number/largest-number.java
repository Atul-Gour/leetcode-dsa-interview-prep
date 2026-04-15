class Solution {
    static int comp( Integer a , Integer b ){
        String aString = String.valueOf(a);
            String bString = String.valueOf(b);

            String ab = aString + bString;
            String ba = bString + aString;

            return ba.compareTo(ab);
    }

    public String largestNumber(int[] nums) {

        Integer arr[] = new Integer[nums.length];

        for(  int i = 0 ; i < nums.length ; i++ ){
            arr[i] = (Integer) nums[i];
        }

        Arrays.sort(arr, (a , b) -> comp(a, b));

        StringBuilder sb = new StringBuilder();
        
        if (arr[0] == 0) return "0";

        for( int ele : arr ){
            sb.append( ele );
        }

        return sb.toString();
    }
}