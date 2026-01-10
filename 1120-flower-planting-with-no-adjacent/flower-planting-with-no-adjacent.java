class Solution {

    public int[] gardenNoAdj(int n, int[][] paths) {

        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();

        for(int arr[] : paths){
            map.computeIfAbsent(arr[0] , f -> new ArrayList<>()).add(arr[1]);
            map.computeIfAbsent(arr[1] , f -> new ArrayList<>()).add(arr[0]);
        }

        int[] ans = new int[n];

        for(int i = 0 ; i < n ; i++){
            boolean color[] = new boolean[5];

            for (int ele : map.getOrDefault(i + 1, new ArrayList<>())) {
                color[ans[ele - 1]] = true;
            }

            for(int j = 1 ; j <= 4 ; j++){
                if(!color[j]){
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;
    }
}