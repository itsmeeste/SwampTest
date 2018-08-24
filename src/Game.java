import java.util.Random;
import java.util.Scanner;

// This is going to handle the main game loop
public class Game 
{
	// Set up simple game states that can be used for choosing what stage the game is in
	
	private enum GameStates
	{
		GAMESTART,
		ENTERSWAMP,
		CHOOSEDIRECTION,
		EXIT
	};
	
	private boolean isPlaying;
	private Player player;
	private InputSystem inputSystem;
	private GameStates currentGameState;
	private Compass compass;
	private Swamp swamp;
	
	
	public Game()
	{
		isPlaying = true;
		init();
		gameLoop();
	}
	
	public void init()
	{
		inputSystem = new InputSystem();
		player = new Player(5,5);
		currentGameState = GameStates.GAMESTART;
		compass = new Compass();
		swamp = new BigSwamp(player.getPlayerX(),player.getPlayerY(),true,true,1);
		
	}
	
	public String gameLoop()
	{
		// Start by showing the input commands for the game so the user can then look at the help	
		inputSystem.inputHelpCommands();
		
		
		// This is the game loop for the game and checks to see if isPlaying is true
		while(isPlaying)
		{
			// Set up the game state
			switch(currentGameState.ordinal()) // Gets the current enum state for the game
			{
				case 0:// Game Start
					Random r  = new Random();
					if(r.nextInt(100) >50)
					{
						swamp = new BigSwamp(player.getPlayerX(),player.getPlayerY(),true,true,1);
					}
					else
					{
						swamp = new EmptySwamp(player.getPlayerX(),player.getPlayerY(),true);
					}
					
					// When the game has started it will ask for the player name
					inputSystem.printSystemCalls(InputSystem.printCalls.ASKPLAYERNAME);
					player.setPlayerName(inputSystem.getSystemInput());
					inputSystem.printSystemCalls(InputSystem.printCalls.WELCOMETOGAMEUSER, player.getPlayerName());
					currentGameState = GameStates.ENTERSWAMP;
					
					break;
				case 1: // This is the ENTERSWAMP
					// Need to create a swamps
					inputSystem.randomPrint("ENTERING A NEW SWAMP");
					inputSystem.randomPrint(swamp.sayRandomThing());
					currentGameState = GameStates.CHOOSEDIRECTION;
					break;
				case 2: // This is the choose direction
					
					inputSystem.printSystemCalls(InputSystem.printCalls.CHOOSEDIRECTION);
					String result = inputSystem.getSystemInput();
					
					int x = compass.GetNearestLocation(swamp.getGrid().currentGrid, player.getPlayerX(), player.getPlayerY())[0];
					int y = compass.GetNearestLocation(swamp.getGrid().currentGrid, player.getPlayerX(), player.getPlayerY())[1];
					
					if(!player.setLastDirection(result))
					{
						System.out.println(result);
						// Check commands
						if(result.equals("HELP"))
						{
							inputSystem.inputHelpCommands();
							
						}
						if(result.equals("RESET"))
						{
							currentGameState = GameStates.GAMESTART;
							break;
						}
						if(result.equals("EXIT"))
						{
							currentGameState = GameStates.EXIT;
						}
						if(result.equals("GRID"))
						{
							inputSystem.printGrid(swamp.getGrid());
						}
						
						
						// Showing the compass for the user
						if(result.equals("COMPASS"))
						{
							
							if(x < 0 )
							{
								inputSystem.randomPrint("THERE ISNT ANY ITEMS IN THIS PART OF THE SWAMP");
							}
							else
							{
								inputSystem.printSystemCalls(InputSystem.printCalls.SHOWCOMPASS," X" + x + ",Y"+y );	
							}
							
						}
						else if(result.equals("POSITION"))
						{
							inputSystem.randomPrint("Current Player Position:  X" + player.getPlayerX() + ",Y" + player.getPlayerY());
						}
						
					}
					else
					{
						if(player.isPlayerOutOfBounds())
						{
							// create a new swamp
							player.setPlayerPosition(3, 3);
							swamp = new BigSwamp(3,3,false,false,1);
							currentGameState = GameStates.ENTERSWAMP;
							break;
							
						}
						swamp.getGrid().removeType(1);
						
						if(player.getPlayerX() ==x &&player.getPlayerY() ==	y )
						{
							inputSystem.printSystemCalls(InputSystem.printCalls.FOUNDITEM, 
									swamp.getSwampItems().get(compass.getCurrentItemIndex()));
						}
							
						inputSystem.printSystemCalls(InputSystem.printCalls.PICKEDDIRECTION, player.getLastDirection());
						inputSystem.randomPrint(swamp.ChanceToSaySomething());
						swamp.getGrid().placeGridItem(player.getPlayerX(), player.getPlayerY(), 1);
					}
					// Check to see if the player is outside the currentSwamp and then create a new one
					
					
					break;
				case 3:
					isPlaying = false;
					break;
					
					
					
					
					
			}
			
			
		}
		
		return "Game Finished";
	}
	

	

}
