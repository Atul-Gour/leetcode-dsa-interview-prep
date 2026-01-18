import java.util.*;

class AuctionSystem {
    private Map<Integer, Map<Integer, Integer>> currBidder;
    
    private Map<Integer, PriorityQueue<int[]>> item2bid;

    public AuctionSystem() {
        this.currBidder = new HashMap<>();
        this.item2bid = new HashMap<>();
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        currBidder.putIfAbsent(itemId, new HashMap<>());
        item2bid.putIfAbsent(itemId, new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return Integer.compare(b[0], a[0]); 
            return Integer.compare(b[1], a[1]); 
        }));
        
        currBidder.get(itemId).put(userId, bidAmount);
        item2bid.get(itemId).offer(new int[]{bidAmount, userId});
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        addBid(userId, itemId, newAmount);
    }
    
    public void removeBid(int userId, int itemId) {
        if (currBidder.containsKey(itemId)) {
            currBidder.get(itemId).remove(userId);
        }
    }
    
    public int getHighestBidder(int itemId) {
        if (!item2bid.containsKey(itemId) || currBidder.get(itemId).isEmpty()) {
            return -1;
        }

        PriorityQueue<int[]> pq = item2bid.get(itemId);
        Map<Integer, Integer> activeBids = currBidder.get(itemId);

        while (!pq.isEmpty()) {
            int[] top = pq.peek();
            int amount = top[0];
            int userId = top[1];

            if (activeBids.containsKey(userId) && activeBids.get(userId) == amount) {
                return userId;
            } else {
                pq.poll();
            }
        }

        return -1;
    }
}