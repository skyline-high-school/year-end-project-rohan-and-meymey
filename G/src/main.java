import java.io.*;
import java.util.*;

public class main {
   
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to Guess! A Word guessing game. The player has 5 guesses to guess either a single character or the whole of a mystery word.");
        System.out.println();
        System.out.println("If you manage to guess a character, you will recieve an additional guess!");
        System.out.println("Please input your name below and press enter");
        Scanner name = new Scanner(System.in);
        String user = name.nextLine();
        System.out.println();
        
        RandomWordGenerator wordGenerator = new RandomWordGenerator();
        String secretWord = wordGenerator.getRandomWord();
        Scanner scan = new Scanner(System.in);

        // player starts guessing//
        int attempts = 5;
        char[] current = new char[secretWord.length()];
        for (int i = 0; i < current.length; i++) {
            current[i] = '_';
        }

        while (attempts > 0) {
            System.out.println(user + ", you have " + attempts + " attempts left.");
            System.out.println("Current word: " + String.valueOf(current));

            System.out.print("Enter a letter or the full word guess: ");
            String guess = scan.nextLine();

            boolean isNumeric = true;

            try {
                Double check = Double.parseDouble(guess);
            } catch (NumberFormatException ex) {
                isNumeric = false;
            }

            if(isNumeric) {
                System.out.println();
                System.out.println("Please enter either a single character or a word.");
                System.out.println();
            }

            // when the user guesses the word directly//
            if (guess.equalsIgnoreCase(secretWord)) {
                System.out.println("Congratulations! You guessed the word correctly.");
                break;
            } else if (guess.length() == 1) {
                char letter = guess.charAt(0);
                //boolean correct variable will create a conditional if the gussed letter is found anywhere in the String//
                boolean correct = false;
                //checking the mystery word for the guessed character//
                for (int i = 0; i < secretWord.length(); i++) {
                    if ((secretWord.toLowerCase().charAt(i) == letter )) {
                        correct = true;
                        current[i] = letter;
                        //user will get one more attempt for each correct guess//
                        attempts++;
                    }
                }
                if (correct) {
                    System.out.println();
                    System.out.println("Good guess!");
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println("Incorrect guess.");
                    System.out.println();
                    //attempts decrement when an inccorect guess is made//
                    attempts--;
                }
            } else {
                System.out.println();
                System.out.println("Incorrect guess");
                System.out.println();
                attempts--;
            }
            //if the word is fully guessed either through characters or direct answer//
            if (String.valueOf(current).equalsIgnoreCase(secretWord)) {
                System.out.println("Congratulations! You guessed the word correctly.");
                System.out.println();
                System.out.println("The word was " + secretWord);
                System.out.println();
                System.out.println("Thanks for playing!");
                //break used to end the loop as the user won the game//
                break;
            }
        }

        //conditional so that when attempts reaches zero the user gets a message the game is over and they lost//
        if (attempts == 0) {
                System.out.println("You lost because you ran out of attempts. The word was: " + secretWord);
                System.out.println();
                System.out.println("Thanks for playing!");
                System.out.println();
        }
    }

    public static boolean inArray(char a, char[] current) {
        for (char b : current) {
            if(a == b) {
                return true;
            }
        }
        return false;
    }
}








