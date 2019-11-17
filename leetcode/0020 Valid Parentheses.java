class Solution {
    public boolean isValid(String s) {
        boolean res = true;
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '[' == c || '{' == c) stk.push(c);
            else if (')' == c) {
                if (stk.empty() || stk.pop() != '(') {
                    res = false;
                    break;
                }
            } else if (']' == c) {
                if (stk.empty() || stk.pop() != '[') {
                    res = false;
                    break;
                }
            } else if ('}' == c) {
                if (stk.empty() || stk.pop() != '{') {
                    res = false;
                    break;
                }
            }
        }
        if (!stk.empty()) res = false;
        return res;
    }
}