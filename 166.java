import java.util.HashMap;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Handle the sign of the result
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            result.append("-");
        }

        // Convert numerator and denominator to absolute values
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Calculate quotient and remainder
        long quotient = num / denom;
        long remainder = num % denom;
        result.append(quotient);

        if (remainder == 0) {
            return result.toString();
        }

        // Append decimal point
        result.append(".");

        // HashMap to store remainder and its corresponding index
        HashMap<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            // Multiply remainder by 10
            remainder *= 10;

            // Calculate new quotient and remainder
            quotient = remainder / denom;
            remainder = remainder % denom;

            if (remainderMap.containsKey(remainder)) {
                // Repeating fractional part found
                int index = remainderMap.get(remainder);
                result.insert(index, "(");
                result.append(")");
                return result.toString();
            } else {
                // Append new quotient to the result string
                result.append(quotient);
                // Store remainder and its index
                remainderMap.put(remainder, result.length() - 1);
            }
        }

        return result.toString();
    }
}
