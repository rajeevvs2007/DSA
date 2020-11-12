package recursion;

/**
 * Created by tkmaab4 on 6/18/20.
 */
public class Sudoku {





    public static void main(String[] args) {
        int[][] sudoku ={
                {9,0,0,1,0,0,0,0,5},
                {0,0,5,0,9,0,2,0,1},
                {8,0,0,0,4,0,0,0,0},
                {0,0,0,0,8,0,0,0,0},
                {0,0,0,7,0,0,0,0,0},
                {0,0,0,0,2,6,0,0,9},
                {2,0,0,3,0,0,0,0,6},
                {0,0,0,2,0,0,9,0,0},
                {0,0,1,9,0,4,5,7,0},
        };

        boolean solved = solve(sudoku);
        if (solved) {
            display(sudoku);
        }

    }

    private static void display(int[][] sudoku) {
        for (int i =0; i<sudoku.length; i++){
            for (int j =0; j < sudoku[0].length;j++){
                System.out.print("\t" + sudoku[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean solve(int[][] sudoku) {

        if (sudoku.length <=0) {
            throw new IllegalArgumentException("Unsupported board");
        }

        for (int i=0;i<sudoku.length;i++){
            for(int j=0;j<sudoku[0].length;j++){
                if (sudoku[i][j] == 0){
                    System.out.println("trying to solve row -" + i + "col -" + j);
                    for (int k = 1; k<=9; k++){
                        if(isOK(sudoku,i,j,k)){
                            if (solve(sudoku)) {
                                return true;
                            } else {
                                sudoku[i][j] = 0;
                            }
                        }


                    }
                    System.out.println("unsolved row -" + i + "col -" + j);
                    return false;
                }

            }

        }
            return true;
    }

    private static boolean isOK(int[][] board,int row,int col,int value){
        if(!isFoundInCol(board,row,col,value) && !isFoundInRow(board,row,col,value) && !isFoundInBox(board,row,col,value)){
            board[row][col] = value;
            return true;
        }
        return false;
    }


    private static boolean isFoundInCol(int[][] board,int row,int col,int value){
        for (int i=0; i < board.length; i ++){
            if (board[i][col] == value) {
                return true;
            }
        }
        return false;
    }

    private static boolean isFoundInRow(int[][] board, int row,int col,int value){
        for (int i=0; i < board[0].length; i ++){
            if (board[row][i] == value) {
                return true;
            }
        }

        return false;
    }

    private static boolean isFoundInBox(int[][] board,int row,int col,int value){
        int r=row - row%3;
        int c=col - col%3;

        for (int i=r ;i<r +3; i++) {
            for (int j=c; j<c+3; j++){
                if (board[i][j] == value){
                    return true;
                }
            }
        }

        return false;
    }
}
