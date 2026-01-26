import java.util.*;

class AuctionSystem {

    // itemId -> max heap of [bidAmount, userId]
    private Map<Integer, PriorityQueue<int[]>> itemBids;

    // (userId,itemId) -> current bid
    private Map<Long, Integer> userBid;

    public AuctionSystem() {
        itemBids = new HashMap<>();
        userBid = new HashMap<>();
    }

    private long key(int userId, int itemId) {
        return (((long) userId) << 32) | itemId;
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        itemBids.putIfAbsent(itemId, new PriorityQueue<>(
            (a, b) -> {
                if (b[0] != a[0]) return b[0] - a[0]; // max bid
                return b[1] - a[1];                   // max userId
            }
        ));

        itemBids.get(itemId).offer(new int[]{bidAmount, userId});
        userBid.put(key(userId, itemId), bidAmount);
    }

    // update = add new bid (old becomes stale)
    public void updateBid(int userId, int itemId, int newAmount) {
        addBid(userId, itemId, newAmount);
    }

    // remove = mark invalid only
    public void removeBid(int userId, int itemId) {
        userBid.remove(key(userId, itemId));
    }

    // lazy cleanup happens here
    public int getHighestBidder(int itemId) {
        if (!itemBids.containsKey(itemId)) return -1;

        PriorityQueue<int[]> pq = itemBids.get(itemId);

        while (!pq.isEmpty()) {
            int[] top = pq.peek();
            int bid = top[0];
            int userId = top[1];

            long k = key(userId, itemId);

            // VALID bid
            if (userBid.containsKey(k) && userBid.get(k) == bid) {
                return userId;
            }

            // STALE bid → lazy delete
            pq.poll();
        }

        itemBids.remove(itemId);
        return -1;
    }
}
