class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> countMap.get(a) - countMap.get(b)
        );

        for (int n : countMap.keySet()) {
            heap.add(n);
            // If the heap exceeds size k, remove the element with the lowest frequency
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 3. Build the result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        
        return result;
    }
}
