import java.io.*;
import java.util.*;

public class main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Guess! A two Word guessing game. The player has 10 chances to guess two words, each chance you can guess one character or a word and it will fill in the blanks, or announce if the guess is incorrect. if the word is not found by the 10th try, the user is forced to guess the two words.");

        Word word1 = new Word(Words);
        Word word2 = new Word(Words);
        char[] User1 = new char[5];
        char[] User2 = new char[5];

        for(int i = 0; i < 10; i++) {
            System.out.println("Enter Word or Character");
            String input = sc.next();
            if(input.length() == 1){

            }

        }
    }
    public static String[] Words = {"Apple", "Beach", "Brain", "Bread", "Brush", "Chair", "Chest", "Chord", "Click", "Clock", "Cloud", "Dance", "Diary", "Drink", "Earth", "Flute", "Fruit", "Ghost", "Grape", "Green", "Happy", "Heart", "House", "Juice", "Light", "Money", "Party", "Pizza", "River", "Radio", "Sheep", "Smile", "Snack", "Snake", "Spice", "Storm", "Table", "Toast", "Tiger", "Train", "Water", "Tiger", "Woman", "World", "Write", "Youth", "Abyss", "Ample", "Ankle", "Brisk", "Clasp", "Drape", "Elite", "Flair", "Gloom", "Haste", "Ivory", "Joust", "Knead", "Mourn", "Nanny", "Olive", "Poise", "Quake", "Ravel", "Swish", "Tonic", "Tweak"};

    public static ArrayList<Integer> findChar(String word, char key)
    {

    }

}
