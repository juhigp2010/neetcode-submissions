class Solution {
    public int trap(int[] arr) {

         if (arr == null || arr.length < 3)
            return 0;
        int left = 0;
        int right = arr.length - 1;
        int leftMax = arr[left];
        int rightMax = arr[right];
        int res = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, arr[left]);
                res = res + leftMax - arr[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, arr[right]);
                res = res + rightMax - arr[right];
            }

        }
        return res;
    }
}
