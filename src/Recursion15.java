

class Recursion15 {

    // Question : Sudoko solver, print only 1 solved sudoko board
    public static void main(String[] args) {
        Recursion15 solution = new Recursion15();

        // Define a sample unsolved Sudoku board
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Original Sudoku Board:");
        printBoard(board);

        solution.solveSudoku(board);

        System.out.println("\nSolved Sudoku Board:");
        printBoard(board);
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char [][]board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                // find the empty cell
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isvalid(board, i , j, ch)){
                            board[i][j]=ch;
                            if(solve(board)==true){
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    //if all the combinations failed from 1 to 9, then return false
                    return false;
                }
            }
        }
        return true;
    }

    boolean isvalid(char board[][], int row, int col,char ch){
        for(int i=0;i<9;i++){
            //checking a row for similar value
            if(board[i][col]==ch)
                return false;

            // checking a column for similar value
            if(board[row][i]==ch)
                return false;

            // checking a 3x3 box
            if(board[3*(row/3)+ i/3][3*(col/3)+ i%3]==ch)
                return false;
        }
        return true;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                if (j != 8) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
