class Solution {
    public boolean lemonadeChange(int[] bills) {
        int change5 = 0;
        int change10 = 0;

        for(int i = 0 ; i < bills.length; i++ ){
            if( bills[i] == 5 ){
                change5++;
            }
            else if( bills[i] == 10 ){

                if(change5 >= 1){
                    change5--;
                    change10++;
                }
                else return false;

            }
            else if( bills[i] == 20 ){
                if( change10 >= 1 && change5 >= 1 ){
                    change5--;
                    change10--;
                }
                else if( change5 >= 3 ){
                    change5 -= 3;
                }
                else return false;
            }

        }
        return true;
    }
}