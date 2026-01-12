class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isEnd;
}

class Solution {

    void insert(String word, TrieNode root) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.child[idx] == null)
                cur.child[idx] = new TrieNode();
            cur = cur.child[idx];
        }
        cur.isEnd = true;
    }

    String getLCP(TrieNode root) {
        StringBuilder sb = new StringBuilder();
        TrieNode cur = root;

        while (true) {
            int count = 0;
            int next = -1;

            for (int i = 0; i < 26; i++) {
                if (cur.child[i] != null) {
                    count++;
                    next = i;
                }
            }

            if (count != 1 || cur.isEnd)
                break;

            sb.append((char) (next + 'a'));
            cur = cur.child[next];
        }

        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        TrieNode root = new TrieNode();

        for (String s : strs) {
            insert(s, root);
        }

        return getLCP(root);
    }
}
