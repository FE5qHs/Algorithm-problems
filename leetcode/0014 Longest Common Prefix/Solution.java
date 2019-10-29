class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (0 == strs.length) {
            return "";
        } else if (1 == strs.length) {
            return strs[0];
        }
        StringBuilder result = new StringBuilder();
        int shortest = strs[0].length();
        for (int i = 1; i < strs.length; ++i) {
            if (strs[i].length() < shortest) {
                shortest = strs[i].length();
            }
        }
        for (int i = 0; i < shortest; ++i) {
            for (int j = 0; j < strs.length; ++j) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }
}