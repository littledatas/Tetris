package NetworkTetris;

import java.awt.*;
import java.applet.*;


public class sleft extends Block
{	/**The identifier for this piece is 3
**/
	private final int ident=3;
	/**The Color for this piece
	 **/
	private Color c= new Color(0,0,200);
	/**The Blocks used to make this piece
	 **/
	private Block top,leftmid,rightmid,bottom;
	/**The default starting Location is (1,5)
	 **/
	private Location def=new Location (1,5);
	private int rotation=1;
	private Grid gr;
//	private ShadowBlock sb;
				/**
	 *adds a sleft to the player grid
	 **/
	public sleft(Grid grd)
	{
		top=new Block(c,grd,def,ident);
		rightmid=new Block(c,grd,top.getLoc().getDown(),ident);
		leftmid=new Block(c,grd,rightmid.getLoc().getLeft(),ident);
		bottom=new Block(c,grd,leftmid.getLoc().getDown(),ident);
		gr=grd;
	//	sb=new ShadowBlock(grd,this);
	}
			/**
	 *adds a sleft to the a grid with the specified offsets
	 **/
	public sleft(Grid grd,int x,int y)
	{
		top=new Block(c,grd,def,x,y,ident);
		rightmid=new Block(c,grd,top.getLoc().getDown(),x,y,ident);
		leftmid=new Block(c,grd,rightmid.getLoc().getLeft(),x,y,ident);
		bottom=new Block(c,grd,leftmid.getLoc().getDown(),x,y,ident);
		gr=grd;
	}
		/**
	 *Returns top Block
	 **/
	public Block getTop()
	{
		return top;
	}
		/**
	 *Returns leftmid Block
	 **/
	public Block getLeftMid()
	{
		return leftmid;
	}
		/**
	 *Returns rightmid Block
	 **/
	public Block getRightMid()
	{
		return rightmid;
	}
		/**
	 *Returns bottom Block
	 **/
	public Block getBottom()
	{
		return bottom;
	}
				/**
	 *checks all necessary conditions and moves this sleft piece left
	 **/
	public void moveLeft()
	{if(top.isLeftTrue() && rightmid.isLeftTrue() &&leftmid.isLeftTrue() && bottom.isLeftTrue())
		{
		top.moveLeft();
		rightmid.moveLeft();
		leftmid.moveLeft();
		bottom.moveLeft();
		}
	}
				/**
	 *checks all necessary conditions and moves this sleft piece right
	 **/
	public void moveRight()
	{if(top.isRightTrue() && rightmid.isRightTrue() && bottom.isRightTrue() && leftmid.isRightTrue())
	{
		top.moveRight();
		rightmid.moveRight();
		bottom.moveRight();
		leftmid.moveRight();
	}
	}
				/**
	 *checks all necessary conditions and moves this sleft piece down
	 **/
	public void softDrop()
	{if(bottom.isDownTrue() && top.isDownTrue() &&rightmid.isDownTrue()&&leftmid.isDownTrue())	
		{
		top.softDrop();
		rightmid.softDrop();
		bottom.softDrop();
		leftmid.softDrop();
		}
     else
		{
		top.stop();
		leftmid.stop();
		bottom.stop();
		rightmid.stop();
			
		}
	}
		/**
	 *returns if the sleft is moving
	 **/
	public boolean getMoving()
	{
		if(top.getMoving())
			return true;
		return false;
	
	}
		/**
	 *moves the sleft as far down as possible and sets the moving to false
	 **/
	public void hardDrop()
	{
		while(getMoving())
			{
				softDrop();

			}
	}
		/**
	 *rotates the sleft piece
	 **/
	public void rotate()
	{
		if(getMoving())
		{
			if(rotation%2==0)
			{
				Block test =new Block(c,gr, top.getLoc().getUp(),ident);
				if(leftmid.isRightTrue()&&test.isUpTrue())
				{
				leftmid= new Block(c,gr, leftmid.getLoc(),ident);
				bottom = new Block(c,gr, leftmid.getLoc().getDown(),ident);
				rightmid = new Block(c,gr, leftmid.getLoc().getRight(),ident);
				top=new Block(c,gr, rightmid.getLoc().getUp(),ident);
				rotation++;
				}
			}
			else if(rotation%2==1)
			{ 	Block test= new Block(c,gr,rightmid.getLoc().getRight().getDown(),ident);
				Block test2= new Block(c,gr,rightmid.getLoc().getRight(),ident);
				if(leftmid.isLeftTrue()&&bottom.isRightTrue())
				{ 
				leftmid= new Block(c,gr, leftmid.getLoc(),ident);
				bottom = new Block(c,gr, leftmid.getLoc().getLeft(),ident);
				rightmid = new Block(c,gr, leftmid.getLoc().getDown(),ident);
				top=new Block(c,gr, rightmid.getLoc().getRight(),ident);
				rotation++;
				}
				else if(!leftmid.isLeftTrue()&&rightmid.isRightTrue()&& test.isRightTrue() && test2.isDownTrue())
				{
					bottom=new Block(c,gr,leftmid.getLoc(),ident);
					leftmid=new Block(c,gr,bottom.getLoc().getRight(),ident);
					rightmid=new Block(c,gr,leftmid.getLoc().getDown(),ident);
					top=new Block(c,gr,rightmid.getLoc().getRight(),ident);
					rotation++;
				}
			}
		}
	}
	
}