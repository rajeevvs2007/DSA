package graphs;

import java.util.*;

/**
 * Created by tkmaab4 on 5/12/20.
 *Word Ladder Problem: You are given 2 words A and B, both of the same length.
 *Your task is totransform one word  to another - changing only one letter at a time.
 *Each intermediate wordshould be a valid word in the dictionary. Print out the length of the path.
 * For example,A = CAB, B = DOG
 * Result: 4 (CAB -> COB -> COG -> DOG)
 */
public class WordLadder {

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";

        HashMap<String,String> dictionary = new HashMap<String,String>();
        dictionary.put("hot","hot");
        dictionary.put("dot","dot");
        dictionary.put("dog","dog");
        dictionary.put("lot","lot");
        dictionary.put("log","log");
        dictionary.put("cog","cog");

        int lengthOfLadder = ladderLength(begin,end,dictionary);
        System.out.println("Length of ladder" + lengthOfLadder);


    }

    private static int ladderLength(String begin, String end, HashMap<String, String> dictionary) {
        Queue<String> queue = new LinkedList<String>();
        Map<String,Integer> visitedNodes = new HashMap<String,Integer>();
        Map<Integer,String> pathMap = new HashMap<Integer,String>();

        queue.add(begin);
        int level = 0;
        visitedNodes.put(begin,1);
        while(!queue.isEmpty()) {

            String current = queue.poll();

            pathMap.put(visitedNodes.get(current),current);

            if (current.equals(end)){
                for (String path: pathMap.values()) {
                    System.out.print(path + ">");

                }
                return visitedNodes.get(current);
            }

            List<String> wordsList = findNeighbor(current,dictionary);

            for (String neighbor : wordsList) {
                if (!visitedNodes.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visitedNodes.put(neighbor,visitedNodes.get(current)+1);
                }
            }
        }



        return -1;
    }

    private static List<String> findNeighbor(String current, HashMap<String, String> dictionary) {
        List<String> neighbors = new ArrayList<>();
        char[] wordArray = current.toCharArray();
        for (int i=0;i < wordArray.length;i++) {
            for (char ch = 'a';ch <= 'z';ch ++) {
                if (current.charAt(i) != ch) {
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if (dictionary.containsKey(newWord)) {
                        neighbors.add(newWord);
                    }
                }
            }
            wordArray[i] = current.charAt(i);
        }
        return neighbors;
    }
}
