class Solution {
    public String intToRoman(int num) {
        int[] digits = new int[4];
        for (int i = 0; i < 4; ++i) {
            digits[i] = num % 10;
            num /= 10;
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < digits[3]; ++i) res.append("M");
        for (int i = 2; i >= 0; --i) {
            if (9 == digits[i]) {
                switch (i) {
                    case 2: res.append("CM"); break;
                    case 1: res.append("XC"); break;
                    case 0: res.append("IX"); break;
                }
            } else if (4 == digits[i]) {
                switch (i) {
                    case 2: res.append("CD"); break;
                    case 1: res.append("XL"); break;
                    case 0: res.append("IV"); break;
                }
            } else if (3 >= digits[i]) {
                switch (i) {
                    case 2: for (int j = 0; j < digits[i]; ++j) res.append("C"); break;
                    case 1: for (int j = 0; j < digits[i]; ++j) res.append("X"); break;
                    case 0: for (int j = 0; j < digits[i]; ++j) res.append("I"); break;
                }
            } else {
                switch (i) {
                    case 2: res.append("D"); for (int j = 0; j < digits[i] - 5; ++j) res.append("C"); break;
                    case 1: res.append("L"); for (int j = 0; j < digits[i] - 5; ++j) res.append("X"); break;
                    case 0: res.append("V"); for (int j = 0; j < digits[i] - 5; ++j) res.append("I"); break;
                }
            }
        }
        return res.toString();
    }
}