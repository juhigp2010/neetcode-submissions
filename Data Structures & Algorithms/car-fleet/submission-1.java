class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // 1. Combine position and speed to keep them together during sorting
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // 2. Sort by position descending (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int count = 1;
        // 3. Use double for precise time calculation
        double leadTime = (target - cars[0][0]) / cars[0][1];

        for (int i = 1; i < n; i++) {
            double currTime = (target - cars[i][0]) / cars[i][1];

            // 4. If current car's time is GREATER than leadTime, it can't catch up
            if (currTime > leadTime) {
                count++;
                leadTime = currTime; // This car becomes the new lead for cars behind it
            }
            // If currTime <= leadTime, it catches up and joins the fleet (do nothing)
        }

        return count;
    }
}
