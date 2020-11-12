package Greedy;

/**
 * Created by tkmaab4 on 9/3/20.
 *
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

 Example 1:

 Input: 2736
 Output: 7236
 Explanation: Swap the number 2 and the number 7.
 */
public class MaxSwap {


    public static int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int num = 2736;
        System.out.println(maximumSwap(num));
    }
}


