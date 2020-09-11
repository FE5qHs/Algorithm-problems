// solution1
// time complexity O(n2)
// space complexity O(1)
class Solution {
public:
    char firstUniqChar(string s) {
        if (s.length() == 1) return s[0];
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < s.length(); ++j) {
                if (i != j && s[i] == s[j]) break;
                if (j == s.length() - 1) return s[i];
            }
        }
        return ' ';
    }
};

// solution1
// time complexity O(n)
// space complexity O(n)
class Solution {
public:
    char firstUniqChar(string s) {
        unordered_map<char, int> dict;
        int order = 0;
        for (char c : s) {
            if (dict.find(c) == dict.end()) {
                ++order;
                dict[c] = order;
            } else {
                dict[c] = 0;
            }
        }
        char res = ' ';
        int minOrder = 50001;
        for (auto it : dict) {
            if (it.second != 0 && it.second < minOrder) {
                res = it.first;
                minOrder = it.second;
            }
        }
        return res;
    }
};