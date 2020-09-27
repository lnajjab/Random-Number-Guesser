/**
 * Collection of utility methods
 * @author Laith Najjab
 *
 */
public class HelpfulMethods {

/**
 * Takes String title and prints the title with dashed lines above and below it
 * @param title
 */
	public static void printHeader(String title) {
		
		for (int i = 0; i < (title.length() + 2) ; i++ )
			System.out.print("-");
		
		System.out.println("\n" + title);
		
		for (int i = 0; i < (title.length() + 2); i++ )
			System.out.print("-");
	}

	/**
	 * Used to evaluate user response to a yes or no question
	 * @param responseLetter
	 * @return response
	 */
	
	public static int yesOrNo(char responseLetter) {
		
		System.out.println("\n");
		int response;
			
			if (responseLetter == 'y' || responseLetter == 'Y')
			{
				response = 1;
			}
			else if (responseLetter == 'n'|| responseLetter == 'N')
			{
				response = 2;
			}
			else
			{
				response = 3;
			}
		
	return response;
	}


}
