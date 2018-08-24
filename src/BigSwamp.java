
public class BigSwamp extends Swamp{

	
	private boolean doesSmell;
	private boolean hasRats;
	public BigSwamp(int x,int y,boolean doesSmell, boolean hasRats,int distance) 
	{
		super(x,y);
		this.doesSmell = doesSmell;
		this.hasRats = hasRats;
		// Check to see if there was rats on the swamp so can add sayings about it
		if(doesSmell)
		{
			addSayingsToSwamp("There is a foul stink coming from the swamp");
		}
		if(hasRats)
		{
			addSayingsToSwamp("a group of rats have appeared in the near distance");
			
		}
		
	}

}
