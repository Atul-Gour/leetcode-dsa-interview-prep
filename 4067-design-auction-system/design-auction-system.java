import java.util.*;

class AuctionSystem {

    HashMap<Integer, TreeMap<Integer, TreeSet<Integer>>> map;
    HashMap<Long, Integer> userBid;

    public AuctionSystem() {
        map = new HashMap<>();
        userBid = new HashMap<>();
    }

    private long key(int userId, int itemId) {
        return (((long) userId) << 32) | itemId;
    }

    // ADD BID (no cleanup here)
    public void addBid(int userId, int itemId, int bidAmount) {
        long k = key(userId, itemId);

        map.computeIfAbsent(itemId,
                x -> new TreeMap<>(Collections.reverseOrder()))
           .computeIfAbsent(bidAmount,
                x -> new TreeSet<>(Collections.reverseOrder()))
           .add(userId);

        userBid.put(k, bidAmount); // source of truth
    }

    // UPDATE = just add new (old becomes stale)
    public void updateBid(int userId, int itemId, int newAmount) {
        addBid(userId, itemId, newAmount);
    }

    // REMOVE = mark inactive ONLY
    public void removeBid(int userId, int itemId) {
        userBid.remove(key(userId, itemId));
    }

    // LAZY CLEANUP happens here
    public int getHighestBidder(int itemId) {
        if (!map.containsKey(itemId)) return -1;

        TreeMap<Integer, TreeSet<Integer>> bids = map.get(itemId);

        while (!bids.isEmpty()) {
            Map.Entry<Integer, TreeSet<Integer>> entry = bids.firstEntry();
            int amount = entry.getKey();
            TreeSet<Integer> users = entry.getValue();

            while (!users.isEmpty()) {
                int userId = users.first();
                long k = key(userId, itemId);

                // VALID bid
                if (userBid.containsKey(k) && userBid.get(k) == amount) {
                    return userId;
                }

                // STALE → lazy delete
                users.pollFirst();
            }

            // no users left for this amount
            bids.pollFirstEntry();
        }

        map.remove(itemId);
        return -1;
    }
}
