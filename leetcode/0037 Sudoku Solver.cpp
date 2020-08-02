class Solution {
public:
    bool core(vector<vector<char>>& board, int rows[][9], int cols[][9], int subBoxs[][9], int i, int j) {
        if (board[i][j] == '.') {
            for (int k = 0; k < 9; ++k) {
                if (rows[i][k] == 0 && cols[j][k] == 0 && subBoxs[i / 3 * 3 + j / 3 * 3 / 3][k] == 0) {
                    rows[i][k] = cols[j][k] = subBoxs[i / 3 * 3 + j / 3 * 3 / 3][k] = 1;
                    board[i][j] = '1' + k;
                } else if (k == 8) {
                    return false;
                } else {
                    continue;
                }

                if (j == 8) {
                    if (i == 8) {
                        return true;
                    } else {
                        if (core(board, rows, cols, subBoxs, i + 1, 0)) {
                            return true;
                        } else {
                            rows[i][k] = cols[j][k] = subBoxs[i / 3 * 3 + j / 3 * 3 / 3][k] = 0;
                            board[i][j] = '.';
                        };
                    }
                } else {
                    if (core(board, rows, cols, subBoxs, i, j + 1)) {
                        return true;
                    } else {
                        rows[i][k] = cols[j][k] = subBoxs[i / 3 * 3 + j / 3 * 3 / 3][k] = 0;
                        board[i][j] = '.';
                    };
                }
            }
        } else {
            if (j == 8) {
                if (i == 8) return true;
                else return core(board, rows, cols, subBoxs, i + 1, 0);
            } else {
                return core(board, rows, cols, subBoxs, i, j + 1);
            }
        }
        return false;
    }

    void solveSudoku(vector<vector<char>>& board) {
        int rows[9][9] = {0};
        int cols[9][9] = {0};
        int subBoxs[9][9] = {0};

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    rows[i][board[i][j] - '1'] = 1;
                    cols[j][board[i][j] - '1'] = 1;
                    subBoxs[i / 3 * 3 + j / 3 * 3 / 3][board[i][j] - '1'] = 1;
                }
            }
        }

        core(board, rows, cols, subBoxs, 0, 0);
    }
};