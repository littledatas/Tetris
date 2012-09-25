package NetworkTetris;
public class Location 
{
	/**The location on the matrix*/
	private int row,col;

	public Location(int r, int c)
	{
		row=r;
		col=c;
	}
	/**
	 *Returns row
	 **/
	public int getRow()
	{
		return row;
	}
	/**
	 *Returns column
	 **/
	public int getCol()
	{
		return col;
	}
	/**
	 *Checks the Location to the left and returns it if it is valid
	 *Otherwise, it returns the original.
	 **/
	public Location getLeft()
	{
		if(checkLeft())
		{
			return new Location(row,col-1);
		}
		return this;
	}
	/**Checks the Location to the right and returns it if it is valid
	 *Otherwise, it returns the original.
	 **/
	public Location getRight()
	{
		if(checkRight())
		{
			return new Location(row,col+1);
		}
		return this;
	}
	/**Checks the Location below and returns it if it is valid
	 *Otherwise, it returns the original.
	 **/
	public Location getDown()
	{
		if(checkDown())
		{
			return new Location(row+1,col);
		}
		return this;
	}
	 /**Checks the Location above and returns it if it is valid
	 *Otherwise, it returns the original.
	 **/
	public Location getUp()
	{
		if(checkUp())
			return new Location(row-1,col);
		return this;
	}
	/**
	 *Helper method to check validity of above Location
	 **/
	public boolean checkUp()
	{
		if(row-1>=0)
			return true;
		return false;
	}
	/**
	 *Helper method to check validity of a Location to the left
	 **/
	public boolean checkLeft()
	{
		if(col-1>=0)
			return true;
		return false;
	}
		/**
	 *Helper method to check validity of a Location to the right
	 **/
	public boolean checkRight()
	{
		if(col+1<=9)
			return true;
		return false;
	}
		/**
	 *Helper method to check validity of below Location
	 **/
	public boolean checkDown()
	{
		if(row+1<=22)
			return true;
		return false;
			
	}
	
}