// solution1
// time complexity O(6^n)
// space complexity O(n)
class Solution {
public:
    vector<double> dicesProbability(int n) {
        vector<double> res(n * 5 + 1, 0);
        helper(res, 0, n, 0);
        return res;
    }

    void helper(vector<double>& res, int curDices, int maxDices, int curPoints) {
        if (curDices == maxDices) {
            res[curPoints - maxDices] += 1 / pow(6, maxDices);
        } else {
            for (int i = 1; i <= 6; ++i) {
                helper(res, curDices + 1, maxDices, curPoints + i);
            }
        }
    }
};

// solution2
// time complexity O(n^2)
// space complexity O(n^2)
class Solution {
public:
    vector<double> dicesProbability(int n) {
        int rows = n + 1, cols = 6 * n + 1;
        int dp[rows][cols];
        memset(dp, 0, sizeof(dp[0][0]) * rows * cols);
        for (int i = 1; i <= 6; ++i) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            for (int j = i; j <= i * 6; ++j) {
                int res = 0;
                for (int k = 1; k <= 6 && k < j; ++k) {
                    res += dp[i - 1][j - k];
                }
                dp[i][j] = res;
            }
        }
        vector<double> res(5 * n + 1, 0);
        double resBase = pow(6, n);
        for (int i = 0; i < 5 * n + 1; ++i) {
            res[i] = dp[n][n + i] / resBase;
        }
        return res;
    }
};