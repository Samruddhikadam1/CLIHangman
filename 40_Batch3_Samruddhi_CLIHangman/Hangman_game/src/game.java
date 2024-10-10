
/**
 *  author: Samruddhi Kadam
 *  roll no: 2441
 *  Title: Hangman : the guessing game
 *  Start Date: 6 August 2024
 *  Modified Date:  12 August 2024
 *  Description: In this game user have to guess the alphabet and make a word.
 */
import java.util.Scanner;

public class game {
    protected Scanner scanner = new Scanner(System.in);
    protected int triesLeft;
    protected char[] currentGuess;
    protected int score;

    public game(int wordLength) {
        this.triesLeft = wordLength;
        this.currentGuess = new char[wordLength];
        this.score = 0; // Initialize the score
        for (int i = 0; i < wordLength; i++) {
            this.currentGuess[i] = '_';
        }
    }

    public void displayCurrentGuess() {
        for (char c : currentGuess) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public char makeGuess() {
        String input = scanner.nextLine().toLowerCase();

        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Invalid input :( Please enter a single alphabetic character.");
            input = scanner.nextLine().toLowerCase();
        }

        return input.charAt(0);
    }

    public void updateCurrentGuess(String wordToGuess, char guess) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                currentGuess[i] = guess;
            }
        }
    }

    public boolean isWordGuessed() {
        for (char c : currentGuess) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public int getTriesLeft() {
        return triesLeft;
    }

    public void decrementTries() {
        triesLeft--;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++; // Increment score for each correct guess
    }
    
    public void draw(int n) {
    	if(n==1) {
    		System.out.println("  +---+\r\n"
    				+ "  |   |\r\n"
    				+ "      |\r\n"
    				+ "      |\r\n"
    				+ "      |\r\n"
    				+ "      |\r\n"
    				+ "=========\r\n"
    				+ "");
    	}else if(n==2) {
    		System.out.println("  +---+\r\n"
    				+ "  |   |\r\n"
    				+ "  O   |\r\n"
    				+ "      |\r\n"
    				+ "      |\r\n"
    				+ "      |\r\n"
    				+ "=========\r\n"
    				+ "");
    	}else if(n==3) {
    		System.out.println("  +---+\r\n"
        			+ "  |   |\r\n"
        			+ "  O   |\r\n"
        			+ "  |   |\r\n"
        			+ "      |\r\n"
        			+ "      |\r\n"
        			+ "=========\r\n"
        			+ "");
    	}else if(n==4) {
    		System.out.println("  +---+\r\n"
    				+ "  |   |\r\n"
    				+ "  O   |\r\n"
    				+ " /|   |\r\n"
    				+ "      |\r\n"
    				+ "      |\r\n"
    				+ "=========\r\n"
    				+ "");
    	}else if(n==5) {
    		System.out.println("  +---+\r\n"
    				+ "  |   |\r\n"
    				+ "  O   |\r\n"
    				+ " /|\\  |\r\n"
    				+ "      |\r\n"
    				+ "      |\r\n"
    				+ "=========\r\n"
    				+ "");
    	}else if(n==6) {
    		System.out.println("  +---+\r\n"
    				+ "  |   |\r\n"
    				+ "  O   |\r\n"
    				+ " /|\\  |\r\n"
    				+ " /    |\r\n"
    				+ "      |\r\n"
    				+ "=========\r\n"
    				+ "");
    	}else if(n==7) {
    		System.out.println("  +---+\r\n"
    				+ "  |   |\r\n"
    				+ "  O   |\r\n"
    				+ " /|\\  |\r\n"
    				+ " / \\  |\r\n"
    				+ "      |\r\n"
    				+ "=========\r\n"
    				+ "");
    	}
    	
    }
}