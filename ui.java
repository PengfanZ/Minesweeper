import processing.core.PApplet;

public class ui extends PApplet{
	
	public static void main (String[] args)
	{
		PApplet.main("ui");
	}
	
	private Grid grid;
	
	public void setup()
	{
		grid=new Grid();
		grid.randommizeMines();
		fill(150,150,150);
		for (int i=0; i<15; i++)
		{
			for (int j=0; j<15; j++)
			{
				rect(i*30, j*30, 30, 30);
				
			}
		}
		textAlign(CENTER, CENTER);
	}
	
	public void settings()
	{
		size(15*30,15*30); //the size of the background
	}
	
	public void draw()
	{
		
		if (mousePressed)
		{
			int i=1+mouseX/30;
			int j=1+mouseY/30;
			if (mouseButton == LEFT)
			{
				
				if (grid.isMine(i,j)==true)
				{
					fill(255,0,0);
					rect(0,0,450,450);
				}
				else
				{
					fill(255,255,255);
					rect((i-1)*30, (j-1)*30, 30, 30);
					fill(0,0,0);
					int num = grid.getNumOfSurroundingMines(i, j);
					if(num!=0) 
					{
						text(num,(i-1)*30+15, (j-1)*30+15);
					}
				}
			}
			else
			{
				if (grid.isMine(i,j)==false)
				{
					fill(255,255,0);
					rect(0,0,450,450);
				}
				else
				{
					fill(200, 0, 0);
					rect((i-1)*30, (j-1)*30, 30, 30);
				}
			}

					
		}
		
	}
}
