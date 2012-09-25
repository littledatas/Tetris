package NetworkTetris;
import java.awt.*;
public class smallt extends Block
{	/**The identifier for this piece is 5
**/
	private final int ident=5;
	/**The Color for this piece
	 **/
	private Color c= new Color(180,180,180);
	/**The Blocks used to make this piece
	 **/
	private Block top,bottomleft,bottommid,bottomright;
		/**The default starting Location is (2,4)
	 **/
	private Location def=new Location (2,4);
	private int rotation=1;
	private Grid gr;
//	private ShadowBlock sb;
			/**
	 *adds a smallt to the player grid
	 **/
	public smallt(Grid grd)
	{
		top=new Block(c,grd,def,ident);
		bottommid=new Block(c,grd,top.getLoc().getDown(),ident);
		bottomleft=new Block(c,grd,bottommid.getLoc().getLeft(),ident);
		bottomright=new Block(c,grd,bottommid.getLoc().getRight(),ident);
		gr=grd;
//		sb=new ShadowBlock(grd,this);
	}
			/**
	 *adds a smallt to the a grid with the specified offsets
	 **/
	public smallt(Grid grd,int x,int y)
	{
		top=new Block(c,grd,def,x,y,ident);
		bottommid=new Block(c,grd,top.getLoc().getDown(),x,y,ident);
		bottomleft=new Block(c,grd,bottommid.getLoc().getLeft(),x,y,ident);
		bottomright=new Block(c,grd,bottommid.getLoc().getRight(),x,y,ident);
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
	 *Returns bottomleft Block
	 **/
	public Block getBottomLeft()
	{
		return bottomleft;
	}
			/**
	 *Returns bottommid Block
	 **/
	public Block getBottomMid()
	{
		return bottommid;
	}
			/**
	 *Returns bottomright Block
	 **/
	public Block getBottomRight()
	{
		return bottomright;
	}
			/**
	 *checks all necessary conditions and moves this smallt piece left
	 **/
	public void moveLeft()
	{if(top.isLeftTrue() && bottomright.isLeftTrue() && bottomleft.isLeftTrue() && bottommid.isLeftTrue())
		{
		top.moveLeft();
		bottomright.moveLeft();
		bottomleft.moveLeft();
		bottommid.moveLeft(	);
		}
	}
				/**
	 *checks all necessary conditions and moves this smallt piece right
	 **/
		public void moveRight()
	{if(top.isRightTrue() && bottomright.isRightTrue() && bottommid.isRightTrue() && bottomleft.isRightTrue())
	{
		top.moveRight();
		bottomright.moveRight();
		bottommid.moveRight();
		bottomleft.moveRight();
	}
	}
				/**
	 *checks all necessary conditions and moves this smallt piece down
	 **/
	public void softDrop()
	{if(bottommid.isDownTrue() && top.isDownTrue() && bottomright.isDownTrue() && bottomleft.isDownTrue())	
		{
		top.softDrop();
		bottomright.softDrop();
		bottommid.softDrop();
		bottomleft.softDrop();
		}
     else
		{
		top.stop();
		bottomleft.stop();
		bottommid.stop();
		bottomright.stop();
			
		}
	}
			/**
	 *returns if the smallt is moving
	 **/
	public boolean getMoving()
	{
		if(top.getMoving())
			return true;
		return false;
	
	}
			/**
	 *moves the smallt as far down as possible and sets the moving to false
	 **/
	public void hardDrop()
	{
		while(getMoving())
			{
				softDrop();				

			}
	}
			/**
	 *rotates the smallt piece
	 **/
	public void rotate()
	{
		if(getMoving())
		{
			if(rotation%4==0)
			{
				if(bottommid.isRightTrue())
			{	
				bottommid=new Block(c,gr,bottommid.getLoc(),ident);
				bottomleft=new Block(c,gr,bottommid.getLoc().getLeft(),ident);
				bottomright=new Block(c,gr,bottommid.getLoc().getRight(),ident);
				top=new Block(c,gr,bottommid.getLoc().getUp(),ident);
				rotation++;
			}
			}
			else if(rotation%4==1)
			{
				if(bottommid.isDownTrue())
			{
				bottommid=new Block(c,gr,bottommid.getLoc(),ident);
				bottomright=new Block(c,gr,bottommid.getLoc().getDown(),ident);
				bottomleft=new Block(c,gr,bottommid.getLoc().getUp(),ident);
				top=new Block(c,gr,bottommid.getLoc().getRight(),ident);
				rotation++;				
			}
			}
			else if(rotation%4==2)
			{
			if(bottommid.isLeftTrue())	
			{
				bottommid=new Block(c,gr,bottommid.getLoc(),ident);
				bottomright=new Block(c,gr,bottommid.getLoc().getLeft(),ident);
				bottomleft=new Block(c,gr,bottommid.getLoc().getRight(),ident);
				top=new Block(c,gr,bottommid.getLoc().getDown(),ident);
				rotation++;
			}
			}
			else if(rotation%4==3)
			{
				if(bottommid.isUpTrue())
			{
				bottommid=new Block(c,gr,bottommid.getLoc(),ident);
				bottomright=new Block(c,gr,bottommid.getLoc().getUp(),ident);
				bottomleft=new Block(c,gr,bottommid.getLoc().getDown(),ident);
				top=new Block(c,gr,bottommid.getLoc().getLeft(),ident);
				rotation++;
			}
			}
		}
	}
}