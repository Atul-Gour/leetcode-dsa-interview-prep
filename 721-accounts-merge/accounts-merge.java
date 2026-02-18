class Solution {
    static private String findParent(String curr, HashMap<String, String> parent) {
        if (curr.equals(parent.get(curr))) {
            return curr;
        }
        String newParent = findParent(parent.get(curr), parent);
        parent.put(curr, newParent);
        return newParent;
    }

    static void union(String a, String b,
            HashMap<String, String> parent,
            HashMap<String, Integer> rank) {

        String root1 = findParent(a, parent);
        String root2 = findParent(b, parent);

        if (root1.equals(root2))
            return;

        int r1 = rank.get(root1);
        int r2 = rank.get(root2);

        if (r1 < r2) {
            parent.put(root1, root2);
        } else if (r1 > r2) {
            parent.put(root2, root1);
        } else {
            parent.put(root2, root1);
            rank.put(root1, r1 + 1);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, String> name = new HashMap<>();
        HashMap<String, Integer> rank = new HashMap<>();
        HashMap<String, List<String>> emails = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (List<String> account : accounts) {
            String accName = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                parent.putIfAbsent(email, email);
                rank.putIfAbsent(email, 0);
                name.put(email, accName);
            }
        }

        for (List<String> account : accounts) {
            String firstEmail = account.get(1);

            for (int i = 2; i < account.size(); i++) {
                union(firstEmail, account.get(i), parent, rank);
            }
        }

        for (String email : parent.keySet()) {
            String root = findParent(email, parent);
            emails.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        for (String root : emails.keySet()) {
            List<String> list = emails.get(root);
            Collections.sort(list);

            List<String> temp = new ArrayList<>();
            temp.add(name.get(root));
            temp.addAll(list);

            ans.add(temp);
        }

        return ans;
    }
}