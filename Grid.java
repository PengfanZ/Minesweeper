
public class Grid {
	private boolean [][] mineMap; //true represents hasmine; false represents nomine
	private int numOfMines=40; //there are forty mines
	
	public Grid()
	{
		mineMap=new boolean [17][17];
	}
	
	public void randommizeMines()
	{
		int count=0;
		for (int i=0; i<16; i++)
		{
			for (int j=0; j<16; j++)
			{
				mineMap[i][j]=false;
			}
		}
		
		while (count<numOfMines)
		{
			int x= (int) (Math.random()*15+1);
			int y= (int) (Math.random()*15+1);
			if (mineMap[x][y]==false)
			{
				mineMap[x][y]=true;
				count++;
			}
		}
	}
	
	public boolean isMine(int i, int j)
	{
		return mineMap[i][j];
	}
	
	public int getNumOfSurroundingMines(int i, int j) 
	{
		int count = 0;
		for (int x=i-1; x<i+2; x++)
		{
			for (int y=j-1; y<j+2; y++)
			{
				if (isMine(x, y))
				{
					count++;
				}
			}
		}
		return count;
	}
}
