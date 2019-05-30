/*=================================================================================

Name:          Brandon Mota

The program creates a tile map of specific ascii art objects from text files

INPUT:

The user of this program inputs a 'y' for yes or a 'n' for no.

OUTPUT:

This program prints a little message and asks the user if he wants to see a pa!
When the user answers 'y', it prints the pattern according to the users specif!
and asks the question again.  When the user answers with '!y', the program stop!

PRECONDITIONS and POSTCONDITIONS: None.

=================================================================================*/
import java.util.* ;
import java.io.* ;

public class TileMap

{



/*
    FUNCTION NAME: Main ;
    INPUT: none.
    OUTPUT: a message to the user of this program, all of the
    prompts and a final display according to user specifications.
    PRECONDITIONS:  None.
    POSTCONDITIONS: Variables and calls made according to users input
                    output set to start on a new line.
    CALLERS: None.
    CALLES: askPermission, getParameters(), getImage(), and doTileJob().

*/

// Start of Main Function

	public static int MAXSIDE = 100 ; //sets the limit of the array at 100 x 100
	static String file = null ;
	static int down = 0, across = 0, height = 0, width = 0, high = 0 , wide = 0 ;
	static char [] [] imarray = new char [MAXSIDE][MAXSIDE] ;
	static char answer = 0 ;
	
	public static void main(String args[])
	{		
						
		System.out.println("Would you like to tile an image in a file? ") ; //question is asked
		
		while (askPermission(answer)) //program will continue if the answer is true
		{
			getParameters(file, down, across) ; //gets the dimensions for the tile job from the user
			

			getImage(imarray, file, height, width) ; //puts the image into the arrays
			
			doTileJob(imarray, down, across, height, width) ; //tiles the image as requested
			
			
			System.out.println("\n\nWould you like to tile another image in	a file? ") ; //repeats the question
		}
		
			System.exit(0) ; //the program will exit
		
		
		
	
	

	}

/*
    FUNCTION NAME: askPermission ;
    INPUT: none.
    OUTPUT: a message to the user of this program.
    PRECONDITIONS:  output set to start on a new line.
    POSTCONDITIONS: variable response has user's answer stored in it.
    CALLERS: the main program
    CALLES: None.

*/

	static boolean askPermission(char response)
        {		
		
		Scanner ask = new Scanner(System.in) ;
		
		System.out.print("If yes, type a 'y', else type a 'n' ---------> "); //directions given
		String ans = ask.next() ; //user inputs an answer
		
		if (ans.equalsIgnoreCase("y"))
		{
			return true ;			
		}
		else if (ans.equalsIgnoreCase("n"))
		{
			System.out.println("\nProgram Terminated.");
			return false ;
		}
		else if (ans.equalsIgnoreCase("!y"))
		{
			System.out.println("\nProgram Terminated.");
			return false ;
		}
		else
		{
			System.out.println("\nPlease enter a 'y' for yes, or a 'n' for no. \nRe-run the program.");
			return false ;
		}
        }


/*
   FUNCTION NAME getParameters ;
   INPUT: the file name, number of tiles across and down.
   OUTPUT: message "Getting Image".
   PRECONDITIONS: the variable response has 'y' in it.
   POSTCONDITIONS: variables set with the values entered by user.
   CALLERS: the main program
   CALLEES: none
*/

	static void getParameters(String fileName, int tilesDown, int tilesAcross)
	{
		Scanner questions = new Scanner(System.in);
		
		System.out.print("\nPlease enter the file name ---> ") ;
		file = questions.next() ; // user inputs a filename
		
		System.out.print("Please enter the number of tiles across you want ---> ") ;
		across = questions.nextInt() ; //user inputs the number of tiles across
		
		System.out.print("Please enter the number of tiles down you want ---> ") ;
		down = questions.nextInt() ; //user inputs the number of tiles down		
		
		System.out.println("Getting Image ...\n") ;
	}

/*
    FUNCTION NAME: getImage ;
    INPUT:the file name and the height and width of the pattern to be made.
    OUTPUT: the message "Getting Image".
    PRECONDITIONS: array for image declared, the varibles fileName, 
				   imageHeight and imageWidth set with proper values.  
    POSTCONDITIONS: the image is stored in the array.
    CALLERS: the main program
    CALLEES: none
*/
	static void getImage(char [][] buffer, String fileName, int imageHeight, int imageWidth)
	{
		  try
		  {
              Scanner stream = new Scanner (new File(file + ".txt")) ; //use to get the first two numbers			  
			  high = stream.nextInt() ; //gets height from file
		      wide = stream.nextInt() ; //gets width from file
  
               FileInputStream fstream = new FileInputStream(file + ".txt");  
               DataInputStream in = new DataInputStream(fstream);  
               BufferedReader br = new BufferedReader(new InputStreamReader(in));  
               String strLine;        
               
               strLine = br.readLine() ;
               
		          for (int h = 0; h < high; h++)
		              {
		        	 
		        	  strLine = br.readLine() ;
		        	       for (int w = 0; w < wide; w++)
		        	       {
		        	    	          	    	  
		        	    	   char c = strLine.charAt(w);		        	    	   
		        	    	   imarray[h][w] = c ;
		        	       }
		             			  			  
			            	   
			  }
              fstream.close();
			  
		  }
		       catch (Exception e)
		       {//Catch exception if any
		  
		         System.err.println("Error: " + e.getMessage());		         
		         
		         System.out.println("Enter a vaild file name. \nOnly Bee, bfly, bird, bird2 are accepted at this time. \nRe-run the program.") ;
		         
		         System.exit(0) ; //the program will exit
		         
		        
		       }
		  
	}

/*
    FUNCTION NAME: doTileJob;
    INPUT:the buffer with the image and the height and width of the
          pattern to be made, and the user's input for tilesAcross, and tilesDown.
    OUTPUT: the patterns structured according to users input.
    PRECONDITIONS: All of the variables are set and pattern is stored in 'buffer'.
    POSTCONDITIONS: Output displayed according to users input.
    CALLERS: the main program
    CALLEES: none
*/
//  This function uses for loops to display the images. The inner most for loop prints one line of the picture.

	static void doTileJob (char [] [] buffer , int tilesDown, int tilesAcross, int imageHeight, int imageWidth)
    {
						
		for (int d = 1; d <= down; d++)	//changes the y-value for the array	
		{
			System.out.println(); //adds a line so it matches user input
			
			for (int h = 0; h <= high; h++) //user defined dimensions for down
			{
				System.out.println() ; //goes to another line for another y axis array number
				
				for (int a = 1; a <= across; a++) //user defined dimensions for across
				{
					for (int w = 0; w <= wide; w++) //changes the x-value for the array
					{
						System.out.print(imarray[h][w]); //prints out one character						
					}
				}
			}
		}
	}	
}
