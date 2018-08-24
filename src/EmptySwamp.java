
public class EmptySwamp extends Swamp
{
	private boolean hasAnimals;
	public EmptySwamp(int x,int y,boolean hasAnimals) 
	{
		super(x,y);
		this.hasAnimals = hasAnimals;
		if(hasAnimals)
		{
			addSayingsToSwamp("There is a pack of wolves looking at you");
		}
		
	}
}
