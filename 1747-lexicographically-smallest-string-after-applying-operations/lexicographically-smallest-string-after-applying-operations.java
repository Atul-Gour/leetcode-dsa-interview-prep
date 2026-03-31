class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        String smallest = s;

        q.offer(s);
        visited.add(s);

        while (!q.isEmpty()) {
            String curr = q.poll();

            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }

            String opA = addOperation(curr, a);
            if (!visited.contains(opA)) {
                visited.add(opA);
                q.offer(opA);
            }

            String opB = rotateOperation(curr, b);
            if (!visited.contains(opB)) {
                visited.add(opB);
                q.offer(opB);
            }
        }

        return smallest;
    }

    private String addOperation(String s, int a) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < s.length(); i += 2) {
            int digit = (sb.charAt(i) - '0' + a) % 10;
            sb.setCharAt(i, (char)(digit + '0'));
        }
        return sb.toString();
    }

    private String rotateOperation(String s, int b) {
        int n = s.length();
        b %= n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}