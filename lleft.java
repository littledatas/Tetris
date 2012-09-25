package NetworkTetris;

import java.awt.*;
import java.applet.*;




public class lleft extends Block
{	/**The identifier for this piece is 6
**/
	private final int ident=6;
	/**The Color for this piece
	 **/
	private Color c= new Color(190,0,0);
	/**The Blocks used to make this piece
	 **/
	private Block top,mid,bottom,left;
		/**The default starting Location is (2,5)
	 **/
	private Location def=new Location (2,5);
	private int rotation=1;
	private boolean moving;
	private Grid gr;
//	private ShadowBlock sb;
	/**
	 *adds a lleft to the player grid
	 **/
	public lleft(Grid grd)
	{

		top=new Block(c,grd,def,ident);
		mid=new Block(c,grd,top.getLoc().getDown(),ident);
		bottom=new Block(c,grd,mid.getLoc().getLeft(),ident);
		left=new Block(c,grd, bottom.getLoc().getLeft(),ident);
		gr=grd;
	//	sb=new ShadowBlock(grd,this);
	}
	/**
	 *adds a lleft to the a grid with the specified offsets
	 **/
	public lleft(Grid grd,int x,int y)
	{

		top=new Block(c,grd,def,x,y,ident);
		mid=new Block(c,grd,top.getLoc().getDown(),x,y,ident);
		bottom=new Block(c,grd,mid.getLoc().getLeft(),x,y,ident);
		left=new Block(c,grd, bottom.getLoc().getLeft(),x,y,ident);
		gr=grd;
	}
	
	/**
	 *returns the top block
	 **/
	public Block getTop()
	{
		return top;
	}
	/**
	 *returns the middle block
	 **/
	public Block getMid()
	{
		return mid;
	}
	/**
	 *returns the bottom block
	 **/
	public Block getBottom()
	{
		return bottom;
	}
	/**
	 *returns the left block
	 **/
	public Block getLeft()
	{
		return left;
	}
	/**
	 *checks all necessary conditions and moves this lleft left
	 **/
	public void moveLeft()
	{ if(top.isLeftTrue() && mid.isLeftTrue()&& bottom.isLeftTrue()&& left.isLeftTrue())
		{
		top.moveLeft();
		mid.moveLeft();
		bottom.moveLeft();
		left.moveLeft();
		}
		
	}
	/**
	 *checks all necessary conditions and moves this lleft right
	 **/
	public void moveRight()
	{	if(top.isRightTrue()&&mid.isRightTrue()&&bottom.isRightTrue() && left.isRightTrue())
		{
		top.moveRight();
		mid.moveRight();
		bottom.moveRight();
		left.moveRight();
		}
	}
	/**
	 *checks all necessary conditions and moves this lleft down and 
	 *if it reaches the bottom, then the cube stops moving
	 **/
	public void softDrop()
	{if(bottom.isDownTrue()&&left.isDownTrue()&& mid.isDownTrue()&&top.isDownTrue())	
		{
		top.softDrop();
		mid.softDrop();
		bottom.softDrop();
		left.softDrop();
		}
	else
		{
		top.stop();
		mid.stop();
		bottom.stop();
		left.stop();
			
		}
	}
	/**
	 *returns if the lleft is moving
	 **/
	public boolean getMoving()
	{
		if(top.getMoving())
			return true;
		return false;
	}
	/**
	 *moves the lleft as far down as possible and sets the moving to false and adds to score
	 **/
	public void hardDrop()
	{
		while(getMoving())
			{
				softDrop();
			//	Tetris.score+=(22-Tetris.current.getTop().getLoc().getRow())*2*Tetris.level;
			}
	}
	/**
	 *rotates the lleft clockwise
	 **/
	public void rotate()
	{
		
		if(getMoving())
		{
			if(rotation%4==0)
			{   
				if(bottom.isRightTrue()&&bottom.isLeftTrue()&&mid.isRightTrue())
			{	
				bottom=new Block(c,gr,bottom.getLoc(),ident);
				mid=new Block(c,gr,bottom.getLoc().getRight(),ident);
				left=new Block(c,gr,bottom.getLoc().getLeft(),ident);
				top=new Block(c,gr, mid.getLoc().getUp(),ident);
				rotation++;
			}
			}
			else if(rotation%4==1)
			{ 
				if(bottom.isUpTrue()&&bottom.isDownTrue()&&mid.isDownTrue())
			{
				bottom=new Block(c,gr,bottom.getLoc(),ident);
				left=new Block(c,gr, bottom.getLoc().getUp(),ident);
				mid=new Block(c,gr, bottom.getLoc().getDown(),ident);
				top=new Block(c,gr, mid.getLoc().getRight(),ident);
				rotation++;				
			}
			}
			else if(rotation%4==2)
			{ 
				if(bottom.isLeftTrue()&&bottom.isRightTrue()&&mid.isLeftTrue())
			{
				bottom=new Block(c,gr,bottom.getLoc(),ident);
				left=new Block(c,gr,bottom.getLoc().getRight(),ident);
				mid=new Block(c,gr,bottom.getLoc().getLeft(),ident);
				top=new Block(c,gr,mid.getLoc().getDown(),ident);
				rotation++;
			}
				else if(!bottom.isLeftTrue()&&!mid.isLeftTrue()&&bottom.isRightTrue())
				{
					bottom= new Block(c,gr,bottom.getLoc().getRight(),ident);
					left= new Block(c,gr,bottom.getLoc().getRight(),ident);
					mid= new Block(c,gr,bottom.getLoc().getLeft(),ident);
					top= new Block(c,gr,mid.getLoc().getDown(),ident);
					rotation++;
				}
			}
			else if(rotation%4==3)
			{
				if(bottom.isDownTrue()&&bottom.isUpTrue()&&mid.isUpTrue())
			{
				bottom=new Block(c,gr,bottom.getLoc(),ident);
				left=new Block(c,gr,bottom.getLoc().getDown(),ident);
				mid=new Block(c,gr,bottom.getLoc().getUp(),ident);
				top=new Block(c,gr,mid.getLoc().getLeft(),ident);
				rotation++;
			}
			}
		}
	}
	
}
