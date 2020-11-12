package hashtable;

/**
 * Created by tkmaab4 on 4/30/20.
 * 1. (Level: Hard) String Search: Find the index where the larger string A contains a target string T.
 */
public class RabinKarp {

    public static void main(String[] args) {
        String searchString = "mn";
        String targetString = "rajeev";


        rabinKarpSearch(searchString,targetString);
    }

    private static void rabinKarpSearch(String searchString, String targetString) {
        int searchStrLen=searchString.length();
        int targetStrLen=targetString.length();

        if(searchStrLen > targetStrLen){
            throw new IllegalArgumentException("no match");
        }


        //Calculate the initial hash
        int x = 10;
        double hash=0;
        double hashT =0;
        for(int i=0;i<searchStrLen;i++){
            hash = hash + targetString.charAt(i)*Math.pow(x,searchStrLen-1-i);
            hashT = hashT + searchString.charAt(i)*Math.pow(x,searchStrLen-1-i);
        }
        System.out.println("Hash > "+ hash);
        System.out.println("HashT > "+ hashT);
        if (hash == hashT){
            System.out.println("Match found "+ targetString.substring(0,searchStrLen));
            return;
        }
        int j = searchStrLen+1;
        for(int i=1;i<targetStrLen-searchStrLen+1;i++){
            String searchSlice = targetString.substring(i,j++);
            hash = (hash - targetString.charAt(i-1)*Math.pow(x,searchStrLen-1))*x + targetString.charAt(i+searchStrLen-1);
            System.out.println("searchSlice>> " + searchSlice +" hash "+ hash);
            if (hash == hashT){
                System.out.println("Match found "+ i +"-"+ j);
                return;
            }

        }
    }
}
