class Solution {
    public int mostBooked(int n, int[][] meetings) {

        // Count of meetings per room
        int[] count = new int[n];

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Free rooms: smallest index first
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();

        // Busy rooms: earliest end time first, then room index
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> a[0] != b[0]
                    ? Long.compare(a[0], b[0])
                    : Long.compare(a[1], b[1])
        );

        // Initially all rooms are free
        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            // Free rooms that have finished before this meeting starts
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                // Assign available room with smallest index
                int room = freeRooms.poll();
                count[room]++;
                busyRooms.offer(new long[]{end, room});
            } else {
                // Delay meeting in the room that ends earliest
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];

                count[room]++;
                busyRooms.offer(new long[]{newEnd, room});
            }
        }

        // Find room with maximum meetings
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}
