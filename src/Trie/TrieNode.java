package Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tkmaab4 on 6/10/20.
 */
public class TrieNode {

    Map<Character,TrieNode> children;
    boolean endOfWord;
    int wordCount;
    String wordSoFar;

    TrieNode (){
        children = new HashMap<Character, TrieNode>();
        endOfWord = false;
        wordSoFar = null;
    }
}
