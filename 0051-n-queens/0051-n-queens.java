class Solution {

    public static boolean isSafe(char board[][], int row, int col) {

        // Vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal left-up
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal right-up
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length; i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void saveBoard(char board[][], List<List<String>> allBoards) {

        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            String row = "";

            for (int j = 0; j < board.length; j++) {
                row += board[i][j];
            }

            newBoard.add(row);
        }

        allBoards.add(newBoard);
    }

    public static void helper(char board[][], int row,
                              List<List<String>> allBoards) {

        // Base case: all queens are placed
        if (row == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        // Try placing a queen in every column
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 'Q';

                helper(board, row + 1, allBoards);

                // Backtracking
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> allBoards = new ArrayList<>();

        char board[][] = new char[n][n];

        // Initialize board with empty cells
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(board, 0, allBoards);

        return allBoards;
    }
}
