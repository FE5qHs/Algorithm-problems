class Solution {
public:
    string reverseWords(string s) {
        int i = 0, j = s.length() - 1;
        
        while (s[i] == ' ') ++i;
        while (s[j] == ' ') --j;
        s.erase(j + 1, s.length() - 1 - j);
        s.erase(0, i);

        char temp = ' ';
        i = 0;
        j = s.length() - 1;
        for (; i < j; ++i, --j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        
        for (int k = 0; k < s.length();) {
            int l = k;
            while (s[k] != ' ' && k < s.length()) ++k;
            int m = k;
            --m;
            for (; l < m; ++l, --m) {
                temp = s[l];
                s[l] = s[m];
                s[m] = temp;
            }
            
            int z = k;
            while (s[k] == ' ' && k < s.length()) ++k;
            s.erase(z, k - z - 1);
            k = z + 1;
        }
        
        return s;
    }
};