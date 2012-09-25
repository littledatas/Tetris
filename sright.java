package NetworkTetris;

import java.awt.*;


public class sright extends Block
{	/**The identifier for this piece is 4
**/
	private final int ident=4;
	/**The Color for this piece
	 **/
	private Color c= new Color(0,190,0);
	/**The Blocks used to make this piece
	 **/
	private Block top,leftmid,rightmid,bottom;
		/**The default starting Location is (0,4)
	 **/
	private Location def=new Location (0,4);
	private int rotation=1;
	private Grid gr;
	private boolean moving=true;
//	private ShadowBlock sb;
			/**
	 *adds a sright to the player grid
	 **/
	public sright(Grid grd)
	{
		top=new Block(c,grd,def,ident);
		leftmid=new Block(c,grd,top.getLoc().getDown(),ident);
		rightmid=new Block(c,grd,leftmid.getLoc().getRight(),ident);
		bottom=new Block(c,grd,rightmid.getLoc().getDown(),ident);
		gr=grd;
	//	sb=new ShadowBlock(grd,this);
	}
			/**
	 *adds a sright to the a grid with the specified offsets
	 **/
	public sright(Grid grd,int x,int y)
	{
		top=new Block(c,grd,def,x,y,ident);
		leftmid=new Block(c,grd,top.getLoc().getDown(),x,y,ident);
		rightmid=new Block(c,grd,leftmid.getLoc().getRight(),x,y,ident);
		bottom=new Block(c,grd,rightmid.getLoc().getDown(),x,y,ident);
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
	 *checks all necessary conditions and moves this sright piece left
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
	 *checks all necessary conditions and moves this sright piece right
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
	 *checks all necessary conditions and moves this sright piece down
	 **/
	public void softDrop()
	{if(bottom.isDownTrue() && top.isDownTrue()&&rightmid.isDownTrue()&&leftmid.isDownTrue())	
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
	 *returns if the sright is moving
	 **/
	public boolean getMoving()
	{
		if(top.getMoving())
			return true;
		return false;
	
	}
			/**
	 *moves the sright as far down as possible and sets the moving to false
	 **/
	public void hardDrop()
	{
		while(getMoving())
			{
				softDrop();
			}
	}
		/**
	 *rotates the sright piece
	 **/
	public void rotate()
	{
		if(getMoving())
		{
			if(rotation%2==0)
			{
				if(leftmid.isUpTrue()&&top.isDownTrue())
			{
				leftmid=new Block(c,gr, leftmid.getLoc(),ident);
				top=new Block(c,gr, leftmid.getLoc().getUp(),ident);
				rightmid=new Block(c,gr, leftmid.getLoc().getRight(),ident);
				bottom = new Block(c,gr, rightmid.getLoc().getDown(),ident);
				rotation++;
			}
			}
			else if(rotation%2==1)
			{  Block test = new Block(c,gr,bottom.getLoc().getLeft(),ident);
				if(bottom.isLeftTrue()&&test.isLeftTrue())
				{
				leftmid=new Block(c,gr, leftmid.getLoc(),ident);
				top=new Block(c,gr, leftmid.getLoc().getRight(),ident);
				rightmid= new Block(c,gr, leftmid.getLoc().getDown(),ident);
				bottom = new Block(c,gr, rightmid.getLoc().getLeft(),ident);
				rotation++;
				}
				else if(bottom.isLeftTrue()&& !leftmid.isLeftTrue() && rightmid.isRightTrue())
				{
					top=new Block(c,gr,rightmid.getLoc().getRight(),ident);
					leftmid=new Block(c,gr,top.getLoc().getLeft(),ident);
					rightmid=new Block(c,gr,leftmid.getLoc().getDown(),ident);
					bottom=new Block(c,gr,rightmid.getLoc().getLeft(),ident);
					rotation++;
				}
			}
		}
	}
}