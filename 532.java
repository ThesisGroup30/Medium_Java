import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0)
            return 0;
        
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;
        
        // Build frequency map
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Count unique k-diff pairs
        for (int num : frequencyMap.keySet()) {
            if (k == 0) {
                // Count pairs with the same number occurring at least twice
                if (frequencyMap.get(num) >= 2)
                    count++;
            } else {
                // Check if there is a complement number forming a k-diff pair
                if (frequencyMap.containsKey(num + k))
                    count++;
            }
        }
        
        return count;
    }
}
