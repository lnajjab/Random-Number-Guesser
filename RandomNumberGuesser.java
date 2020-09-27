import java.util.Scanner;
/**
 * This program creates a random number from 1-100 and prompts the user to guess until they are correct
 * @author Laith Najjab
 *
 */
public class RandomNumberGuesser {
	
	public static void main(String[] args) {
	
		final String PROGRAMMER_NAME = "Laith Najjab";
		Scanner in = new Scanner(System.in);
		boolean boolContinue = true, boolInvalid = false;
		char responseLetter;
		
		//Print program header
		HelpfulMethods.printHeader("Guess the Random Number!");
		
		//Explain initial boundaries
		System.out.println("\nYou must guess a number between 1 and 100(inclusive)");
	
	MAIN_LOOP:
		while (boolContinue) {
			
			//Sets and resets boundary guesses
			int highGuess = 101, lowGuess = 0, nextGuess;
			//Creates a random number from 1 to 100
			int randNum = RNG.rand();
		
		while (true) {
			
			//Prompt user to guess for the first time
			if (RNG.getCount() == 0) {
				System.out.println("Enter your first guess:");
			}
			//Prompts user for subsequent guesses
			else {
				System.out.println("Number of guesses is " + RNG.getCount());
				System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess + "(exclusive)");
			}
			
			//Ensures user's input is a valid guess
			do  {
				nextGuess = in.nextInt();
			
			} while (!(RNG.inputValidation(nextGuess, lowGuess, highGuess)));
			
			//Checks whether guess was correct
			if (nextGuess == randNum)
			{
				System.out.println("You guessed correctly!");
			
			//Prompts user to play again
			do {
				
				System.out.println("Would you like to play again(y/n)?");
				responseLetter = in.next().charAt(0);
				
				if (HelpfulMethods.yesOrNo(responseLetter) == 1) {
					boolContinue = true;
					RNG.resetCount();
					continue MAIN_LOOP;
					}
				else if (HelpfulMethods.yesOrNo(responseLetter) == 2){
					boolContinue = false;
					break MAIN_LOOP;
					}
				else if (HelpfulMethods.yesOrNo(responseLetter) == 3) {
					System.out.println("Error: Invalid response, try again");
					boolInvalid = true;
					}
				} while (boolInvalid);
			}
			//Checks if guess is greater than random number and sets the guess as the upper boundary if so
			else if (nextGuess > randNum) {
				System.out.println("Too High!");
				highGuess = nextGuess;
				
			}
			//Checks if guess is lower than random number and sets the guess as the lower boundary if so         
			else if (nextGuess < randNum) {
				System.out.println("Too Low!");
				lowGuess = nextGuess;
				}
			
			}
		
		}

		System.out.println("Thanks for playing!");
		System.out.println("Programmer: " + PROGRAMMER_NAME);
	}
}
