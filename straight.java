package NetworkTetris;

import java.awt.*;
import java.applet.*;


public class straight extends Block
{	/**The identifier for this piece is 1
**/
	private final int ident=1;
	/**The Color for this piece
	 **/
	private Color c= new Color(0,190,190);
	/**The Blocks used to make this piece
	 **/
	private Block top,topmid,bottommid,bottom;
		/**The default starting Location is (0,4)
	 **/
	private Location def=new Location (0,4);
	boolean horz,vert=true;
	private int rotation=1;
	private Grid gr;
//	private ShadowStraight ss;
			/**
	 *Does nothing!
	 **/
	public straight(){}	
			/**
	 *adds a straight to the player grid
	 **/
	public straight(Grid grd)
	{
		top=new Block(c,grd,def,ident);
		topmid=new Block(c,grd,top.getLoc().getDown(),ident);
		bottommid=new Block(c,grd,topmid.getLoc().getDown(),ident);
		bottom=new Block(c,grd,bottommid.getLoc().getDown(),ident);
		gr=grd;
//		ss=new ShadowStraight(grd,this,rotation);
	}
		/**
	 *adds a straight to the a grid with the specified offsets
	 **/
	public straight(Grid grd,int x,int y)
	{
		top=new Block(c,grd,def,x,y,ident);
		topmid=new Block(c,grd,top.getLoc().getDown(),x,y,ident);
		bottommid=new Block(c,grd,topmid.getLoc().getDown(),x,y,ident);
		bottom=new Block(c,grd,bottommid.getLoc().getDown(),x,y,ident);
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
	 *Returns topmid Block
	 **/
	public Block getTopMid()
	{
		return topmid;
	}	
	/**
	 *Returns bottommid Block
	 **/
	public Block getBottomMid()
	{
		return bottommid;
	}
	/**
	 *Returns bottom Block
	 **/
	public Block getBottom()
	{
		return bottom;
	}
		/**
	 *checks all necessary conditions and moves this straight piece left
	 **/
	public void moveLeft()
	{if(top.isLeftTrue()&&top.isLeftTrue() &&topmid.isLeftTrue() &&bottommid.isLeftTrue() && bottom.isLeftTrue())
		{
		top.moveLeft();
		topmid.moveLeft();
		bottommid.moveLeft();
		bottom.moveLeft();
	//	ss.moveLoc(top.getLoc());
		}
	}
			/**
	 *checks all necessary conditions and moves this straight piece right
	 **/
	public void moveRight()
	{if(top.isRightTrue()&&top.isRightTrue() &&topmid.isRightTrue() &&bottommid.isRightTrue() && bottom.isRightTrue())	
		{
		top.moveRight();
		topmid.moveRight();
		bottommid.moveRight();
		bottom.moveRight();
	//	ss.moveLoc(top.getLoc());
		}
	}
			/**
	 *checks all necessary conditions and moves this straight piece down
	 **/
	public void softDrop()
	{
		if(getMoving()&&bottom.isDownTrue()&&bottommid.isDownTrue()&&topmid.isDownTrue()&&top.isDownTrue())
		{
		top.softDrop();
		topmid.softDrop();
		bottommid.softDrop();
		bottom.softDrop();
		}
	else
		{
		top.stop();
		topmid.stop();
		bottommid.stop();
		bottom.stop();
		
		}
	}
	/**
	 *returns if the straight is moving
	 **/
	public boolean getMoving()
	{
		if(top.getMoving())
			return true;
		return false;
	}
		/**
	 *rotates the straight piece
	 **/
	public void rotate()
	{	if(getMoving())
		{
			if(rotation%2==1)
				{

				if(horzCheck())
					{
					top=new Block(c,gr,topmid.getLoc(),ident);
					topmid=new Block(c,gr,top.getLoc().getLeft(),ident);
					bottommid=new Block(c,gr,topmid.getLoc().getLeft(),ident);
					bottom=new Block(c,gr,top.getLoc().getRight(),ident);
					rotation++;
				//	ss.rotate();
					}
			}
			else if(rotation%2==0)
			{ 
				if(vertCheck())
					{
					top=new Block(c,gr, topmid.getLoc().getUp().getRight(),ident);
					topmid=new Block(c,gr,top.getLoc().getDown(),ident);
					bottommid=new Block(c,gr,topmid.getLoc().getDown(),ident);
					bottom=new Block(c,gr,bottommid.getLoc().getDown(),ident);
					rotation++;
				//	ss.rotate();
					}
			}
				
			
		}
	}
		/**
	 *moves the straight as far down as possible and sets the moving to false
	 **/
	public void hardDrop()
	{
		while(getMoving())
		{
			softDrop();

		}
	}
	/**
	 *Helper method to check the validity of a horizontal straight piece in the grid
	 **/
	private boolean horzCheck()
	{ Block test = new Block(new Color(0,0,0),gr,top.getLoc().getLeft(),ident);
		if((top.isLeftTrue()&&test.isLeftTrue())&& top.isRightTrue())
			horz=true;
		else
			horz=false;
		return horz;
	}
		/**
	 *Helper method to check the validity of a vertical straight piece in the grid
	 **/
	private boolean vertCheck()
	{   Block test =new Block(c,gr, bottom.getLoc().getUp(),ident);
		if(bottom.isDownTrue()&&bottom.isUpTrue()&&test.isUpTrue())
			vert=true;
		else 
			vert=false;
		return vert;
	}
}
