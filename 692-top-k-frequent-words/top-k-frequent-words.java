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
        PriorityQueue<Node> pq = new PriorityQueue<>((a , b) -> {
            if( a.freq != b.freq )
                return Integer.compare( a.freq , b.freq );
            else
                return (b.s).compareTo(a.s);
        });

        List<String> ans = new ArrayList<>();

        for( String word : words ){
            map.put( word , map.getOrDefault( word , 0 ) + 1 );
        }

        for( String word : map.keySet() ){
            pq.offer( new Node( word , map.get(word) ) );

            if( pq.size() > k ){
                pq.poll();
            }
        }

        for( int i = 0 ; i < k ; i++ ){
            ans.add( pq.poll().s );
        }

        Collections.reverse(ans);
        return ans;

    }
}