package arrays;

/**
 * Created by tkmaab4 on 8/18/20.
 */
public class SubArrays {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};

        for (int i =0;i < a.length; i++) {
            for (int j = i + 1; j <= a.length; j ++) {
           //System.out.println( a[i] + " - " + a[j]);
                for (int k=i;k<j;k++){
                    System.out.println( a[k]);
                }

            }
        }
    }
}
