/**
 *  author: Samruddhi Kadam
 *  roll no: 2441
 *  Title: Hangman : the guessing game
 *  Start Date: 6 August 2024
 *  Modified Date:  12 August 2024
 *  Description: In this game user have to guess the alphabet and make a word.
 */
public class main {
    public static void main(String[] args) {
        hangman hangmanGame = new hangman();
        boolean keepPlaying = true;

        while (keepPlaying) {
            hangmanGame.playGame();
            System.out.println("Would you like to play again? (y/n) ");
            String choice = hangmanGame.scanner.nextLine();
            if (choice.equalsIgnoreCase("y")) {
                hangmanGame.startNewGame(); // Start a new game
            } else {
                keepPlaying = false;
            }
        }

        System.out.println("Your cumulative score is: " + hangmanGame.getCumulativeScore());
        System.out.println("Thank you for playing Hangman!");
        
    }
}