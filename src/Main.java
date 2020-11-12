import java.io.IOException;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        String spattern = "([\\w\\s*\\W]*(P(OST)?.?\\s*((O(FF(ICE)?)?)?.?\\s*(B(IN|OX|.?))|B(IN|OX))+))[\\w\\s*\\W]*";

        String regex = "1838 Allison Way";

        Pattern pattern = Pattern.compile(spattern,Pattern.CASE_INSENSITIVE);

        System.out.println(pattern.matcher(regex).matches());


    }

    private static void changeString(String str) {
        str = "changed";
    }

    private void sort(int[] input) {
        // 1. iterate and find the lowest,swap the lowest position with first position
        // repeat the step 1 for the rest of the numbers
    }

    public static int countX(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean match = false;
        if (str.charAt(str.length()-1) == 'x'){
            match =  true;
        }
        return (match ? 1:0) + countX(str.substring(0,str.length()-1));
    }




}
