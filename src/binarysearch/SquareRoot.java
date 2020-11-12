package binarysearch;

/**
 * Created by tkmaab4 on 3/23/20.
 * Find the square root of an integer X. For example, squareRoot(4) = 2.
 * It is ok to find the integer floor of the square root. So squareRoot(5) or squareRoot(8) can also return 2. squareRoot(9)
 * will return 3.
 * 1 2 3 4
 */
public class SquareRoot {

    public static void main(String[] args) {

        int target = 9;
        System.out.println("Square root of "+ target + "is" + findSquareRoot(target));

    }

    private static int findSquareRoot(int target) {
        int low =0 ;
        int high = target/2;
        int mid = 0;
        int counter = 1;
        while(low <= high) {
            mid = low + (high-low)/2;
            if (square(mid) < target){
                low=mid+1;
            } else if (square(mid) > target){
                high=mid-1;
                if (mid > 0 && square(mid-1) <=target){
                    return mid-1;
                }
            }else {
                return mid;
            }
        }
        return 0;
    }

    private static int square(int number){
        return number*number;
    }

}


