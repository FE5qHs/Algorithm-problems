class Solution {
public:
    int translateNum(int num) {
        string strNum = to_string(num);
        int res = 0;
        core(strNum, 0, res);
        return res;
    }

    void core(string strNum, int idx, int& res) {
        if (idx == strNum.length()) {
            ++res;
        } else {
            core(strNum, idx + 1, res);
            if (idx + 1 != strNum.length() && strNum.substr(idx, 2) <= "25"
                && strNum[idx] != '0') {
                core(strNum, idx + 2, res);
            }
        }
    }
};