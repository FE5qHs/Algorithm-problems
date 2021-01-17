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