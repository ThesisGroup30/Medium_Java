import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // Store the count of each character
        boolean[] visited = new boolean[26]; // Keep track of characters visited
        Stack<Character> stack = new Stack<>(); // Use stack to build the result string

        // Count the occurrences of each character
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Process each character in the string
        for (char ch : s.toCharArray()) {
            count[ch - 'a']--; // Decrement the count of the current character

            if (visited[ch - 'a']) {
                continue; // Skip if the character is already visited
            }

            // Remove characters from the stack that are larger than the current character
            while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        // Build the result string from the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
