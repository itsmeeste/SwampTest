import java.util.ArrayList;

public class Compass 
{
	 // The compass will have a direction and this will be stored inside a enum
	private int currentItemIndex;
	public enum Direction
	{
		NORTH,
		EAST,
		SOUTH,
		WEST,
	};
	
	
	public int[] GetNearestLocation(int[][] currentGrid,int playerX,int playerY)
	{
		int near = 100;
		int pos[] = {-1,-1};
		int index = 0;
		
		for(int y = 0; y < 10; y++)
		{
			for(int x = 0; x < 10; x++)
			{
				// That means there is a item there
				if(currentGrid[y][x] > 1)
				{
					//System.out.println("Found item");
					if(Math.abs((playerX - x )) + Math.abs(playerY -y ) < near)
					{
						near = Math.abs((playerX - x )) + Math.abs(playerY - y );
						pos[0] =x;
						pos[1] = y;
						currentItemIndex = index;
						index++;
					}
				}
			}
		}
		
		
		return pos;
		
	}
	public int getCurrentItemIndex()
	{
		return currentItemIndex;
	}
	

}
