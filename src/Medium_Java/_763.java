package Medium_Java;

import java.util.ArrayList;
import java.util.List;

public class _763 {
	public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];

        // Find the last occurrence index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int start = 0;
        int end = 0;

        // Iterate over the string to determine the partitions
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            if (i == end) {
                partitions.add(end - start + 1);
                start = i + 1;
            }
        }

        return partitions;
    }
}
