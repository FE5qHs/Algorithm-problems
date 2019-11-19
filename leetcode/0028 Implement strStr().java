class Solution {
    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle || needle.isEmpty()) return 0;
        int res = -1;
        for (int i = 0; i < haystack.length(); ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = i, k = 0;
                while (j < haystack.length() && k < needle.length()) {
                    if (haystack.charAt(j) != needle.charAt(k)) break;
                    ++j;
                    ++k;
                }
                if (k == needle.length()) {
                    res = j - needle.length();
                    break;
                }
            }
        }
        return res;
    }
}