import java.util.ArrayList;

public class Grid 
{
	private final int sizeX = 10;
	private final int sizeY = 10;
	
	
	int[][] currentGrid = new int[10][10];
	
	public Grid()
	{
		init();
	}
	
	private void init()
	{
		for(int y = 0; y < sizeY; ++y)
		{
			for(int x =0; x < sizeX; ++x)
			{
				currentGrid[y][x] = 0;
			}
		}
	}
	
	public boolean placeGridItem(int x,int y,int value)
	{
		boolean placed = true;
		if(x > 9 || x < 0)
		{
			placed = false;
			return placed;
		}
		if(y > 9 || y < 0)
		{
			placed  = false;
			return placed;
		}
		
		// Check to see that the current grid place is empty
		if(currentGrid[y][x] == 0)
		{
			//System.out.println("Place item " + x + "    " + y + "value  " + value);
			currentGrid[y][x] = value;
		}
		else
		{
			placed = false;
		}
		return placed;
			
	}
	public void removeType(int id)
	{
		for(int y = 0; y < sizeY; ++y)
		{
			for(int x =0; x < sizeX; ++x)
			{
				if(currentGrid[y][x] == id)
				{
					currentGrid[y][x] = 0;
				}
			}
		}
	}
	
}
