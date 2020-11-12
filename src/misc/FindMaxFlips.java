package misc;

/**
 * Created by tkmaab4 on 6/6/20.
 */
public class FindMaxFlips {

    public static void main(String[] args) {
        int[] input = {1,0,1,0,1,1,1,0,1};

        int startIndex = 0;
        int endIndex = 0;
        int max = 0;
        for (int i = 0; i<input.length;i++){

            if (input[i] ==0){
                endIndex = i-1;

            }

            max = Math.max(endIndex - startIndex+1,max);

            startIndex = endIndex;

        }

        System.out.println("Max "+ max);
    }
}
