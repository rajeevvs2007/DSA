package linkedlist;

import java.util.Iterator;

/**
 * Created by tkmaab4 on 4/2/20.
 */
public class WordIterator implements Iterator<WordIndex> {

    String str;
    int position;

    public WordIterator(String str) {
        super();
        this.str = str;
        position=0;
        advanceToNextAlphabet();
    }

    private void advanceToNextAlphabet() {

        while(position < str.length() && !Character.isAlphabetic(str.charAt(position))){
            position++;
        }

    }

    @Override
    public boolean hasNext() {

        return position < str.length();

    }

    @Override
    public WordIndex next() {
        if(!hasNext()) {
            return null;
        }
        int wordStartIndex = position;

        while(position < str.length() && Character.isAlphabetic(str.charAt(position))){
            position++;
        }

        int wordEndIndex = position-1;

        advanceToNextAlphabet();

        String word = str.substring(wordStartIndex,wordEndIndex+1);

        return new WordIndex(word,wordStartIndex);
    }


}

