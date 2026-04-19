class Solution {
    static class DSU {
        Map<Integer, Integer> parent = new HashMap<>();

        int find(int x) {
            if (!parent.containsKey(x)) parent.put(x, x);
            if (parent.get(x) != x)
                parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa != pb) parent.put(pa, pb);
        }
    }

    public int removeStones(int[][] stones) {
        DSU dsu = new DSU();
        int OFFSET = 10001;

        for (int[] stone : stones) {
            int x = stone[0];
            int y = stone[1] + OFFSET;
            dsu.union(x, y);
        }

        Set<Integer> uniqueParents = new HashSet<>();

        for (int[] stone : stones) {
            uniqueParents.add(dsu.find(stone[0]));
        }

        return stones.length - uniqueParents.size();
    }
}