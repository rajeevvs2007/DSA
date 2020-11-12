package bit;

import java.math.BigInteger;

/**
 * Created by tkmaab4 on 8/20/20.
 */
public class BitAddition {

    public static void main(String[] args) {

        BigInteger h = BigInteger.valueOf((long)Math.pow(2,32));

        System.out.println(" big int ");

        String a = "1010";
        String b = "1100";

        int f = 10;
        if (f != 0) {

        }

        System.out.println(addBinary(a,b));

    }

    public static String addBinary(String a, String b) {
        System.out.println("Integer.parseInt(a, 2) " + Integer.parseInt(a, 2));
        //return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));


        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        System.out.println("new BigInteger(a, 2) " + x);
        System.out.println("new BigInteger(b, 2) " + y);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);


    }
}
