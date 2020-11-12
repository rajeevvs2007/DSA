package DP;

import java.util.Arrays;

/**
 * Created by tkmaab4 on 7/29/20.
 */
public class NQueens {

    public static void main(String[] args) {

        boolean[][] chess = new boolean[8][8];
        for (int i=0;i<chess.length;i++){
            Arrays.fill(chess[i],false);
        }

        placeNQueens(chess,0);
        display(chess);

    }

    private static boolean placeNQueens(boolean[][] chess, int index) {
        if (index == 8){
            return true;
        }
        boolean queenPlaced = false;

        for (int r = 0 ; r < chess.length; r++){

            for (int c = 0; c < chess[0].length; c++){

                if (isValid(chess,r,c)){
                    chess[r][c] = true;
                    queenPlaced = placeNQueens(chess,index+1);
                    return queenPlaced;
                }

            }
        }
        return queenPlaced;

    }

    private static boolean isValid(boolean[][] chess, int row, int col) {

        // check for row
        for (int i=0; i < chess[0].length; i ++) {
            if (chess[row][i] == true) {
                return false;
            }
        }


        // check for column
        for (int i=0; i < chess.length; i ++) {
            if (chess[col][i] == true) {
                return false;
            }
        }

        // check for diagonal
        int r = row;
        int c = col;
        while (r < chess.length && c >= 0) {
            if (chess[r][c] == true) {
                return false;
            }
            r = r +1;
            c = c -1;
        }

         r = row;
         c = col;
        while (r >= 0 && c < chess[0].length) {
            if (chess[r][c] == true) {
                return false;
            }
            r = r - 1;
            c = c  + 1;
        }


        // check for right half
         r = row;
         c = col;
        while (r >= 0 && c >= 0) {
            if (chess[r][c] == true) {
                return false;
            }
            r = r - 1;
            c = c - 1;
        }

        r = row;
        c = col;
        while (r < chess.length && c < chess[0].length) {
            if (chess[r][c] == true) {
                return false;
            }
            r = r + 1;
            c = c  + 1;
        }


        return true;
    }


    private static void display(boolean[][] sudoku) {
        for (int i =0; i<sudoku.length; i++){
            for (int j =0; j < sudoku[0].length;j++){
                System.out.print("\t" + sudoku[i][j]);
            }
            System.out.println();
        }
    }
}
