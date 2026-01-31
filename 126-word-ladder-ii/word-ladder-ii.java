import java.util.*;

class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return ans;

        Map<String, List<String>> parent = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();

        for (String w : dict) parent.put(w, new ArrayList<>());
        parent.put(beginWord, new ArrayList<>());

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        dist.put(beginWord, 0);

        int wordLen = beginWord.length();

        while (!q.isEmpty()) {
            String curr = q.poll();
            int d = dist.get(curr);

            char[] arr = curr.toCharArray();
            for (int i = 0; i < wordLen; i++) {
                char original = arr[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue;
                    arr[i] = c;

                    String next = new String(arr);
                    if (!dict.contains(next)) continue;

                    if (!dist.containsKey(next)) {
                        dist.put(next, d + 1);
                        parent.get(next).add(curr);
                        q.offer(next);
                    } else if (dist.get(next) == d + 1) {
                        parent.get(next).add(curr);
                    }
                }
                arr[i] = original;
            }
        }

        if (!dist.containsKey(endWord)) return ans;

        LinkedList<String> path = new LinkedList<>();
        dfs(endWord, beginWord, parent, path, ans);

        return ans;
    }

    private void dfs(
            String curr,
            String begin,
            Map<String, List<String>> parent,
            LinkedList<String> path,
            List<List<String>> ans) {

        path.addFirst(curr);

        if (curr.equals(begin)) {
            ans.add(new ArrayList<>(path));
        } else {
            for (String p : parent.get(curr)) {
                dfs(p, begin, parent, path, ans);
            }
        }

        path.removeFirst();
    }
}
