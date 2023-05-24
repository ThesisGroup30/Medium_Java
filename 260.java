class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: Compute XOR of all elements in nums
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        // Step 2: Find the rightmost set bit in xor
        int mask = 1;
        while ((mask & xor) == 0) {
            mask <<= 1;
        }
        
        // Step 3: Partition the numbers into two groups based on the rightmost set bit
        int x = 0, y = 0;
        for (int num : nums) {
            if ((mask & num) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        
        // Step 4: Return the two unique numbers as an array
        return new int[]{x, y};
    }
}
