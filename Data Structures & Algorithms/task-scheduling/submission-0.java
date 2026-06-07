class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequencies of each task
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        // Step 2: Sort frequencies to easily find the max
        Arrays.sort(frequencies);
        
        // The highest frequency will be at the last index
        int fMax = frequencies[25];
        
        // Step 3: Count how many tasks have this same max frequency
        int countMax = 0;
        for (int i = 25; i >= 0; i--) {
            if (frequencies[i] == fMax) {
                countMax++;
            } else {
                break; // Since it's sorted, we can stop early
            }
        }

        // Step 4: Calculate minimum cycles using the formula
        int minimumCycles = (fMax - 1) * (n + 1) + countMax;

        // Step 5: Return the maximum of calculated slots or total tasks
        return Math.max(minimumCycles, tasks.length);
    }
}
