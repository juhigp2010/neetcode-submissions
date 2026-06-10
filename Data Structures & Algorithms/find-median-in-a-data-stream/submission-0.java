class MedianFinder {
private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    public MedianFinder() {
      maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
      // Step 1: Add to maxHeap
        maxHeap.offer(num);
        
        // Step 2: Balancing step - make sure every element in maxHeap is <= elements in minHeap
        minHeap.offer(maxHeap.poll());
        
        // Step 3: Maintain size property (maxHeap can have at most 1 more element than minHeap)
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // If total elements are odd, maxHeap will have the extra middle element
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        // If total elements are even, average the tops of both heaps
        // Note the 2.0 to force double division instead of integer division
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
