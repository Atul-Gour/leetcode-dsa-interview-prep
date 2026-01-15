class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        int moves = 0;

        while (i < j) {
            if (arr[i] == arr[j]) {
                i++;
                j--;
                continue;
            }

            int k = j;
            while (k > i && arr[k] != arr[i]) {
                k--;
            }

            if (k == i) {
                swap(arr, i, i + 1);
                moves++;
            } 
            else {
                while (k < j) {
                    swap(arr, k, k + 1);
                    moves++;
                    k++;
                }
                i++;
                j--;
            }
        }

        return moves;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
