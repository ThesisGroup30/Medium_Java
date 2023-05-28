package Medium_Java;

import java.util.HashMap;
import java.util.Map;

public class _2606 {
	public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> valMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            valMap.put(chars.charAt(i), vals[i]);
        }
        
        int maxCost = 0;
        int left = 0;
        int right = 0;
        int currCost = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            if (valMap.containsKey(c)) {
                currCost += valMap.get(c);
            } else {
                currCost += c - 'a' + 1;
            }
            
            while (left <= right && (currCost < 0 || (!valMap.containsKey(s.charAt(left)) && valMap.containsKey(c)) )) {
                if (valMap.containsKey(s.charAt(left))) {
                    currCost -= valMap.get(s.charAt(left));
                } else {
                    currCost -= s.charAt(left) - 'a' + 1;
                }
                left++;
            }
            
            if (currCost > maxCost) {
                maxCost = currCost;
            }
            
            right++;
        }
        
        return maxCost;
    }
}
