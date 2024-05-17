import java.util.*;

public class NumberGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int attemptsLimit = 5;
        int score = 0;
        
        System.out.println("Guess a number between 1 and 100 :");
        
        boolean playAgain = true;

        while (playAgain) {

            int generatedNumber = random.nextInt(100 - 1 + 1) + 1;
            int attempts = 0;
            boolean guessCorrect = false;
            
            while (attempts < attemptsLimit) {

                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;
                
                if (userGuess == generatedNumber) {

                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    guessCorrect = true;
                    break;
                } 
                else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessCorrect) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
            }
            
            System.out.print("Would you like to play again? (yes/no): ");
            String playAgainChoice = sc.next();
            
            if (!playAgainChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Your final score: " + score);
        sc.close();
    }
}
