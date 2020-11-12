package misc;

/**
 * Created by tkmaab4 on 4/21/20.
 * Print all the elements diagonally
 * ref https://www.hackingnote.com/en/interview/problems/matrix-zigzag-traversal
 */
public class MatrixDiagonalElements {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{3,5,2,5},{9,4,5,6},{2,4,1,6},{8,5,4,3}};
        display2DArray(matrix);
        int rows = matrix.length;
        int cols = matrix[0].length;
        printDiagonalElements(matrix,rows,cols);
        printZigZagElements(matrix,rows,cols);
    }

    private static void printZigZagElements(int[][] matrix, int rows, int cols) {
        int totalScans = rows + cols -1;
        for (int i=0;i<totalScans;i++){
            int x=0,y=0;
            if (i%2==0){
                x = i < rows ? i : rows-1;
                y = i < rows ? 0 : i-rows + 1;
                System.out.println();
                while ((x >=0 && x < rows) && (y >=0 && y< cols)) {
                    System.out.print("\t" + matrix[x][y]);
                    x--;
                    y++;
                }

            } else {
                x = i < cols ? 0 : i - cols +1 ;
                y = i < cols ? i : cols-1;
                System.out.println();
                while ((x >=0 && x < rows) && (y >=0 && y< cols)) {
                    System.out.print("\t" + matrix[x][y]);
                    x++;
                    y--;
                }
            }


        }

    }

    private static void printDiagonalElements(int[][] matrix,int rows,int cols) {

        // Diagonals from first column

        for(int k=0;k< rows;k++){
            int i=k,j=0;
            System.out.println();
            while(i>=0 && j<cols){
                System.out.print(matrix[i][j]+"\t");
                i--;
                j++;
            }
        }
        // Diagonals from last row

        for (int k = 1; k < cols; k++) {
            int i = rows-1;
            int j = k;
            System.out.println();
            while (i >= 0 && j < cols) {
                System.out.print(matrix[i][j]+"\t");
                i--;
                j++;
            }

        }


    }

    private static void display2DArray(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row=0 ;row<rows;row++){
            System.out.println();
            for(int col = 0; col < cols; col++){
                System.out.print(matrix[row][col]+"\t");
            }

        }

    }

}
