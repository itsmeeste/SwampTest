
public class Player 
{
	// Need some stuff to put about the player 
	/* Maybe the distance that the player base gone
	 * how many points of interest they have been to
	 * what is there name
	 * if they found anything on the floor
	 * */

	private String playerName;
	private Compass.Direction lastDirection;
	private int posX;
	private int posY;
	public Player(int x,int y)
	{
		this.posX =x;
		this.posY = y;
		this.lastDirection = Compass.Direction.NORTH;
	}

	public String getPlayerName() 
	{
		return playerName;
	}
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	public String getLastDirection()
	{
		return lastDirection.name();
	}

	public boolean setLastDirection(String direction) 
	{
		boolean correctDirection = true;
		if(direction.equals("NORTH"))
		{
			posY++;
			this.lastDirection = Compass.Direction.NORTH;
		}
		else if(direction.equals("EAST"))
		{
			posX++;
			this.lastDirection = Compass.Direction.EAST;
		}
		else if(direction.equals("SOUTH"))
		{
			posY--;
			this.lastDirection = Compass.Direction.SOUTH;
		}
		else if(direction.equals("WEST"))
		{
			posX--;
			this.lastDirection = Compass.Direction.WEST;
		}
		else
		{
			correctDirection = false;
		}
		return correctDirection;
		
	}
	public void setPlayerPosition(int x,int y)
	{
		posX = x;
		posY = y;
	}
	public int getPlayerX()
	{
		return posX;
	}
	public int getPlayerY()
	{
		return posY;
	}
	public boolean isPlayerOutOfBounds()
	{
		if((posX > 9 || posX < 0) || (posY > 9 || posY < 0))
		{
			return true;
		}
		return false;
	}
	

}
