class Solution {
    public int nextGreaterElement(int n) {

        int digits = (int)Math.log10(n) + 1;
        String s = String.valueOf( n );

        int[] arr = new int[ digits ];

        for( int i = 0 ; i < digits ; i++ ) arr[i] = s.charAt(i) - '0';
        
        int index = -1;

        for( int i = digits - 1 ; i > 0 ; i-- ){
            if( arr[i-1] < arr[i] ){
                index = i-1;
                break;
            }
        }

        if( index == -1 ) return -1;

        for( int i = digits-1 ; i > index ; i-- ){
            if( arr[i] > arr[index] ){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }

        for( int i = index + 1, j = digits-1 ; i < j ; i++ , j-- ){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        long num = 0;

        for (int d : arr) {
            num = num * 10 + d;
        }

        if( num > Integer.MAX_VALUE ) return -1;
        return (int)num ;

    }
}