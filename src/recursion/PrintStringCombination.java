package recursion;

import java.util.*;

/**
 * Created by tkmaab4 on 6/30/20.
 */
public class PrintStringCombination {

    public static void main(String[] args) {
        String input = "ABC";

        List<Character> buffer = new ArrayList<>();
        printAllCombination(input.toCharArray(),buffer);
    }

    private static void printAllCombination(char[] chars, List<Character> bufferOut) {
        List<Character> buffer = new ArrayList<>(bufferOut);
            if(buffer.size() == chars.length){
                System.out.println(Arrays.toString(buffer.toArray()));
                return;
            }
            for (char ch: chars){
                if(!buffer.contains(ch)) {
                    buffer.add(ch);
                    printAllCombination(chars,buffer);
                    buffer.remove(buffer.size()-1);

                }

            }
    }
}
