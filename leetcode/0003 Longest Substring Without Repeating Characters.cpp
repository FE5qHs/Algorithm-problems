class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int max = 0;
        unordered_set<char> set;
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (set.end() == set.find(s[j])) {
                set.insert(s[j]);
                if (j - i + 1 > max) max = j - i + 1;
            } else {
                while (s[i] != s[j]) {
                    set.erase(s[i]);
                    ++i;
                }
                ++i;
            }
        }
        return max;
    }
};