package arrays;

import java.util.Arrays;

/**
 * Created by tkmaab4 on 3/13/20.
 *
 * Largest Sum Contiguous Subarray
**/
public class Kadane {

    public static void main(String[] args) {
    int [] input = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
    int current_sum=input[0];
    int best_sum=input[0];
    int lastIndex=0;
    int beginningIndex=0;
    for(int i = 1;i<input.length;i++){
        current_sum=Math.max(current_sum+input[i],input[i]);
        if(best_sum < current_sum){
            lastIndex=i;
            best_sum=current_sum;
        }
    }
    System.out.println(best_sum);
        current_sum=0;
    for (int i=lastIndex;i>0;i--){
        current_sum = current_sum + input[i];
        if (current_sum == best_sum){
            beginningIndex=i;
            break;
        }
    }
    System.out.println("beginningIndex ::" + beginningIndex +"::"+input[beginningIndex] + "::" + "lastIndex" +lastIndex+"::" + input[lastIndex]);
    }

}
