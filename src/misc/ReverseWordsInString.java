package misc;

import java.util.Arrays;

/**
 * Created by tkmaab4 on 4/24/20.
 * (Level: Easy) Reverse the words in a sentence. For example,

 "what is your name" => "name your is what"
 */
public class ReverseWordsInString {

    public static void main(String[] args) {

        String sentence = "what is your name";
        StringBuffer ouput =new StringBuffer();
        char[] inputCharArray = sentence.toCharArray();
        int len = inputCharArray.length;
        // Reverse the entire string
        reverse(inputCharArray,0,len-1);

        int i = 0;
        int start=0;
        //reverse each words
        while(i < len){
            if (inputCharArray[i] == ' ') {
                reverse(inputCharArray,start,i-1);
                start = i + 1;
            }
            i++;
        }
        //reverse last word
        reverse(inputCharArray,start,len-1);
       System.out.println("Reveresed Words 2 " + String.valueOf(inputCharArray)) ;
    }

    private static String reverse(char[] str, int start, int end){
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return Arrays.toString(str);

    }
}
