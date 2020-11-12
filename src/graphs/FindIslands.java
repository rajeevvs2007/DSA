package graphs;

import java.text.DecimalFormat;

/**
 * Created by tkmaab4 on 5/27/20.
 * 1. Find Islands: You are given a 2d array of 1s and 0s. 1 denotes land and 0 denotes water.
 * Land can be connected diagonally or on either 4 ends. You want to find the number of islands in the array.
 */
public class FindIslands {


    public static void main(String[] args) {


       String dsc = "0020";
       System.out.println(parseFormatDouble(dsc));

    }

    public static Double parseFormatDouble(String discAmt) {
        if (null != discAmt) {
            int length = discAmt.length();
            String formattedString = discAmt.substring(0, length - 2)
                    + "." + discAmt.substring(length - 2, length);
            return Double.parseDouble(new DecimalFormat("#.00")
                    .format(Double.parseDouble(formattedString)));
        } else {

        }
        return null;
    }


    private static int dfs(int[][] mat, int i, int j) {
        if( i < 0 || i>=mat.length || j < 0 || j >= mat[i].length || mat[i][j] ==0) {
            return 0;
        }
        mat[i][j] = 0;// this will take care of tracking visited nodes


        // we can make 8 moves from index
        dfs(mat,i+1,j);
        dfs(mat,i-1,j);
        dfs(mat,i,j+1);
        dfs(mat,i,j-1);

        dfs(mat,i+1,j+1);
        dfs(mat,i-1,j+1);
        dfs(mat,i+1,j+1);
        dfs(mat,i+1,j-1);

        return 1;

    }


}
