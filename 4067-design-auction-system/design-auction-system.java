import java.util.*;

class AuctionSystem {

    // itemId -> max heap of bids
    private Map<Integer, PriorityQueue<Node>> itemBids;

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
                if (b.bid != a.bid) return b.bid - a.bid;   // higher bid first
                return b.userId - a.userId;                 // tie-breaker
            }
        ));

        itemBids.get(itemId).offer(new Node(bidAmount, userId));
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

        PriorityQueue<Node> pq = itemBids.get(itemId);

        while (!pq.isEmpty()) {
            Node top = pq.peek();
            long k = key(top.userId, itemId);

            // VALID bid
            if (userBid.containsKey(k) && userBid.get(k) == top.bid) {
                return top.userId;
            }

            // STALE bid → lazy delete
            pq.poll();
        }

        // no valid bids left
        itemBids.remove(itemId);
        return -1;
    }
}

class Node {
    int bid;
    int userId;

    Node(int bid, int userId) {
        this.bid = bid;
        this.userId = userId;
    }
}
