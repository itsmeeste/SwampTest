import java.util.ArrayList;
import java.util.Scanner;

// This will handle all of the system out calls to the command
public class InputSystem 
{
	public enum printCalls
	{
		ASKPLAYERNAME,
		WELCOMETOGAMEUSER,
		CHOOSEDIRECTION,
		PICKEDDIRECTION,
		SHOWCOMPASS,
		FOUNDITEM,
		
	};
	// The game is going to need a scanner for the input of the player choices
	private	Scanner sc = new Scanner(System.in);
	private ArrayList<String> systemCalls = new ArrayList<String>();
	
	public InputSystem()
	{
		setSystemCalls();
	}
	
	public void setSystemCalls()
	{
		// This is where all of the system call will be stored
		systemCalls.add("Please Enter A Name: ");
		systemCalls.add("WELCOME TO THE GAME ");
		systemCalls.add("WHAT DIRECTION DO YOU WANT TO MOVE");
		systemCalls.add("YOU PICKED ");
		systemCalls.add("SHOWING COMPASS DIRECTION");
		systemCalls.add("YOU FOUND AN ITEM ");
		
		
		// Now to add the calls about when the player moves
		
	}
	
	public void printSystemCalls(printCalls callNum)
	{
		System.out.println(systemCalls.get(callNum.ordinal()));
	}
	public void printSystemCalls(printCalls callNum,String name)
	{
		System.out.println(systemCalls.get(callNum.ordinal()) + name);
	}
	public void randomPrint(String print)
	{
		System.out.println(print);
	}
	public String getSystemInput()
	{
		String input  = sc.next().toUpperCase();
		
		return input;
	}
	
	public void inputHelpCommands()
	{
		randomPrint("HELP COMMANDS");
		randomPrint("SHOW COMPASS TYPE: COMPASS");
		randomPrint("SHOW POSITION TYPE: POSITION");
		randomPrint("RESTART GAME: RESET");
		randomPrint("EXIT GAME: EXIT");
		randomPrint("SHOW GRID (0-EMPTY,1-PLAYER,>1 OTHER ITEMS): GRID");
	}
	
	public void printGrid(Grid grid)
	{
		for(int y = 0; y < 10; ++y)
		{
			for(int x = 0; x < 10; ++x)
			{
				System.out.print(grid.currentGrid[y][x]);
			}
			System.out.println();
		}
	}
	

}
