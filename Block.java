package NetworkTetris;
import java.awt.*;

public class Block
{	
	/**The state of the block either in motion or stopped
	 **/
	private boolean moving = true;
	/**Size is the default size of a block in a grid
	 **/
	int size=20;
	/**The Location of this Block
	 **/
	private Location loc;
	/**Color of this Block
	 **/
	private Color c;
	private Graphics g;
	/**The numeric identifier to show what type of piece this Block is derived from
	 **/
	private int identifier;
	/**Default grid in which the player plays in
	 **/
	Grid gr;
	/**Needs to match coordinates of grid piece is placed in
	 **/
	int xoffset,yoffset;
	/**Does Nothing. Do not use for reasons other than inheritance!
	 **/
	public Block()
	{
		gr=new Grid();
	}
	/**
	 *Use to add Block to a grid other than the player grid.
	 **/
	public Block(Color color, Grid grid, Location l, int xoff, int yoff,int i)
	{
		loc=l;
		c=color;
		gr=grid;
		xoffset=xoff;
		yoffset=yoff;
		identifier=i;
	}
	/**
	 *Use to add Block to player grid only
	 **/
	public Block(Color color, Grid grid, Location l,int i)
	{
		loc=l;
		c=color;
		gr=grid;
		xoffset=300;
		yoffset=40;
		identifier=i;
	}
	/**
	 *Returns the numeric identifier of this Block: identifier
	 **/
	public int getIdent()
	{
		return identifier;
	}
	/**
	 *Use this method from the any of the pieces
	 **/
	public Block getTop()
	{
		return this;
	}
	/**
	 *Sees if this Block is still moving
	 **/
	public boolean getMoving()
	{ 
		return moving;
	}
	/**
	 *Returns Location of this Block
	 **/
	public Location getLoc()
	{
		return loc;
	}
	/**
	 *Paints Block
	 **/
	public void paint(Graphics g)
	{	//change this according to the location
		g.setColor(c);
		g.fillRect(loc.getCol()*20+xoffset,loc.getRow()*20+yoffset,size,size);
		//g.fillRect(loc.xpixel(),loc.ypixel(),size,size);
		g.setColor(lightercolor(c));
		g.fillRect(loc.getCol()*20+xoffset+5,loc.getRow()*20+yoffset+5,size-9,size-9);
		//g.fillRect(loc.xpixel()+5,loc.ypixel()+5,size-9,size-9);
		g.setColor(darkercolor(c));
		g.drawRect(loc.getCol()*20+xoffset,loc.getRow()*20+yoffset,size,size);
		//g.drawRect(loc.xpixel(),loc.ypixel(),size,size);

	}
	/**
	 *Helper method to help create the Color needed to draw this Block with the specified Color
	 **/
		private Color lightercolor(Color c)
	{
		Color next = new Color(c.getRed(),c.getGreen(),c.getBlue());
		if(next.getRed()!=0)
			next = new Color(next.getRed()+50,next.getGreen(),next.getBlue());
		if(next.getGreen()!=0)
			next = new Color(next.getRed(),next.getGreen()+50,next.getBlue());
		if(next.getBlue()!=0)
			next = new Color(next.getRed(),next.getGreen(),next.getBlue()+50);
		return next;
	}
	/**
	 *Helper method to help create the Color needed to draw this Block with the specified Color
	 **/
	private Color darkercolor(Color c)
	{
		Color next = new Color(c.getRed(),c.getGreen(),c.getBlue());
		if(next.getRed()!=0)
			next = new Color(next.getRed()-50,next.getGreen(),next.getBlue());
		if(next.getGreen()!=0)
			next = new Color(next.getRed(),next.getGreen()-50,next.getBlue());
		if(next.getBlue()!=0)
			next = new Color(next.getRed(),next.getGreen(),next.getBlue()-50);
		return next;
	}
	/**
	 *Checks the left bounds of the Block with the Grid and with any filled spots.
	 **/
	public boolean isLeftTrue()
	{ // empty space returns true
	  // parameter is block that you want to add
		Block[][] filled= gr.getGrid();
		if(loc.getCol()-1>=0&&moving&&!(filled[loc.getRow()][loc.getCol()-1] instanceof Block))
			return true;
		return false;
	}
	/**
	 *Checks the right bounds of the Block with the Grid and with any filled spots.
	 **/
	public boolean isRightTrue()
	{
		Block[][] filled= gr.getGrid();
		if(loc.getCol()+1<filled[0].length && moving && !(filled[loc.getRow()][loc.getCol()+1] instanceof Block))
			return true;
		return false;
	}
	/**
	 *Checks the lower bounds of the Block with the Grid and with any filled spots.
	 **/
	public boolean isDownTrue()
	{
		Block[][] filled= gr.getGrid();
		if(loc.getRow()+1<filled.length&& moving&& !(filled[loc.getRow()+1][loc.getCol()] instanceof Block))
			return true;
		return false;
	}
	/**
	 *Checks the upper bounds of the Block with the Grid and with any filled spots.
	 **/
	public boolean isUpTrue()
	{
		Block[][] filled= gr.getGrid();
		if(loc.getRow()-1>=0&&moving&&!(filled[loc.getRow()-1][loc.getCol()] instanceof Block))
			return true;
		return false;
	}

	/**
	 *Changes the Location immediately left
	 **/
	public void moveLeft()
	{ 
		loc=loc.getLeft();
	}
	/**
	 *Method used in inheritance for classes extending this
	 **/
	public void hardDrop()
	{
		//no code
	}
	/**
	 *Method used in inheritance for classes extending this
	 **/
	public void rotate()
	{
		//no code
	}
	/**
	 *Changes the Location immediately right
	 **/
	public void moveRight()
	{ 
		loc=loc.getRight();

	}
	/**
	 *Changes the Location immediately down
	 **/
	public void softDrop()
	{	
		loc=loc.getDown();
		
	}
	/**
	 *Changes moving to false
	 **/
	public void stop()
	{
		moving=false;
	}  	

}