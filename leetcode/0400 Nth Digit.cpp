class Solution {
public:
    int findNthDigit(int n) {
        long long m = n;
        int ten = 10, multiplier = 1;
        while (m >= 0) {
            if (1 == multiplier) {
                m -= (ten - 1) * multiplier;
            } else {
                m -= ((ten - 1) * pow(10, multiplier - 1)) * multiplier;
            }
            ++multiplier;
        }
        --multiplier;
        if (1 == multiplier) {
            m += (ten - 1) * multiplier;
        } else {
            m += ((ten - 1) * pow(10, multiplier - 1)) * multiplier;
        }
        
        int target = pow(10, multiplier - 1) - 1 + m / multiplier;
        if (m % multiplier == 0) return target % 10;

        ++target;
        int res = 0;
        for (int i = 0; i < multiplier; ++i) {
            if (i == multiplier - m % multiplier) res = target % 10;
            target /= 10;
        }
        return res;
    }
};