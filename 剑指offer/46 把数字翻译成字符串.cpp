// solution1 backtrack
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

// solution2 dp
class Solution {
public:
    int translateNum(int num) {
        string strNum = to_string(num);
        int dp[strNum.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 1; i < strNum.length(); ++i) {
            dp[i + 1] = dp[i];
            if (strNum[i - 1] != '0' && strNum.substr(i - 1, 2) <= "25") {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[strNum.length()];
    }
};