import java.util.*;

public class Word {
    char[] word;

    public Word(String[] words){
        Random rand = new Random();
        String temp = words[rand.nextInt(words.length)];

        word = temp.toCharArray();

    }
}
