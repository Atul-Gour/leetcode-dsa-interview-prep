class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        if(n < 3)return false;

        int pre[] = new int[n];

        HashMap<Integer , ArrayList<Integer>> map1 = new HashMap<>(); 
        HashMap<Integer , ArrayList<Integer>> map2 = new HashMap<>();

        pre[0] = arr[0];
        map1.computeIfAbsent(pre[0] , f -> new ArrayList<>()).add(0);

        for(int i = 1 ; i < n ; i++){
            pre[i] = pre[i-1] + arr[i];
            map1.computeIfAbsent(pre[i] , f -> new ArrayList<>()).add(i);
        }

        map2.computeIfAbsent(arr[n-1] , f -> new ArrayList<>()).add(n-1);

        int sum = arr[n-1];

        for(int i = n-2 ; i>=0 ; i--){
            sum += arr[i];
            map2.computeIfAbsent(sum , f -> new ArrayList<>()).add(i);
        }

        for(int key : map1.keySet()){
            if(!map2.containsKey(key)) continue;
            ArrayList<Integer> iList = map1.get(key);
            ArrayList<Integer> jList = map2.get(key);

            for(int i : iList){
                for(int j : jList){
                    if(i >= j-1 || j < 2 || i >= n-2)continue;
                    if(pre[j-1] - pre[i] == key)return true;
                }
            }
        }
        return false;
    }
}