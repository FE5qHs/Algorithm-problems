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