class MedianFinder {
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());

        if (minHeap.size() < maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
