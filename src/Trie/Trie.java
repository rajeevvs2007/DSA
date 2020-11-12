package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tkmaab4 on 6/10/20.
 */
public class Trie {

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }


    void insert(String word){
        TrieNode current = root;
        for (int i=0;i<word.length(); i++){
            if(current.children.get(word.charAt(i)) == null) {
                current.children.put(word.charAt(i), new TrieNode());
            }
            current = current.children.get(word.charAt(i));
            int size = current.wordCount;
            current.wordCount = size+1;

        }
        current.wordSoFar = word;
        current.endOfWord=true;
    }

    boolean search(String key){
        TrieNode current = root;
        for (int i=0;i<key.length(); i++){
            current = current.children.get(key.charAt(i));
            if (current == null) {
                return false;
            }

        }
        return current.endOfWord;
    }


    List<String> prefixSearch(String key){
        TrieNode current = root;
        for (int i = 0; i < key.length();i++){
            if (current.children.get(key.charAt(i)) != null) {
                current = current.children.get(key.charAt(i));
            }
        }
        if (current == null){
            return null;
        }
        List<String> wordsAtEachNode = new ArrayList<String>();
        getWordsAtEachNode(current,wordsAtEachNode);
        return wordsAtEachNode;
    }

    private List<String> getWordsAtEachNode(TrieNode current, List<String> wordsAtEachNode) {
        if (current == null){
            return null;
        }
        if (current.endOfWord){
            wordsAtEachNode.add(current.wordSoFar);
        }
        for (Character ch : current.children.keySet()) {
            getWordsAtEachNode(current.children.get(ch), wordsAtEachNode);
        }
        return wordsAtEachNode;
    }

    int findCount(String key, int index, TrieNode current){
        if (key.length() == index){
            return current.wordCount;
        }

        if (current.children.containsKey(key.charAt(index))){
            current = current.children.get(key.charAt(index));
        }else {
            current = null;
            return 0;
        }
        return findCount(key,index+1,current);
    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("rajeev1");
        trie.insert("rajesh");
        trie.insert("rajiv");
        trie.insert("rajan");
        trie.insert("krishna");
        trie.insert("ponnu");

        System.out.println("Serch found " + trie.search("rajeev"));
        System.out.println("findCount " + trie.findCount("raj",0,trie.root));
        List<String> searchResults = trie.prefixSearch("ra");
        System.out.println("Search results " + Arrays.toString(searchResults.toArray()));
    }
}
