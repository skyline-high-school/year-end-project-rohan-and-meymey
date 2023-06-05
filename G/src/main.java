import java.io.*;
import java.util.*;

public class main {
   
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Welcome to Guess! A Word guessing game. The player has 5 guesses to guess either a single character or the whole of two mystery words at the same time.");
        System.out.println();
        System.out.println("If you manage to guess a character, you will receive an additional guess!");
        System.out.println();
        System.out.println("Please input your name below and press enter:");
        Scanner name = new Scanner(System.in);
        String user = name.nextLine();
        System.out.println();

        // Set up secret words
        RandomWordGenerator wordGenerator = new RandomWordGenerator();
        String secretWord1 = wordGenerator.getRandomWord();
        String secretWord2;
        do{
            secretWord2 = wordGenerator.getRandomWord();
        } while(secretWord2.equals(secretWord1)); //first generate secret word 2, if it equals the first, then we will regenerate a word. Exit while loop when they are different


        Scanner scan = new Scanner(System.in);

        // player starts guessing//
        int attempts = 5;
        char[] current1 = new char[secretWord1.length()];
        for (int i = 0; i < current1.length; i++) {
            current1[i] = '_';
        }

        char[] current2 = new char[secretWord2.length()];
        for (int i = 0; i < current2.length; i++) {
            current2[i] = '_';
        }

        //track if the user guesses one correct or two correct
        boolean correct1 = false;
        boolean correct2 = false;

        while (attempts > 0) {
            //if the word is fully guessed either through characters or direct answer//
            if (correct1 && correct2) {
                System.out.println("Congratulations! You guessed the words correctly.");
                System.out.println();
                System.out.println("The words were " + secretWord1 + ", " + secretWord2);
                System.out.println();
                System.out.println("Thanks for playing!");
                //break used to end the loop as the user won the game//
                break;
            }

            System.out.println(user + ", you have " + attempts + " attempts left.");
            System.out.println("Current words: " + String.valueOf(current1) + ", " + String.valueOf(current2));

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
            if (guess.equalsIgnoreCase(secretWord1)) {
                System.out.println("Congratulations! You guessed the first word correctly.");
                correct1 = true;
                if(!correct2){
                    System.out.println("Continue guessing for the second word.");
                }
                current1 = secretWord1.toCharArray();
            } else if (guess.equalsIgnoreCase(secretWord2)) {
                    System.out.println("Congratulations! You guessed the second word correctly.");
                    correct2 = true;
                    if(!correct1){
                        System.out.println("Continue guessing for the first word.");
                    }
                    current2 = secretWord2.toCharArray();
            } else if (guess.length() == 1) {
                char letter = guess.charAt(0);

                //boolean correct variable will create a conditional if the guessed letter is found anywhere in the String//
                boolean correctLetter1 = false;
                //checking the mystery word for the guessed character//
                for (int i = 0; i < secretWord1.length(); i++) {
                    if ((secretWord1.toLowerCase().charAt(i) == letter )) {
                        correctLetter1 = true;
                        current1[i] = letter;
                        //user will get one more attempt for each correct guess//
                        attempts++;
                    }
                }

                boolean correctLetter2 = false;
                //checking the mystery word for the guessed character//
                for (int i = 0; i < secretWord2.length(); i++) {
                    if ((secretWord2.toLowerCase().charAt(i) == letter )) {
                        correctLetter2 = true;
                        current2[i] = letter;
                        //user will get one more attempt for each correct guess//
                        attempts++;
                    }
                }

                if (correctLetter1 || correctLetter2) {
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

        }

        //conditional so that when attempts reaches zero the user gets a message the game is over and they lost//
        if (attempts == 0) {
                System.out.println("You lost because you ran out of attempts. The words were : " + secretWord1 + ", " + secretWord2);
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








