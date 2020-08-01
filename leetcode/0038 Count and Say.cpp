class Solution {
public:
    string countAndSay(int n) {
        string res = "1";
        for (int i = 1; i < n; ++i) {
            char pre = '\0';
            int count = 0;
            string newStr = "";
            for (int j = 0; j < res.length(); ++j) {
                if (pre == '\0') {
                    pre = res[j];
                    ++count;
                } else if (pre == res[j]) {
                    ++count;
                } else {
                    newStr = newStr + to_string(count);
                    newStr.push_back(pre);
                    pre = res[j];
                    count = 1;
                }
            }
            if (count != 0) {
                newStr = newStr + to_string(count);
                newStr.push_back(pre);
            }
            res = newStr;
        }
        return res;
    }
};