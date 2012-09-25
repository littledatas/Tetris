package NetworkTetris;
import java.awt.*;
/**
 *Not yet implemented
 **/
class ComingGrid extends Grid 
{
	/**
	 *array to hold the pieces
	 **/
	Block [][] locs;
	
	/**
	 *Initializes this Grid to 15 rows and 4 columns
	 **/
	public ComingGrid()
	{
		locs=new Block[15][4];
	}
	/**
	 *Paints Blocks and this Grid object
	 **/
	public void paint(Graphics g)
	{
		paintGrid(g);
		paintArray(g);
	}
	/**
	 *Pains this coming grid
	 **/
	private void paintGrid(Graphics g)
	{
		g.setColor(Color.BLACK);
		for(int r=0; r<15; r++)
			for(int c=0; c<4; c++)
			{
				g.drawRect(100+20*c,100+20*r,20,20);
			}	
	}
	private void paintArray(Graphics g)
	{	
		for(int r=0; r<7; r++)
			for(int c=0; c<7; c++)
			{
				if(locs[r][c] instanceof Block)
				{
					locs[r][c].paint(g);
				}
					
			}
	}
	/**
	 *adds the straight piece to this grid
	 **/
	public void add(straight s)
	{	
		locs[s.getTop().getLoc().getRow()][s.getTop().getLoc().getCol()]=s.getTop();
		locs[s.getTopMid().getLoc().getRow()][s.getTopMid().getLoc().getCol()]=s.getTopMid();
		locs[s.getBottom().getLoc().getRow()][s.getBottom().getLoc().getCol()]=s.getBottom();
		locs[s.getBottomMid().getLoc().getRow()][s.getBottomMid().getLoc().getCol()]=s.getBottomMid();
	}
	/**
	 *deletes the straight piece in this grid
	 **/
	public void nullify(straight s)
	{
		locs[s.getTop().getLoc().getRow()][s.getTop().getLoc().getCol()]=null;
		locs[s.getTopMid().getLoc().getRow()][s.getTopMid().getLoc().getCol()]=null;
		locs[s.getBottom().getLoc().getRow()][s.getBottom().getLoc().getCol()]=null;
		locs[s.getBottomMid().getLoc().getRow()][s.getBottomMid().getLoc().getCol()]=null;
	}
	/**
	 *adds the smallt piece to this grid
	 **/
	public void add(smallt s)
	{
		locs[s.getTop().getLoc().getRow()][s.getTop().getLoc().getCol()]=s.getTop();
		locs[s.getBottomRight().getLoc().getRow()][s.getBottomRight().getLoc().getCol()]=s.getBottomRight();
		locs[s.getBottomLeft().getLoc().getRow()][s.getBottomLeft().getLoc().getCol()]=s.getBottomLeft();
		locs[s.getBottomMid().getLoc().getRow()][s.getBottomMid().getLoc().getCol()]=s.getBottomMid();
	}
	/**
	 *deletes the smallt piece in this grid
	 **/
	public void nullify(smallt s)
	{
		locs[s.getTop().getLoc().getRow()][s.getTop().getLoc().getCol()]=null;
		locs[s.getBottomRight().getLoc().getRow()][s.getBottomRight().getLoc().getCol()]=null;
		locs[s.getBottomLeft().getLoc().getRow()][s.getBottomLeft().getLoc().getCol()]=null;
		locs[s.getBottomMid().getLoc().getRow()][s.getBottomMid().getLoc().getCol()]=null;
	}
	/**
	 *adds the sright piece to this grid
	 **/
	public void add(sright sr)
	{
		locs[sr.getTop().getLoc().getRow()][sr.getTop().getLoc().getCol()]=sr.getTop();
		locs[sr.getRightMid().getLoc().getRow()][sr.getRightMid().getLoc().getCol()]=sr.getRightMid();
		locs[sr.getLeftMid().getLoc().getRow()][sr.getLeftMid().getLoc().getCol()]=sr.getLeftMid();
		locs[sr.getBottom().getLoc().getRow()][sr.getBottom().getLoc().getCol()]=sr.getBottom();
	}
	/**
	 *deletes the sright piece in this grid
	 **/
	public void nullify(sright sr)
	{
		locs[sr.getTop().getLoc().getRow()][sr.getTop().getLoc().getCol()]=null;
		locs[sr.getRightMid().getLoc().getRow()][sr.getRightMid().getLoc().getCol()]=null;
		locs[sr.getLeftMid().getLoc().getRow()][sr.getLeftMid().getLoc().getCol()]=null;
		locs[sr.getBottom().getLoc().getRow()][sr.getBottom().getLoc().getCol()]=null;
	}
	/**
	 *adds the sleft piece to this grid
	 **/
	public void add(sleft sl)
	{
		locs[sl.getTop().getLoc().getRow()][sl.getTop().getLoc().getCol()]=sl.getTop();
		locs[sl.getRightMid().getLoc().getRow()][sl.getRightMid().getLoc().getCol()]=sl.getRightMid();
		locs[sl.getLeftMid().getLoc().getRow()][sl.getLeftMid().getLoc().getCol()]=sl.getLeftMid();
		locs[sl.getBottom().getLoc().getRow()][sl.getBottom().getLoc().getCol()]=sl.getBottom();
	}
	/**
	 *deletes the sleft piece in this grid
	 **/
	public void nullify(sleft sl)
	{
		locs[sl.getTop().getLoc().getRow()][sl.getTop().getLoc().getCol()]=null;
		locs[sl.getRightMid().getLoc().getRow()][sl.getRightMid().getLoc().getCol()]=null;
		locs[sl.getLeftMid().getLoc().getRow()][sl.getLeftMid().getLoc().getCol()]=null;
		locs[sl.getBottom().getLoc().getRow()][sl.getBottom().getLoc().getCol()]=null;
	}
	/**
	 *adds the lright piece to this grid
	 **/
	public void add(lright lr)
	{
		locs[lr.getTop().getLoc().getRow()][lr.getTop().getLoc().getCol()]=lr.getTop();
		locs[lr.getMid().getLoc().getRow()][lr.getMid().getLoc().getCol()]=lr.getMid();
		locs[lr.getRight().getLoc().getRow()][lr.getRight().getLoc().getCol()]=lr.getRight();
		locs[lr.getBottom().getLoc().getRow()][lr.getBottom().getLoc().getCol()]=lr.getBottom();
	}
	/**
	 *deletes the straight piece in this grid
	 **/
	public void nullify(lright ll)
	{
		locs[ll.getTop().getLoc().getRow()][ll.getTop().getLoc().getCol()]=null;
		locs[ll.getMid().getLoc().getRow()][ll.getMid().getLoc().getCol()]=null;
		locs[ll.getRight().getLoc().getRow()][ll.getRight().getLoc().getCol()]=null;
		locs[ll.getBottom().getLoc().getRow()][ll.getBottom().getLoc().getCol()]=null;
	}
		/**
	 *adds the lleft piece to this grid
	 **/		
	public void add(lleft ll)
	{
		locs[ll.getTop().getLoc().getRow()][ll.getTop().getLoc().getCol()]=ll.getTop();
		locs[ll.getMid().getLoc().getRow()][ll.getMid().getLoc().getCol()]=ll.getMid();
		locs[ll.getLeft().getLoc().getRow()][ll.getLeft().getLoc().getCol()]=ll.getLeft();
		locs[ll.getBottom().getLoc().getRow()][ll.getBottom().getLoc().getCol()]=ll.getBottom();
	}
	/**
	 *deletes the lleft piece in this grid
	 **/
	public void nullify(lleft ll)
	{
		locs[ll.getTop().getLoc().getRow()][ll.getTop().getLoc().getCol()]=null;
		locs[ll.getMid().getLoc().getRow()][ll.getMid().getLoc().getCol()]=null;
		locs[ll.getLeft().getLoc().getRow()][ll.getLeft().getLoc().getCol()]=null;
		locs[ll.getBottom().getLoc().getRow()][ll.getBottom().getLoc().getCol()]=null;
		
	}
		/**
	 *adds the cube piece to this grid
	 **/
	public void add(cube c)
	{
		locs[c.getTop().getLoc().getRow()][c.getTop().getLoc().getCol()]=c.getTop();
		locs[c.getTopRight().getLoc().getRow()][c.getTopRight().getLoc().getCol()]=c.getTopRight();
		locs[c.getBottomLeft().getLoc().getRow()][c.getBottomLeft().getLoc().getCol()]=c.getBottomLeft();
		locs[c.getBottomRight().getLoc().getRow()][c.getBottomRight().getLoc().getCol()]=c.getBottomRight();
	}
	/**
	 *deletes the cube piece in this grid
	 **/
	public void nullify(cube c)
	{
		locs[c.getTop().getLoc().getRow()][c.getTop().getLoc().getCol()]=null;
		locs[c.getTopRight().getLoc().getRow()][c.getTopRight().getLoc().getCol()]=null;
		locs[c.getBottomLeft().getLoc().getRow()][c.getBottomLeft().getLoc().getCol()]=null;
		locs[c.getBottomRight().getLoc().getRow()][c.getBottomRight().getLoc().getCol()]=null;
		
	}
	
}
