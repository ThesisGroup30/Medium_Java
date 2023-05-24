class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int idx = 0;
        StringBuilder cur = new StringBuilder();
        while (idx < s.length()) {
            char ch = s.charAt(idx);
            if (Character.isDigit(ch)) {
                int num = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    num = num * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(num);
            } else if (ch == '[') {
                stringStack.push(cur);
                cur = new StringBuilder();
                idx++;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    cur.append(tmp);
                }
                idx++;
            } else {
                cur.append(ch);
                idx++;
            }
        }
        return cur.toString();
    }
}
