package misc;

/**
 * Created by tkmaab4 on 4/24/20.
 * (Level: Medium) Find the longest palindromic substring in a string. For example:

 "abcababadef" => "ababa"
 "ffabbahh" => "abba"
 ref : https://www.youtube.com/watch?v=y2BD4MJqV20
 */
public class LongestPalindrome {

    public static void main(String[] args) {

        String input = "abcababadef";
        String test = input.substring(0,input.length());
        System.out.println("input "+test);
        String longestPalindrome = findLongestPalindrome(input);
        System.out.println(longestPalindrome);

    }

    private static String findLongestPalindrome(String input) {
        if (input == null || input.length() < 1) {
            return "";
        }
        int start=0;
        int end=0;
        for (int i=0;i<input.length();i++){
            int len1 = expandFromMiddle(input,i,i);
            int len2 = expandFromMiddle(input,i,i+1);
            int len = Math.max(len1,len2);
            if (len > end-start){
                start=i-((len-1)/2);
                end = i + ((len)/2);

            }
        }
        return input.substring(start,end+1);
    }

    private static int expandFromMiddle(String input, int left, int right){
        if (input == null || left > right) {
            return 0;
        }
        while ((left>= 0 && right< input.length()) && (input.charAt(left) == input.charAt(right))){
            left--;
            right++;
        }
        return right-left-1;
    }
}
