import java.util.*;

class Solution {
    public String frequencySort(String s) {
        // Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Sort the characters based on their frequency in descending order
        List<Character> sortedChars = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(sortedChars, (a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        
        // Build the sorted string by repeating each character based on its frequency
        StringBuilder result = new StringBuilder();
        for (char c : sortedChars) {
            int frequency = frequencyMap.get(c);
            result.append(String.valueOf(c).repeat(frequency));
        }
        
        return result.toString();
    }
}
