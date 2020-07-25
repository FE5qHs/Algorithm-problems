class Solution {
public:
    int countDigitOne(int n) {
        if (n < 0) return 0;
        
        vector<unsigned long long> digits;
        while (n != 0) {
            digits.push_back(n % 10);
            n /= 10;
        }
        unsigned long long digitOnes[digits.size()];

        vector<unsigned long long> totalOnes = {2, 12, 13, 14, 15, 15, 17, 18, 19, 21};
        if (digits.size() >= 1) {
            if (digits[0] >= 1) digitOnes[0] = 1;
            else digitOnes[0] = 0;
        }
        if (digits.size() >= 2) {
            if (digits[1] == 0) digitOnes[1] = 0;
            else digitOnes[1] = totalOnes[digits[1] - 1];
        }
        if (digits.size() >= 3) {
            for (int i = 2, c = 1, h = 2, j = 11, k = 21; i < digits.size(); ++j) {
                if (c == 1) totalOnes.push_back(totalOnes[j - 2] + k - 2 + pow(10, h));
                else if (c == 9) totalOnes.push_back(totalOnes[j - 2] + k);
                else totalOnes.push_back(totalOnes[j - 2] + k - 1);

                if (++c == 10) {
                    c = 1;
                    ++h;
                    k = totalOnes[j - 1];
                }

                if (digits[i] == 0) {
                    digitOnes[i] = 0;
                    ++i;
                    continue;
                }
                if (i == 2 && digits[i] == 1) {
                    digitOnes[i] = 21;
                    ++i;
                    continue;
                }
                if (digits[i] * pow(10, i) == c * pow(10, h)) {
                    digitOnes[i] = totalOnes[j - 1];
                    ++i;
                }
            }
        }

        int sum = 0;
        for (int i = digits.size() - 1, preOnes = 0; i >= 0; --i) {
            sum += digitOnes[i] + preOnes * digits[i] * pow(10, i);
            if (digits[i] == 1) ++preOnes;
        }
        return sum;
    }
};