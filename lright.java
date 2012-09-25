package NetworkTetris;
import java.awt.*;
import java.applet.*;
public class lright extends Block
{	/**The identifier for this piece is 2
**/
	private final int ident=2;
	/**The Color for this piece
	 **/
	private Color c= new Color(190,190,0);
	/**The Blocks used to make this piece
	 **/
	private Block top,mid,bottom,right;
		/**The default starting Location is (2,4)
	 **/
	private Location def=new Location (2,4);
	private int rotation=1;
	private Grid gr;
//	private ShadowBlock sb;
	/**
	 *adds a lright to the player grid
	 **/
	public lright(Grid grd)
	{

		top=new Block(c,grd,def,ident);
		mid=new Block(c,grd,top.getLoc().getDown(),ident);
		bottom=new Block(c,grd,mid.getLoc().getRight(),ident);
		right=new Block(c,grd, bottom.getLoc().getRight(),ident);
		gr=grd;
	//	sb=new ShadowBlock(grd,this);
	}
	/**
	 *adds a lright to the a grid with the specified offsets
	 **/
	public lright(Grid grd,int x,int y)
	{

		top=new Block(c,grd,def,x,y,ident);
		mid=new Block(c,grd,top.getLoc().getDown(),x,y,ident);
		bottom=new Block(c,grd,mid.getLoc().getRight(),x,y,ident);
		right=new Block(c,grd, bottom.getLoc().getRight(),x,y,ident);
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
	 *returns the right block
	 **/
	public Block getRight()
	{
		return right;
	}
	/**
	 *checks all necessary conditions and moves this lright left
	 **/
	public void moveLeft()
	{if(top.isLeftTrue() &&mid.isLeftTrue() &&right.isLeftTrue() && bottom.isLeftTrue())
		{
		top.moveLeft();
		mid.moveLeft();
		bottom.moveLeft();
		right.moveLeft();
		}
	}
	/**
	 *checks all necessary conditions and moves this lright right
	 **/
	public void moveRight()
	{if(top.isRightTrue() &&mid.isRightTrue() &&bottom.isRightTrue() && right.isRightTrue())
	{
		top.moveRight();
		mid.moveRight();
		bottom.moveRight();
		right.moveRight();
	}
	}
	/**
	 *checks all necessary conditions and moves this lright down and 
	 *if it reaches the bottom, then the lright stops moving
	 **/
	public void softDrop()
	{if(bottom.isDownTrue() && top.isDownTrue() &&right.isDownTrue() &&mid.isDownTrue())	
		{
		top.softDrop();
		mid.softDrop();
		bottom.softDrop();
		right.softDrop();
		}
     else
		{
		top.stop();
		mid.stop();
		bottom.stop();
		right.stop();
			
		}
	}
	/**
	 *returns true if the lright is moving
	 **/
	public boolean getMoving()
	{
		if(top.getMoving())
			return true;
		return false;
	}
	/**
	 *moves the lright as far down as possible and sets the moving to false and adds to score
	 **/		
	public void hardDrop()
	{
		while(getMoving())
			{
				softDrop();

			}
	}
	
	/**
	 *rotates the lright clockwise
	 **/
	public void rotate()
	{
		
		if(getMoving())
		{
			if(rotation%4==0)
			{
				if(bottom.isRightTrue()&&bottom.isLeftTrue()&&right.isLeftTrue())
			{	
				bottom=new Block(c,gr,bottom.getLoc(),ident);
				mid=new Block(c,gr,bottom.getLoc().getLeft(),ident);
				right=new Block(c,gr,bottom.getLoc().getRight(),ident);
				top=new Block(c,gr, mid.getLoc().getUp(),ident);
				rotation++;
			}
			}
			else if(rotation%4==1)
			{
				if(bottom.isUpTrue()&&bottom.isDownTrue()&&right.isUpTrue())
			{
				bottom=new Block(c,gr,bottom.getLoc(),ident);
				right=new Block(c,gr,bottom.getLoc().getDown(),ident);
				mid=new Block(c,gr, bottom.getLoc().getUp(),ident);
				top=new Block(c,gr, mid.getLoc().getRight(),ident);
				rotation++;				
			}
			}
			else if(rotation%4==2)
			{
				if(bottom.isLeftTrue()&&bottom.isLeftTrue()&&right.isRightTrue())
			{
				bottom=new Block(c,gr,bottom.getLoc(),ident);
				right=new Block(c,gr,bottom.getLoc().getLeft(),ident);
				mid=new Block(c,gr,bottom.getLoc().getRight(),ident);
				top=new Block(c,gr,mid.getLoc().getDown(),ident);
				rotation++;
			}
				Block test= new Block(c,gr,bottom.getLoc().getRight(),ident);
				Block test2= new Block(c,gr, right.getLoc().getRight(),ident);
				if(!bottom.isLeftTrue()&& bottom.isRightTrue()&& test.isRightTrue() && test2.isRightTrue())
			{
					bottom=new Block(c,gr,bottom.getLoc().getRight(),ident);
					right= new Block(c,gr,bottom.getLoc().getLeft(),ident);
					mid= new Block(c,gr,bottom.getLoc().getRight(),ident);
					top= new Block(c,gr,mid.getLoc().getDown(),ident);
					rotation++;
						
			}
			}
			else if(rotation%4==3)
			{
				if(bottom.isUpTrue()&&bottom.isDownTrue()&&right.isDownTrue())
			{
				bottom=new Block(c,gr,bottom.getLoc(),ident);
				right=new Block(c,gr,bottom.getLoc().getUp(),ident);
				mid=new Block(c,gr,bottom.getLoc().getDown(),ident);
				top=new Block(c,gr,mid.getLoc().getLeft(),ident);
				rotation++;
			}
			}
		}
	}
	
}
