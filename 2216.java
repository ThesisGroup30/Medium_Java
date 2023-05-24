class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        for (int i = 0; i < n - 1; i += 2) {
            if (nums[i] == nums[i + 1]) {
                count++;
            }
        }
        
        return count;
    }
}
