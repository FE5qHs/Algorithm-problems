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

// solution2
// time complexity O(n)
// space complexity O(1)
class Solution {
public:
    string reverseLeftWords(string s, int n) {
        swap(s, 0, s.length() - 1);
        swap(s, 0, s.length() - 1 - n);
        swap(s, s.length() - n, s.length() - 1);
        return s;
    }
    
    void swap(string& s, int left, int right) {
        for (; left < right; ++left, --right) {
            char temp = ' ';
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
};