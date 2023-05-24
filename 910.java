class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array in ascending order
        int n = nums.length;
        int min_value = nums[0];
        int max_value = nums[n - 1];
        int result = max_value - min_value;

        for (int i = 0; i < n - 1; i++) {
            // Calculate the possible maximum and minimum values after modifying nums[i]
            int possible_max = Math.max(nums[i] + k, max_value - k);
            int possible_min = Math.min(nums[i + 1] - k, min_value + k);
            result = Math.min(result, possible_max - possible_min);
        }

        return result;
    }
}
