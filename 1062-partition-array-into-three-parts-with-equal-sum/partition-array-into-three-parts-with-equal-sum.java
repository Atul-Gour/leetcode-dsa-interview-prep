class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        if(n < 3)return false;

        int pre[] = new int[n];

        pre[0] = arr[0];

        for(int i = 1 ; i < n ; i++){
            pre[i] = pre[i-1] + arr[i];
        }

        for(int i = 1 ; i < n-1 ; i++){
            for(int j = i ; j < n-1 ; j++){
                long first = pre[i-1];
                long second = pre[j] - pre[i-1];
                long third = pre[n-1] - pre[j];
                if(first == second && second == third) return true;
            }
        }
        return false;
    }
}