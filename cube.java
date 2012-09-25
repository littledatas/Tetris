package NetworkTetris;
import java.awt.*;
public class cube extends Block
{	/**The identifier for this piece is 0
**/
	private final int ident=0; 
		/**The Color for this piece
	 **/
	private Color c= new Color(190,0,190);
	/**The Blocks used to make this piece
	 **/
	private Block top,topright,bottomleft,bottomright;
		/**The default starting Location is (2,4)
	 **/
	private Location def=new Location (2,4);
//	private ShadowCube sc;
	/**
	 *Does nothing!
	 **/
	public cube(){}
	/**
	 *adds a cube to the player grid
	 **/
	public cube(Grid g)
	{

		top=new Block(c,g,def,ident);
		topright=new Block(c,g,top.getLoc().getRight(),ident);
		bottomleft=new Block(c,g,top.getLoc().getDown(),ident);
		bottomright=new Block(c,g,topright.getLoc().getDown(),ident);
	//	sc=new ShadowCube(g,this);
		
	}
	/**
	 *adds a cube to the a grid with the specified offsets
	 **/
	public cube(Grid g, int x, int y)
	{
		top=new Block(c,g,def,x,y,ident);
		topright=new Block(c,g,top.getLoc().getRight(),x,y,ident);
		bottomleft=new Block(c,g,top.getLoc().getDown(),x,y,ident);
		bottomright=new Block(c,g,topright.getLoc().getDown(),x,y,ident);
	}
	/**
	 *returns the top-left Block
	 **/
	public Block getTop()
	{
		return top;
	}
	/**
	 *returns the top-right Block
	 **/
	public Block getTopRight()
	{
		return topright;
	}
	/**
	 *returns the bottom-right Block
	 **/
	public Block getBottomRight()
	{
		return bottomright;
	}
	/**
	 *returns the bottom-left Block
	 **/
		public Block getBottomLeft()
	{
		return bottomleft;
	}	
	/**
	 *checks all necessary conditions and moves this cube left
	 **/
	public void moveLeft()
	{	if(topright.isLeftTrue() && bottomright.isLeftTrue()&&bottomleft.isLeftTrue()&&top.isLeftTrue())
		{
		topright.moveLeft();
		bottomright.moveLeft();
		bottomleft.moveLeft();
		top.moveLeft();
	//	sc.moveLoc(top.getLoc());
		}
	}
	/**
	 *checks all necessary conditions and moves this cube right
	 **/
	public void moveRight()
	{
		if(topright.isRightTrue() && bottomright.isRightTrue()&&bottomleft.isRightTrue()&&top.isRightTrue())
		{
		topright.moveRight();
		bottomright.moveRight();
		top.moveRight();
		bottomleft.moveRight();
	//	sc.moveLoc(top.getLoc());
		}
	}
	/**
	 *checks all necessary conditions and moves this cube down and 
	 *if it reaches the bottom, then the cube stops moving
	 **/
	public void softDrop()
	{
		if(topright.isDownTrue() && bottomright.isDownTrue()&&bottomleft.isDownTrue()&&top.isDownTrue())
		{	
		topright.softDrop();
		bottomright.softDrop();
		top.softDrop();
		bottomleft.softDrop();	
		}	
		else 
		{
		topright.stop();
		bottomright.stop();
		top.stop();
		bottomleft.stop();	
		}
	}
	/**
	 *returns if the cube is moving
	 **/
	public boolean getMoving()
	{
		if(top.getMoving())
			return true;
		return false;
	}
	/**
	 *moves the cube as far down as possible and sets the moving to false
	 **/
	public void hardDrop()
	{
		while(getMoving())
			{
				softDrop();
				
			}
	}
	/**
	 *rotates the Cube
	 **/
	public void rotate()
	{
		
	}
}

