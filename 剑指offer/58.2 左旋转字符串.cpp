// solution1
// time complexity O(n)
// space complexity O(n)
class Solution {
public:
    string reverseLeftWords(string s, int n) {
        string res = "";
        for (int i = n; i < s.length(); ++i) {
            res += s[i];
        }
        for (int i = 0; i < n; ++i) {
            res += s[i];
        }
        return res;
    }
};