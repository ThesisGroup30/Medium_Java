import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] minValues = new int[n];
        minValues[0] = nums[0];
        
        // Calculate the minimum value for each position
        for (int i = 1; i < n; i++) {
            minValues[i] = Math.min(minValues[i - 1], nums[i]);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        // Traverse the array from the end
        for (int j = n - 1; j >= 0; j--) {
            // Check if nums[j] is greater than the minimum value at previous positions
            if (nums[j] > minValues[j]) {
                // Find the maximum value that is less than nums[j]
                while (!stack.isEmpty() && stack.peek() <= minValues[j]) {
                    stack.pop();
                }
                
                // Check if the top of the stack is less than nums[j]
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                
                // Push nums[j] to the stack
                stack.push(nums[j]);
            }
        }
        
        return false;
    }
}
