package linkedlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by tkmaab4 on 4/1/20.
 * Find the smallest substring which contains all the words.
 *
 */
public class SmallestSubstring {

    public static void main(String[] args) {

        String doc = "a set of words that is complete in itself, typically containing a subject and predicate, conveying a statement, question, exclamation, or command, and consisting of a main clause and sometimes one or more subordinate clauses";
        String[] matchingWords = {"and", "of", "one"};

        String[] wordArray = doc.split("");

        String smallestSubstring = getSmallestSubstring(matchingWords,doc);
        System.out.println("smallestSubstring >> " + smallestSubstring);

    }

    private static String getSmallestSubstring(String[] matchingWords, String doc) {

        String result = null;

        HashSet<String> matchingWordsSet = new HashSet<>();

        for (String matchingWord : matchingWords){
            matchingWordsSet.add(matchingWord);
        }

        HashMap<String,DoublyLinkedNode> stringDoublyLinkedListHashMap = new HashMap<>();
        DoublyLinkedList linkedList = new DoublyLinkedList();

        WordIterator iterator = new WordIterator(doc);

        while(iterator.hasNext()){
            WordIndex wordIndex = iterator.next();
            if (!matchingWordsSet.contains(wordIndex.word)) {
                continue;
            }

            if(stringDoublyLinkedListHashMap.containsKey(wordIndex.word)){
                linkedList.removeNode(stringDoublyLinkedListHashMap.get(wordIndex.word));
            }

            DoublyLinkedNode newNode = new  DoublyLinkedNode<>(wordIndex.word,wordIndex.index);
            linkedList.appendLinkedList(newNode);
            stringDoublyLinkedListHashMap.put(wordIndex.word,newNode);


            if (matchingWordsSet.size() == stringDoublyLinkedListHashMap.size()){
                int startIndex = (int)linkedList.head.value;
                int endIndex = (int)linkedList.tail.value;
                String wordAtEndIndex = (String)linkedList.tail.key;
                endIndex = endIndex + wordAtEndIndex.length() - 1 ;



                if (result == null || (endIndex-startIndex + 1) < result.length()) {
                    result = doc.substring(startIndex,endIndex+1);
                }

            }


        }

        return result;

    }

}
