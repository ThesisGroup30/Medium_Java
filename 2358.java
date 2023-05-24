import java.util.Arrays;

class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades); // Sort the grades in ascending order
        int groups = 0;
        
        int sum = 0;
        int count = 0;
        for (int grade : grades) {
            sum += grade;
            count++;
            
            if (sum > count * (count + 1) / 2) {
                groups++;
                sum = grade;
                count = 1;
            }
        }
        
        return groups + 1; // Add 1 to account for the last group
    }
}
