package misc;

import java.util.Arrays;

/**
 * Created by tkmaab4 on 4/20/20.
 * Medium -  Rotate a 2D array clockwise by 90 degrees, like rotating the pixels of an image.
 */
public class TwoDimenisonalArray  {

    public static void main(String[] args) {

        int[][] twoDimensional_Array = new int[5][5];

        create2DArray(twoDimensional_Array);

        display2DArray(twoDimensional_Array);


        rotateMatrixBy90(twoDimensional_Array);

        display2DArray(twoDimensional_Array);


    }

    private static void rotateMatrixBy90(int[][] twoDimensional_array) {
        for (int i =0;i< twoDimensional_array.length/2; i++){
            rotateLayer(twoDimensional_array,i,twoDimensional_array.length-1-i);
        }
    }

    private static void rotateLayer(int[][] twoDimensional_array, int start, int end) {
        for (int current=0; start+current < end;current++){
            int temp = twoDimensional_array[end-current][start];
            twoDimensional_array[end-current][start]=twoDimensional_array[end][end-current];
            twoDimensional_array[end][end-current] = twoDimensional_array[start+current][end];
            twoDimensional_array[start+current][end]=twoDimensional_array[start][start+current];
            twoDimensional_array[start][start+current]=temp;
        }
    }

    private static void display2DArray(int[][] twoDimensional_array) {

        for (int row=0 ;row<twoDimensional_array.length;row++){
            System.out.println();
            for(int col = 0; col < twoDimensional_array.length; col++){
                System.out.print(twoDimensional_array[row][col]+"\t");
            }

        }

    }

    private static void create2DArray(int[][] twoDimensional_array) {
        for (int row=0 ;row<twoDimensional_array.length;row++){
            for(int col = 0; col < twoDimensional_array.length; col++){
                twoDimensional_array[row][col]=col;
            }

        }
    }
}
