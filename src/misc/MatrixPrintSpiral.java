package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tkmaab4 on 4/23/20.
 */
public class MatrixPrintSpiral {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{3,5,2,5},{9,4,5,6},{2,4,1,6},{8,5,4,3}};

        printSpiralMatrix(matrix);
    }

    private static void printSpiralMatrix(int[][] matrix) {

        List<Integer> nums = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0) {
            return;
        }
        int size = matrix.length * matrix[0].length;
        int top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length -1;
        int left = 0;

        while (nums.size() < size ){
            //print top row
            for (int i=left ; i <= right && nums.size() < size; i++){
                nums.add(matrix[top][i]);
            }
            top++;
            //print right column
            for(int i=top;i<= bottom && nums.size() < size; i++){
                nums.add(matrix[i][right]);
            }
            right--;
            //print bottom row
            for (int i = right; i>= left && nums.size() < size; i--){
                nums.add(matrix[bottom][i]);
            }
            bottom--;
            //print left column
            for (int i = bottom;i >= top && nums.size() < size;i--){
                nums.add(matrix[i][left]);
            }
            left++;
        }

        for (int i : nums){
            System.out.print(i);
        }
    }
}
