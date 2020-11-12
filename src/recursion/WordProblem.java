package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tkmaab4 on 6/18/20.
 * Word Break Problem: Given a String S, which contains letters and no spaces, find if it can be broken it into valid words.
 * Return one such combination of words. Assume you are provided a dictionary of English words.


 */
public class WordProblem {

    public static void main(String[] args) {
        String input = "ilikemangotango";
        Map<String, String> dict = new HashMap<>();
        dict.put("i","i");
        dict.put("like","like");
        dict.put("mango","mango");
        dict.put("tango","tango");
        StringBuffer output = new StringBuffer();
        String sentence = findValidSentence(input,0,output,dict);
        System.out.println(sentence);
    }

    private static String findValidSentence(String input, int startIndex, StringBuffer output,Map<String, String> dict) {

        if (startIndex >= input.length()) {
            return output.toString();
        }

        for (int i =startIndex; i<= input.length(); i++){

            String word = input.substring(startIndex,i);
            if (dict.containsKey(word)){
                output.append(word+ " ");

                //recurse
                startIndex = i;

                return findValidSentence(input,startIndex,output,dict);

            }
        }

        return output.toString();
    }
}
