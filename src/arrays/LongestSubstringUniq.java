package arrays;

/**
 * Created by tkmaab4 on 3/19/20.
 * Find the longest unique substring
 */
public class LongestSubstringUniq {

    public static void main(String[] args) {
        String input =  "whatwhywhere";//atwhy
        int startIndex=0;
        int endIndex=1;
        String resultString=input.substring(0,1);
        String longestSubstringUniq = resultString;

        while (startIndex < input.length()) {
            if (startIndex > endIndex) {
                break;
            }
            if (endIndex >= input.length() || startIndex >= input.length()) {
                break;
            }
            if (resultString.indexOf(input.charAt(endIndex)) == -1) {
                resultString=resultString+input.charAt(endIndex);
                endIndex++;
            }else {
                startIndex=startIndex+resultString.indexOf(input.charAt(endIndex))+1;
                resultString=input.substring(startIndex,endIndex)+ input.charAt(endIndex);
                endIndex++;
            }

            if (longestSubstringUniq.length() < resultString.length()){
                longestSubstringUniq=resultString;
            }

        }
        System.out.println("longestSubstringUniq-----"+ longestSubstringUniq);
    }

}

