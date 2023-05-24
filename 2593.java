class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n];
        long score = 0;
        
        for (int i = 0; i < n; i++) {
            if (marked[i]) {
                continue;
            }
            
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (!marked[j] && nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            
            marked[minIndex] = true;
            score += nums[minIndex];
            
            if (minIndex - 1 >= 0) {
                marked[minIndex - 1] = true;
            }
            
            if (minIndex + 1 < n) {
                marked[minIndex + 1] = true;
            }
        }
        
        return score;
    }
}
