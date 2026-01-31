class Solution {

    private static HashMap<String, ArrayList<String>> buildOneDiffMap(List<String> words) {

        HashMap<String, ArrayList<String>> patternMap = new HashMap<>();
        HashMap<String, ArrayList<String>> result = new HashMap<>();

        // initialize result map
        for (String w : words) {
            result.put(w, new ArrayList<>());
        }

        // build pattern map
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {

                String pattern =
                        word.substring(0, i) + "*" + word.substring(i + 1);

                patternMap
                        .computeIfAbsent(pattern, k -> new ArrayList<>())
                        .add(word);
            }
        }

        // build final adjacency list
        for (ArrayList<String> group : patternMap.values()) {
            if (group.size() > 1) {
                for (String a : group) {
                    for (String b : group) {
                        if (!a.equals(b)) {
                            result.get(a).add(b);
                        }
                    }
                }
            }
        }

        return result;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);

        HashMap<String, ArrayList<String>> map = buildOneDiffMap(wordList);
        if( !map.containsKey(endWord)) return 0;

        HashSet<String> pathVisited = new HashSet<>();
        pathVisited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        int cost = 1;
        q.offer( beginWord );

        while(!q.isEmpty()){
            int size = q.size();
            for( int i = 0 ; i < size ; i++){
                String curr = q.poll();
                for(String neigh : map.get(curr)){
                    if( !visited.contains(neigh) ){
                        if(neigh.equals(endWord))return cost + 1;

                        q.offer(neigh);
                    }
                }
                visited.add(curr);
            }
            cost++;
        }

        return 0;
    }
}