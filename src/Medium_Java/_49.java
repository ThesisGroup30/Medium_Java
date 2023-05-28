package Medium_Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _49 {
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // Iterate over each string in strs
        for (String str : strs) {
            // Sort the characters of the string to get its sorted representation
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            // Check if the sorted representation exists in the map
            // If not, create a new list for the anagram group
            // If yes, add the string to the existing anagram group
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        // Return the values (anagram groups) of the map
        return new ArrayList<>(map.values());
    }
}
