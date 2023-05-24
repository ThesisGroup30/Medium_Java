import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort the people in ascending order
        int left = 0; // Pointer to the lightest person
        int right = people.length - 1; // Pointer to the heaviest person
        int boats = 0; // Count of boats needed
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                // If the sum of the lightest person and the heaviest person is within the limit,
                // they can be placed in the same boat
                left++;
                right--;
            } else {
                // Otherwise, only the heaviest person can be placed in a boat
                right--;
            }
            boats++; // Increment the count of boats used
        }
        
        return boats;
    }
}
