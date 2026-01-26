class Solution {
    private int[] makeMaxCandyPossible( int[] ratings  ){
        int n = ratings.length;
        int arr[] = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i : ratings){
            set.add( i );
        }
        int candy = 1;
        for( int i : set ){
            map.put( i , candy++ );
        }

        for( int i = 0 ; i < n ; i++){
            arr[i] = map.get(ratings[i]);
        }
        if( ratings[1] == ratings[0])arr[0] = 1;
        if( ratings[n-1] == ratings[n-2])arr[n-1] = 1;

        for(int i = 1 ; i < n-1 ; i++){
            if( ratings[i - 1] == ratings[i] && ratings[i + 1] == ratings[i] ) arr[i] = 1;
        }
        return arr;
    } 
    private int getMax( int[] arr , int index ){
        int n = arr.length;
        if( index == 0 ) return 1;
        if( index == n-1)return n-2;

        if( arr[index - 1] > arr[index + 1] )
            return index - 1;
        else return index + 1;

    }
    private int getMin( int[] arr , int index ){
        int n = arr.length;
        if( index == 0 ) return 1;
        if( index == n-1)return n-2;

        if( arr[index - 1] < arr[index + 1] )
            return index - 1;
        else return index + 1;
    }
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n == 1) return 1;
        int ans[] = makeMaxCandyPossible( ratings );
        
        boolean changed = false;

        do{
            changed = false;

            // for( int i : ans ){
            //     System.out.print(i + " ");
            // }
            // System.out.println();

            for(int i = 0 ; i < n ; i++ ){
                int min = getMin(ans , i);
                int max = getMax(ans , i);
                int curr = ans[i];

                if( ans[min] >= ans[i]){//sabse chota
                    ans[i] = 1;
                    // System.out.print( i + " sabse chota");
                }
                else if( ans[max] < ans[i] ){//sabse bada
                    // System.out.print( i + " sabse bada");
                    if( ratings[max] == ratings[i] && ans[max] > ans[min] ){
                        ans[i] = ans[max];
                    }else
                        ans[i] = ans[max] + 1;
                }
                    
                else if( (ans[max] >= ans[i]) && ( ans[min] < ans[i] ) ){//bich ka
                    // System.out.print( i + " bich ka");
                    if(  ratings[min] == ratings[i] ) ans[i] = ans[min];
                    else if( ans[max] == ans[i]) ans[i] = ans[min] + 1;
                    else if( ans[min] + 1 < ans[max] ) ans[i] = ans[min] + 1;
                }

                if( ans[i] != curr ) changed = true;
                // System.out.println(" from " + curr +" to " + ans[i] );
            }
        }
        while( changed == true );

        int candiesNeeded = 0;
        for( int i : ans){
            candiesNeeded += i;
        }
        

        return candiesNeeded;
    }
}