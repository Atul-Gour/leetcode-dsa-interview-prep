import java.util.*;

class Solution {

    private HashMap<String, List<String>> buildPatternMap(Set<String> set, String beginWord) {
        HashMap<String, List<String>> patternMap = new HashMap<>();
        int L = beginWord.length();

        for (String word : set) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        for (int i = 0; i < L; i++) {
            String pattern = beginWord.substring(0, i) + "*" + beginWord.substring(i + 1);
            patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(beginWord);
        }

        return patternMap;
    }

    private void dfs(String currWord, String beginWord,
                     HashMap<String, HashSet<String>> parent,
                     List<String> path,
                     List<List<String>> ans) {

        path.add(currWord);

        if (currWord.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            path.remove(path.size() - 1);
            return;
        }

        for (String p : parent.get(currWord)) {
            dfs(p, beginWord, parent, path, ans);
        }

        path.remove(path.size() - 1);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();

        if (!set.contains(endWord)) return ans;

        HashMap<String, List<String>> patternMap = buildPatternMap(set, beginWord);

        HashMap<String, HashSet<String>> parent = new HashMap<>();
        for (String word : set) parent.put(word, new HashSet<>());
        parent.put(beginWord, new HashSet<>());

        ArrayDeque<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        HashMap<String, Integer> stepToReach = new HashMap<>();
        stepToReach.put(beginWord, 0);

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            boolean found = false;

            HashSet<String> usedThisLevel = new HashSet<>();

            while (size-- > 0) {

                String word = q.poll();
                int L = word.length();

                for (int i = 0; i < L; i++) {

                    String pattern = word.substring(0, i) + "*" + word.substring(i + 1);

                    for (String newWord : patternMap.getOrDefault(pattern, new ArrayList<>())) {

                        if (!set.contains(newWord) ) continue;

                        if (!stepToReach.containsKey(newWord)) {
                            stepToReach.put(newWord, steps + 1);
                            q.offer(newWord);
                            usedThisLevel.add(newWord);
                        }

                        if (stepToReach.get(newWord) == steps + 1) {
                            parent.get(newWord).add(word);
                        }

                        if (newWord.equals(endWord)) {
                            found = true;
                        }
                    }
                }
            }

            for (String w : usedThisLevel) {
                set.remove(w);
            }

            steps++;

            if (found) break;
        }

        dfs(endWord, beginWord, parent, new ArrayList<>(), ans);

        return ans;
    }
}