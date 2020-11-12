package hashtable;

/**
 * Created by tkmaab4 on 4/30/20.
 *
 * For strings, we generate hash functions as a polynomial:hash("goat") => 'g'.x​3​ + 'o'.x​2​ + 'a'.x + 't'
 *
 */
public class HashGenerator {

    public static void main(String[] args) {
        String s = "boat";

        char[] chars = s.toCharArray();
        int hash=0,x=31;
        for (int i=0;i<chars.length;i++){
            hash = hash*x + chars[i];
        }
        System.out.println("Generated hash "+ hash);
    }
}
