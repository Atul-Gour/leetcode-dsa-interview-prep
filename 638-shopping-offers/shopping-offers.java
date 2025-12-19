class Solution {
    static int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs , Map<List<Integer>, Integer> memo){

        List<Integer> key = new ArrayList<>(needs);
        if (memo.containsKey(needs)) return memo.get(needs);


        int n = needs.size();

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += needs.get(i) * price.get(i);
        }

        for(List<Integer> curr : special){

            boolean canUse = true;
            for(int i = 0 ; i < n ; i++){
                if(curr.get(i) > needs.get(i)){
                    canUse = false;
                    break;
                }
            }
            if(!canUse) continue;

            for(int i = 0 ; i < n ; i++){
                needs.set(i, needs.get(i) - curr.get(i));
            }

            int currAns = curr.get(n) + shopping(price , special , needs ,memo);
            ans = Math.min(ans , currAns);

            for(int i = 0 ; i < n ; i++){
                needs.set(i, needs.get(i) + curr.get(i));
            }
        }
        memo.put(key, ans);
        return ans;
    }
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        for( int i = 0 ;i < n ; i++){
            List<Integer> curr = new ArrayList<>();
            for(int j = 0; j< n ; j++){
                if(j==i){
                    curr.add(1);
                    continue;
                }
                curr.add(0);
            }
            curr.add(price.get(i));
            special.add(curr);
        }

        return shopping(price , special , needs , new HashMap<>());
    }
}