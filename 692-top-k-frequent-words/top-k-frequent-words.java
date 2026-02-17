class Node {
    String s;
    int freq;

    Node( String s , int freq ){
        this.s = s;
        this.freq = freq;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String , Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for( String word : words ){
            map.put( word , map.getOrDefault( word , 0 ) + 1 );
        }

        Node[] arr = new Node[map.size()];

        int i = 0;
        for( String word : map.keySet() ){
            arr[i++] = new Node( word , map.get(word) );
        }

        Arrays.sort( arr , (a , b) -> {
            if( a.freq != b.freq )
                return Integer.compare( b.freq , a.freq );
            else
                return (a.s).compareTo(b.s);
        } );

        for( i = 0 ; i < k ; i++ ){
            ans.add( arr[i].s );
        }

        return ans;

    }
}