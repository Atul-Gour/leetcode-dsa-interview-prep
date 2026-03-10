class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if (n == 1)return 0;
        char[] arr2 = s.toCharArray();
        int arr[] = new int[n];

        int min = Integer.MAX_VALUE;
        int index = -1;

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < n; i++) {
            arr[i] = arr2[i] - 'a';
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
            if (arr[i] >= max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        //sorted
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                sorted = false;
                break;
            }
        }
        if(sorted)return 0;
        // end sorted
        
        if (n == 2) {
            if (arr[0] <= arr[1])
                return 0;
            else
                return -1;
        }

        if (index == n - 1 && maxIndex == 0)return 3;
        if( index == 0 || maxIndex == n-1 )return 1;
        return 2;

    }
}