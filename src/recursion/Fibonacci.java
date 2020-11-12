package recursion;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tkmaab4 on 6/12/20.
 */
public class Fibonacci {

    public static int fib(int n){

        if (n ==1 || n == 2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }


    public static void main(String[] args) throws IOException {
        //System.out.println("Fibonacci " + fib(100));
        //System.out.println("Fibonacci " + fibWithMem(40,null));

        Path currentDir = Paths.get("/Users/tkmaab4/Documents/code/cnc-services/kos-cncservices-webapp/target/kos-cncservices-webapp-26.0.0-SNAPSHOT/WEB-INF/lib");
        DirectoryStream<Path> dir = Files.newDirectoryStream(currentDir);
        Iterator<Path> pathIterator =  dir.iterator();

        while (pathIterator.hasNext()) {
            System.out.println(pathIterator.next().getFileName());
        }
    }


    public static int fibWithMem(int n, Map<Integer,Integer> mem){
        if (n ==1 || n ==2){
            return 1;
        }
        if (mem == null){
            mem = new HashMap<>();
        }
        int fib = 0;
        if (mem.get(n) != null){
            fib = mem.get(n);
        } else {
            fib = fibWithMem(n-1,mem) +  fibWithMem(n-2,mem);
            mem.put(n,fib);
        }
        return fib;
    }

}


