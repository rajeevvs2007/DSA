package misc;

/**
 * Created by tkmaab4 on 4/24/20.
 * 1. (Level: Easy) Check if a string A is a rotation of another string B. For example, "atbobc" is a rotation of "bobcat".
 */
public class CheckStringForRotation {

    public static void main(String[] args) {
        String input1 = "bobcat";
        String target = "catbob";
        //O(N2)
        checkForRotationSubOptimal(input1,target);

        //O(N)
        checkForRotationOptimal(input1,target);





    }

    private static void checkForRotationOptimal(String input1, String target) {
        String combinedString = input1 + input1;
        if (combinedString.contains(target)) {
            System.out.println("Match");
        }

    }

    private static void checkForRotationSubOptimal(String input1, String target) {
        char[] inputCharArray = input1.toCharArray();
        char[] targetCharArray = target.toCharArray();
        int start= 0;
        int stringLength = inputCharArray.length-1;
        StringBuffer rotatedString = new StringBuffer();
        for (int i=0;i<stringLength;i++){
            int j = i;
            rotatedString = new StringBuffer();
            start=0;
            while(start <= stringLength){
                rotatedString.append(inputCharArray[j]);
                start ++;
                j ++;
                if (j> stringLength){
                    j=0;
                }
            }
            System.out.println("Rotated String"+ rotatedString);
            if (rotatedString.toString().equalsIgnoreCase(target)){
                System.out.println("Match found");
                break;
            }
        }
    }

}
