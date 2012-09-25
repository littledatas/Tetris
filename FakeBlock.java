package NetworkTetris;
import java.awt.*;
	

public class FakeBlock
{
		/**Data needed to determine the location to paint the FakeBlock
		 **/
		int xoffset,yoffset,row,col;
		/**Size of the block as a FakeBlock
		 **/
		int size=10;
		/**The color of this FakeBlock
		 **/
		Color c=null;
		
		public FakeBlock(Color color,int r,int co)
		{
			xoffset=20;
			yoffset=20;
			c=color;
			row=r;
			col=co;
		} 
		
	/**
	 *Paints this FakeBlock
	 **/
	public void paint(Graphics g)
	{	//change this according to the location
		g.setColor(c);
		g.fillRect(col*size+xoffset,row*size+yoffset,size,size);
		
		g.setColor(lightercolor(c));
		g.fillRect(col*size+xoffset+5,row*size+yoffset+5,size-9,size-9);

		g.setColor(darkercolor(c));
		g.drawRect(col*size+xoffset,row*size+yoffset,size,size);


	}
	/**
	 *Helps to determine other Colors needed to paint this FakeBlock
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
	 *Helps to determine other Colors needed to paint this FakeBlock
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
	
	
}
