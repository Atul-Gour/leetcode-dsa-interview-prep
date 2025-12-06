class MedianFinder {

    private PriorityQueue<Integer> maxHeap; // left side
    private PriorityQueue<Integer> minHeap; // right side

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        minHeap = new PriorityQueue<>(); // min-heap
    }

    public void addNum(int num) {
        // Step 1: Add to maxHeap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Step 2: Balance heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
