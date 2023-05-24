import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> cache = new HashMap<>();
        return compute(expression, cache);
    }
    
    private List<Integer> compute(String expression, Map<String, List<Integer>> cache) {
        if (cache.containsKey(expression)) {
            return cache.get(expression);
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);
                
                List<Integer> leftResults = compute(leftPart, cache);
                List<Integer> rightResults = compute(rightPart, cache);
                
                for (int left : leftResults) {
                   
