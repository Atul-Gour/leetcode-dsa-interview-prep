class Solution {
    public String largestNumber(int[] nums) {

        Integer arr[] = new Integer[nums.length];

        for(  int i = 0 ; i < nums.length ; i++ ){
            arr[i] = (Integer) nums[i];
        }

        Arrays.sort(arr, (a, b) -> {
            String aString = String.valueOf(a);
            String bString = String.valueOf(b);

            String ab = aString + bString;
            String ba = bString + aString;

            return ba.compareTo(ab);
        });

        StringBuilder sb = new StringBuilder();
        
        int index = 0;

        if( arr.length >= 2 && arr[0] == 0 ){
            sb.append("0");
            while( index < arr.length && arr[index] == 0 ) index++;
        }

        for( ; index < arr.length ; index++ ){
            sb.append( arr[index] );
        }

        return sb.toString();
    }
}