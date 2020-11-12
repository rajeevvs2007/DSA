package arrays;

/**
 * Created by tkmaab4 on 3/19/20.
 */
public class SlidingWindow {

    public static void main(String[] args) {
        int[] test = {1,5,3,5,2,2};
        int target = 4;
        int startIndex=0;
        int endIndex=0;

        int counter=0;
       /*
       o(n2) solution
       while (startIndex < test.length){
            int sum=0;
            for (int k = startIndex; k<=endIndex;k++){
                sum = sum + test[k];
            }
            if (sum < target) {
                endIndex ++;
            } else if (sum > target) {
                startIndex ++;
            } else {
                System.out.println("startIndex ::" + startIndex +"endIndex ::"+endIndex);
                break;
            }



        }
    */

       //o(n) solution
        int sum=test[0];
        while (startIndex < test.length){
            if (sum < target) {
                endIndex ++;
                if (endIndex > test.length) {
                    break;
                }
                sum = sum + test[endIndex];
            } else if (sum > target) {
                sum = sum - test[startIndex];
                startIndex ++;
                if (startIndex > endIndex) {
                    endIndex=startIndex;
                }
            } else {
                System.out.println("startIndex ::" + startIndex +"endIndex ::"+endIndex);
                break;
            }



        }
        }
}
