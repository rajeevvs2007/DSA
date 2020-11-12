package recursion;

/**
 * Created by tkmaab4 on 6/13/20.
 */
public class PowerFunction {

    public static void main(String[] args) {



        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("power 5 " + powerof(2,50,1));
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("powerOptimized 5 " + powerOptimized(2,50));
            }
        };

        runnable1.run();
        runnable2.run();

    }

    private static int powerof(int n, int power, int index) {
        if (power == index){

            return n;
        }
        return n * powerof(n,power,index+1);
    }

    private static int powerOptimized(int n, int power){
        if (power == 1) {
            return n;
        }
        if (power == 0){
            return 1;
        }

        int powerHalf = powerOptimized(n,power/2);
        int result = powerHalf * powerHalf;
        if (power %2 != 0){
            result = n*result;
        }
        return result;
    }


}
