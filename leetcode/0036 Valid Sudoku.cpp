class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<vector<bool>> isFill(27, vector<bool> (9, false));

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if ('.' != board[i][j]) {
                    if (isFill[i][board[i][j] - '1'] == true ||
                        isFill[j + 9][board[i][j] - '1'] == true) {
                        return false;
                    } else {
                        isFill[i][board[i][j] - '1'] = true;
                        isFill[j + 9][board[i][j] - '1'] = true;
                    }

                    if (0 <= i && i < 3) {
                        if (0 <= j && j < 3) {
                            if (isFill[18][board[i][j] - '1'] == true) {
                                return false;
                            } else {
                                isFill[18][board[i][j] - '1'] = true;
                            }
                        } else if (3 <= j && j < 6) {
                            if (isFill[19][board[i][j] - '1'] == true) {
                                return false;
                            } else {
                                isFill[19][board[i][j] - '1'] = true;
                            }
                        } else {
                            if (isFill[20][board[i][j] - '1'] == true) {
                                return false;
                            } else {
                                isFill[20][board[i][j] - '1'] = true;
                            }
                        }
                    } else if (3 <= i && i < 6) {
                        if (0 <= j && j < 3) {
                            if (isFill[21][board[i][j] - '1'] == true) {
                                return false;
                            } else {
                                isFill[21][board[i][j] - '1'] = true;
                            }
                        } else if (3 <= j && j < 6) {
                            if (isFill[22][board[i][j] - '1'] == true) {
                                return false;
                            } else {
                                isFill[22][board[i][j] - '1'] = true;
                            }
                        } else {
                            if (isFill[23][board[i][j] - '1'] == true) {
                                return false;
                            } else {
                                isFill[23][board[i][j] - '1'] = true;
                            }
                        }
                    } else {
                        if (0 <= j && j < 3) {
                            if (isFill[24][board[i][j] - '1'] == true) {
                                return false;
                            } else {
                                isFill[24][board[i][j] - '1'] = true;
                            }
                        } else if (3 <= j && j < 6) {
                            if (isFill[25][board[i][j] - '1'] == true) {
                                return false;
                            } else {
                                isFill[25][board[i][j] - '1'] = true;
                            }
                        } else {
                            if (isFill[26][board[i][j] - '1'] == true) {
                                return false;
                            } else {
                                isFill[26][board[i][j] - '1'] = true;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
};