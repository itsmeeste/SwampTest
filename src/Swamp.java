import java.util.ArrayList;
import java.util.Random;

public abstract class Swamp 
{
	
	// This should have some base characteristics and sayings
	// Need to create different types of swamps to handle later on
	
	private ArrayList<String> swampSayings = new ArrayList<String>();
	
	private ArrayList<String> swampItems = new ArrayList<String>();
	
	
	private boolean doesSmell;
	private boolean hasRats;
	private int distance;
	
	// So each swamp will have a grid and this will show where the player is and what points of interest there is
	private Grid currentGrid;
	
	public Swamp(int x,int y)
	{
		addSwampSayings();
		addSwampItems();
		currentGrid = new Grid();
		placePlayer(x,y);
		
		// Place a random amount of items in the swamp this will change later with each different swamp that ther is 
		Random r = new Random();
		
		int amount =r.nextInt(swampItems.size()-1) + 1;
		placeItems(amount);
		
		
	}
	private void addSwampSayings()
	{
		// This is where i will add to the swamp random calls that can be picked at some point
		swampSayings.add("Grey foggy clouds float oppressively close to you "
				+ "reflected in the murky grey water which reaches up your shins");
		
		swampSayings.add("Some black plants barely poke out of the shallow water.");
		
	}
	
	private void addSwampItems()
	{
		swampItems.add("Boots");
		swampItems.add("Candle");
		swampItems.add("Big Blue Carrot");
		swampItems.add("dead bird");
		swampItems.add("a random person looking at the floor");
		swampItems.add("a big fish");
	}
	
	protected void addSayingsToSwamp(String saying)
	{
		swampSayings.add(saying);
	}
	
	public String sayRandomThing()
	{
		// Choose a random number between the value 0- swampSaying size
		Random r = new Random();
		return swampSayings.get(r.nextInt(swampSayings.size()));
	}
	
	public String ChanceToSaySomething()
	{
		Random r = new Random();
		int chance = r.nextInt(100);
		
		if(chance < 80)
		{
			// Select a random saying and return it
			return sayRandomThing();
		}
		return "NOTHING HAPPENED";
	}
	public void placePlayer(int x,int y)
	{
		currentGrid.placeGridItem(x, y,1);
	}
	
	private void placeItems(int amount)
	{
		for(int i = 2; i < amount;)
		{
			// Now to pick a random spot on the grid and place the item there
			Random r = new Random();
			int x = r.nextInt(10);
			int y = r.nextInt(10);
			
			// Now the check
			if(currentGrid.placeGridItem(x, y, i))
			{
				i++;
			}
		}
	}
	
	public Grid getGrid()
	{
		return currentGrid;
	}
	public ArrayList<String> getSwampItems()
	{
		return swampItems;
	}
	

}
