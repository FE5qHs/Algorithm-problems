class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if ('M' == board[click[0]][click[1]]) {
            board[click[0]][click[1]] = 'X';
        } else {
            boolean[][] flag = new boolean[board.length][board[0].length];
            updateBoardHelper(board, click, flag);
        }
        return board;
    }
    
    private void updateBoardHelper(char[][] board, int[] click, boolean[][] flag) {
        if (flag[click[0]][click[1]]) {
            return;
        }

        int mines = 0;
        if (click[0] > 0 && 'M' == board[click[0] - 1][click[1]]) {
            ++mines;
        }
        if (click[0] < board.length - 1 && 'M' == board[click[0] + 1][click[1]]) {
            ++mines;
        }
        if (click[1] > 0 && 'M' == board[click[0]][click[1] - 1]) {
            ++mines;
        }
        if (click[1] < board[0].length - 1 && 'M' == board[click[0]][click[1] + 1]) {
            ++mines;
        }
        if (click[0] > 0 && click[1] > 0 && 'M' == board[click[0] - 1][click[1] - 1]) {
            ++mines;
        }
        if (click[0] > 0 && click[1] < board[0].length - 1 && 'M' == board[click[0] - 1][click[1] + 1]) {
            ++mines;
        }
        if (click[0] < board.length - 1 && click[1] > 0 && 'M' == board[click[0] + 1][click[1] - 1]) {
            ++mines;
        }
        if (click[0] < board.length - 1 && click[1] < board[0].length - 1 && 'M' == board[click[0] + 1][click[1] + 1]) {
            ++mines;
        }
        flag[click[0]][click[1]] = true;

        if (0 == mines) {
            board[click[0]][click[1]] = 'B';

            if (click[0] > 0) {
                click[0] -= 1;
                updateBoardHelper(board, click, flag);
                click[0] += 1;
            }
            if (click[0] < board.length - 1) {
                click[0] += 1;
                updateBoardHelper(board, click, flag);
                click[0] -= 1;
            }
            if (click[1] > 0) {
                click[1] -= 1;
                updateBoardHelper(board, click, flag);
                click[1] += 1;
            }
            if (click[1] < board[0].length - 1) {
                click[1] += 1;
                updateBoardHelper(board, click, flag);
                click[1] -= 1;
            }
            if (click[0] > 0 && click[1] > 0) {
                click[0] -= 1;
                click[1] -= 1;
                updateBoardHelper(board, click, flag);
                click[0] += 1;
                click[1] += 1;
            }
            if (click[0] > 0 && click[1] < board[0].length - 1) {
                click[0] -= 1;
                click[1] += 1;
                updateBoardHelper(board, click, flag);
                click[0] += 1;
                click[1] -= 1;
            }
            if (click[0] < board.length - 1 && click[1] > 0) {
                click[0] += 1;
                click[1] -= 1;
                updateBoardHelper(board, click, flag);
                click[0] -= 1;
                click[1] += 1;
            }
            if (click[0] < board.length - 1 && click[1] < board[0].length - 1) {
                click[0] += 1;
                click[1] += 1;
                updateBoardHelper(board, click, flag);
                click[0] -= 1;
                click[1] -= 1;
            }
        } else {
            board[click[0]][click[1]] = (char) (mines + '0');
        }
    }
}