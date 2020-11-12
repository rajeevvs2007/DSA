package linkedlist;

/**
 * Created by tkmaab4 on 4/2/20.
 */
public class WordIndex {
    String word;
    int index;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public WordIndex(String word, int index){
        this.word = word;
        this.index = index;
    }
}
