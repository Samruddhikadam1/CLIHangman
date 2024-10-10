
/**
 *  author: Samruddhi Kadam
 *  roll no: 2441
 *  Title: Hangman : the guessing game
 *  Start Date: 6 August 2024
 *  Modified Date:  12 August 2024
 *  Description: In this game user have to guess the alphabet and make a word.
 */
import java.util.HashSet;
import java.util.Random;

public class hangman extends game {
	private String[] guesses = {
		    "student", "teacher", "giraffe", "kingdom", "organic", "resolve", "popular", "network", "freedom"
		};
	int n=0;

    private String wordToGuess;
    private Random random = new Random();
    private int cumulativeScore; // Track cumulative score

    public hangman() {
        super(0); // Initialize with 0, we'll reset this in startNewGame()
        startNewGame(); // Start the first game
    }

    public void startNewGame() {
        int randomNumber = random.nextInt(guesses.length);
        wordToGuess = guesses[randomNumber];
        this.triesLeft = wordToGuess.length(); // Adjust triesLeft based on the selected word
        this.currentGuess = new char[wordToGuess.length()];
        for (int i = 0; i < currentGuess.length; i++) {
            currentGuess[i] = '_';
        }
        this.score = 0; // Reset score for this round
    }

    public void playGame() {
        System.out.println("\nLet's Start Playing Hangman:");
        HashSet<Character> guessedLetters = new HashSet<>();
        boolean wordIsGuessed = false;
        boolean hintUsed = false;

        while (!wordIsGuessed && getTriesLeft() > 0) {
            displayCurrentGuess();
            System.out.printf("You have %d tries left.\n", getTriesLeft());
            System.out.println("Enter a single character: ");
            if (getTriesLeft() <=2 && !hintUsed) {
                char hint = revealHint();
                System.out.println("Hint: The word contains the letter '" + hint + "'");
                hintUsed = true;
            }
            char guess = makeGuess();

            if (guessedLetters.contains(guess)) {
                System.out.println("You have already guessed that letter. Try again.");
                continue;
            }

            guessedLetters.add(guess);

            if (wordToGuess.indexOf(guess) >= 0) {
                updateCurrentGuess(wordToGuess, guess);
                incrementScore(); // Increment score for a correct guess
                draw(n);
                System.out.println("Good guess! Your current score is: " + getScore()+"\n\n");
            } else {
                System.out.println("Wrong guess!");
                decrementTries();
                n++;
                draw(n);
                
            }

            if (isWordGuessed()) {
                wordIsGuessed = true;
                System.out.println("Congratulations! You've guessed the word!");
                System.out.println("Your final score for this round is: " + getScore());
                cumulativeScore += getScore(); // Add round score to cumulative score
                n=0;
            }
        }

        if (!wordIsGuessed) {
            System.out.println("You ran out of guesses. The word was: " + wordToGuess);
            System.out.println("Your final score for this round is: " + getScore());
            n=0;
            
        }
    }

    public int getCumulativeScore() {
        return cumulativeScore;
    }
    
    public char revealHint() {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (currentGuess[i] == '_') {
                currentGuess[i] = wordToGuess.charAt(i);
                return wordToGuess.charAt(i);
            }
        }
        return '_';
    }
}