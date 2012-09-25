package NetworkTetris;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*; 
import javax.sound.sampled.*;


public class Tetris extends JPanel implements ActionListener, KeyListener
{
	/**The frame component in which the game is played
	 **/
	public static JFrame frame;
	/**The grid component in which the game is played
	 **/
	public static Grid gr;
	/**The specialized grid component in which the player can hold a piece
	 **/
	public static HoldingGrid hg;
	/**Determines which action should be activated
	 **/
	static boolean up,down,left,right,space,added,supermode,lose;
	/**Helps to calculate the extra point bonuses due to multiple Tetrises
	 **/
	private static double Tbonus=1;
	/**The current piece that is being controlled by the user
	 **/
	static Block current;
	/**The holding piece that is currently in holding grid
	 **/
	static Block holding;
	/**Keeps track of the level of the game
	 **/
	public static int level=1;
	/**Keeps track of the player score
	 **/
	public static int score;
	/**The Timer object used to control the automatic moving of the current piece
	 **/
	javax.swing.Timer time;
	/**The Timer object used to control the frequency of kepyboard inputs that are processed
	 **/
	javax.swing.Timer timeuser;
	/**The Timer object used to control the amount of time that Super Mode lasts
	 **/
	static javax.swing.Timer supermodetime;
	/**The offset of the holding grid
	 **/
	private final static int holdingx=100;
	/**The offset of the holding grid
	 **/
	 private final static int holdingy=100;
	/**The number of lines passed and resets at the beginning of each level
	 **/
	private static int lines=0;
	//private boolean bg=true;
	public static void main(String []args) throws Exception
	{
		new Tetris();
	}
	public Tetris()
	{	  score=0;	
		  up=down=left=right=space=false;
          frame = new JFrame("Tetris"); 
          frame.setSize(800, 650); 
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.add(this);
          gr=new Grid();
          hg=new HoldingGrid();
          frame.setVisible(true); 
  		  frame.addKeyListener(this);
		  addToGrid();
		 // System.out.println("RUNNING");
		  timeuser=new javax.swing.Timer(90,this);
		  time=new javax.swing.Timer(1000, new TetrisListener());
		  supermodetime=new javax.swing.Timer(30000, new SuperModeListener());
		  supermodetime.setRepeats(false);
		  time.setInitialDelay(3000);
		  timeuser.setInitialDelay(3000);
		  time.start();
		  timeuser.start();
		  new OutConverterManager(gr).run();
		 // System.out.println("RUNNING");
		 try
{
	File file = new File("2PM-Tetris.wav");
	AudioInputStream stream = AudioSystem.getAudioInputStream(file);
	Clip music = AudioSystem.getClip();
	
	//music.open(stream);
	//music.loop(Clip.LOOP_CONTINUOUSLY);
	//music.start();
}
catch (Exception e) {}
	}

	/**
	 *Paints the frame and all necessary objects
	 **/
	public void paint(Graphics g)
	{
		if(supermode)
			g.setColor(new Color(68,69,63,150));
		else 
			g.setColor(new Color(68,69,63));
       	g.fillRect(0,0,800,600);
		gr.paint(g);
		hg.paint(g);
		paintLevel(g);
		paintScore(g);
		if(lose)
			loseGame(g);
		
	}
	/**
	 *Paints the score
	 **/
	private void paintScore(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif",Font.BOLD,24));
		g.drawString(""+score,604,125);
		g.setFont(new Font("SansSerif",Font.BOLD,16));
		g.drawString("Score:",535,110);
	}
	/**
	 *Paints the level
	 **/
	private void paintLevel(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.setFont(new Font("SansSerif",Font.BOLD,36));
		g.drawString(""+level,600,75);
		g.setFont(new Font("SansSerif",Font.BOLD,16));
		g.drawString("Level:",537,55);
	}
	/**
	 *Stops the game and informs the player that the game has been lost
	 **/
	private void loseGame(Graphics g)
	{
	
				time.stop();
				timeuser.stop();
				g.setColor(Color.RED);
				g.setFont(new Font("SansSerif",Font.BOLD,36));
				g.drawString("YOU LOSE",250,250);
			
		
	}
	/**
	 *Determines which piece needs to be added to the player grid and then adds it
	 **/
	private static void addToGrid()
	{
		int x=((int)((Math.random())*7));
		if(x==0)
		{
			current = new cube(gr);
			gr.add((cube)current);
		}
		else if(x==1)
		{
			current=new straight(gr);
			gr.add((straight)current);

		}
		else if(x==2)
		{
			current=new lright(gr);
			gr.add((lright)current);
		}
		else if(x==3)
		{
			current= new sleft(gr);
			gr.add((sleft)current);
		}
		else if(x==4)
		{
			current=new sright(gr);
			gr.add((sright)current);
		}
		else if(x==5)
		{
			current=new smallt(gr);
			gr.add((smallt)current);
		}
		else if(x==6)
		{
			current = new lleft(gr);
			gr.add((lleft)current);
		}
	}
	/**
	 *Pauses the game
	 **/
	private void pause()
	{
		//System.out.println("paused");
		timeuser.stop();
		time.stop();
	}
	/**
	 *Unpauses the game
	 **/
	private void unpause()
	{	//System.out.println("unpaused");
		timeuser.setInitialDelay(0);
		time.setInitialDelay(0);
		timeuser.start();
		time.start();
	}
	/**
	 *Determines level, adds points to the score,finds the new position 
	 *adjusted for user input of the current piece, and adds a piece if necessary
	 **/	
	public void actionPerformed(ActionEvent e)
	{

	   	if(lines>=10)
			{
				level++;
				time.setInitialDelay(0);
				time.setDelay(6*time.getDelay()/8);
				lines=0;
			}
	{	
	if(current instanceof cube)
		gr.nullify((cube)current);
	if(current instanceof lleft)
		gr.nullify((lleft)current);
	if(current instanceof lright)
		gr.nullify((lright)current);
	if(current instanceof sleft)
		gr.nullify((sleft)current);
	if(current instanceof sright)
		gr.nullify((sright)current);
	if(current instanceof smallt)
		gr.nullify((smallt)current);
	if(current instanceof straight)
		gr.nullify((straight)current);
	
		
		if(down)
		{
			score+=level;
			current.softDrop();
		}
		if(left)
			current.moveLeft();
		if(right)
			current.moveRight();
		if(space)
		{
			 score+=(23-(current.getTop().getLoc().getRow()))*2*level;
			 current.hardDrop();
		}
		if(up)
			current.rotate();
		
			
	if(current instanceof cube)
		gr.add((cube)current);
	if(current instanceof lleft)
		gr.add((lleft)current);
	if(current instanceof lright)
		gr.add((lright)current);
	if(current instanceof sleft)
		gr.add((sleft)current);
	if(current instanceof sright)
		gr.add((sright)current);
	if(current instanceof smallt)
		gr.add((smallt)current);
	if(current instanceof straight)
		gr.add((straight)current);
	if(!current.getMoving())
		{
			gr.deleteRow();
			gr.deleteRow();
			gr.deleteRow();
			gr.deleteRow();
			addToGrid();
		}
	}
	repaint();
	}
	/**
	 *Controls the user input and allows for movement of the piece
	 **/
	public void keyPressed(KeyEvent e)
	{
		if(timeuser.isRunning())
		{
			
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP: up=true;break;
			case KeyEvent.VK_LEFT: left=true;break;
			case KeyEvent.VK_RIGHT: right=true;break;
			case KeyEvent.VK_DOWN: down=true;
				//int m=((Block)current).getLoc().getRow()-4; 
				//score+=(20-m)*level;
				break;
			case KeyEvent.VK_SPACE: space=true;
				
				break;
			case KeyEvent.VK_ESCAPE: pause(); break;
			case KeyEvent.VK_C: addtoHolding(); break;
			case KeyEvent.VK_S: supermode=!supermode; break;
		}
		}
		else 
		{
		switch(e.getKeyCode())	
		{
			case KeyEvent.VK_ESCAPE: unpause(); break;
		}
		}
	}
	/**
	 *Stops the user-generated movement of the current piece
	 **/
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP: up=false;break;
			case KeyEvent.VK_LEFT: left=false;break;
			case KeyEvent.VK_RIGHT: right=false;break;
			case KeyEvent.VK_DOWN: down=false;break;
			case KeyEvent.VK_SPACE: space=false;break;
		}
	}
	/**
	 *Does nothing.
	 **/
	public void keyTyped(KeyEvent e) 
	{
	}
	/**
	 *Moves the current piece down every time the method is called by the Timer timer.
	 **/
	public static void autoDown()
	{
	if(current instanceof cube)
		gr.nullify((cube)current);
	if(current instanceof lleft)
		gr.nullify((lleft)current);
	if(current instanceof lright)
		gr.nullify((lright)current);
	if(current instanceof sleft)
		gr.nullify((sleft)current);
	if(current instanceof sright)
		gr.nullify((sright)current);
	if(current instanceof smallt)
		gr.nullify((smallt)current);
	if(current instanceof straight)
		gr.nullify((straight)current);	
		
	current.softDrop();
		
	if(current instanceof cube)
		gr.add((cube)current);
	if(current instanceof lleft)
		gr.add((lleft)current);
	if(current instanceof lright)
		gr.add((lright)current);
	if(current instanceof sleft)
		gr.add((sleft)current);
	if(current instanceof sright)
		gr.add((sright)current);
	if(current instanceof smallt)
		gr.add((smallt)current);
	if(current instanceof straight)
		gr.add((straight)current);

	if(!current.getMoving())
		{
			
			gr.deleteRow();
			gr.deleteRow();
			gr.deleteRow();
			gr.deleteRow();
			Block[][] temp24=gr.getGrid();
			for(int c=0; c<10;c++)
			{	//System.out.println(temp24[2][c] instanceof Block);
				if(temp24[2][c] instanceof Block)
				{
					lose=true;
				}
			}
			addToGrid();
		}
	}
	/**
	 *Switches the current piece and the holding piece. 
	 *If there is no holding piece, then the current piece becomes the holding piece, and a new piece becomes the current piece.
	 **/
	private void addtoHolding()
	{	//if()
	{
			//nullify in player grid
			if(current instanceof cube)
				gr.nullify((cube)current);
			if(current instanceof lleft)
				gr.nullify((lleft)current);
			if(current instanceof lright)
				gr.nullify((lright)current);
			if(current instanceof sleft)
				gr.nullify((sleft)current);
			if(current instanceof sright)
				gr.nullify((sright)current);
			if(current instanceof smallt)
				gr.nullify((smallt)current);
			if(current instanceof straight)
				gr.nullify((straight)current);
	//	System.out.println("1");
		//sees if holding grid has something added to it 
		if(added)
		{ 
			//nullify in holding grid
			if(holding instanceof cube)
				hg.nullify((cube)holding);
			if(holding instanceof lleft)
				hg.nullify((lleft)holding);
			if(holding instanceof lright)
				hg.nullify((lright)holding);
			if(holding instanceof sleft)
				hg.nullify((sleft)holding);
			if(holding instanceof sright)
				hg.nullify((sright)holding);
			if(holding instanceof smallt)
				hg.nullify((smallt)holding);
			if(holding instanceof straight)
				hg.nullify((straight)holding);
			//System.out.println("2");
		}
			//simply adds to holding grid
			if(current instanceof cube)
			{	
				current=new cube(hg,holdingx,holdingy);
				hg.add((cube)current);
			}
			if(current instanceof lleft)
			{
				current=new lleft(hg,holdingx,holdingy);
				hg.add((lleft)current);
			}
			if(current instanceof lright)
			{	
				current=new lright(hg,holdingx,holdingy);
				hg.add((lright)current);
			}
			if(current instanceof sleft)
			{
				current=new sleft(hg,holdingx,holdingy);
				hg.add((sleft)current);
			}
			if(current instanceof sright)
			{
				current=new sright(hg,holdingx,holdingy);
				hg.add((sright)current);
			}
			if(current instanceof smallt)
			{
				current=new smallt(hg,holdingx,holdingy);
				hg.add((smallt)current);
			}
			if(current instanceof straight)
			{
				current=new straight(hg,holdingx,holdingy);
				hg.add((straight)current);
			}
			//System.out.println("3");
			//add to holding to player grid AT Top
			if(holding instanceof cube)
			{
				holding =new cube(gr);
				gr.add((cube)holding);
			}
			if(holding instanceof lleft)
			{
				holding=new lleft(gr);
				gr.add((lleft)holding);
			}
				
			if(holding instanceof lright)
			{
				holding=new lright(gr);
				gr.add((lright)holding);
			}
			if(holding instanceof sleft)
			{
				holding=new sleft(gr);
				gr.add((sleft)holding);
			}
				
			if(holding instanceof sright)
			{
				holding=new sright(gr);
				gr.add((sright)holding);
			}
			if(holding instanceof smallt)
			{
				holding=new smallt(gr);
				gr.add((smallt)holding);
			}
			if(holding instanceof straight)
			{
				holding=new straight(gr);
				gr.add((straight)holding);
			}	
			//System.out.println("4");						
		
			added=true;
			Block temp =current;
			current=holding;
			holding=temp;
			if(current ==null)
			{
				addToGrid();
	
			}
			repaint();
	}
	}
	/**
	 *Increases the number of lines by l
	 *Determines any bonuses 
	 *Determines if Super Mode is activated
	 **/			
	public static void increaseLines(int l)
	{
		lines+=l;
		if(l==1)
		{
		score+=100*level;
		Tbonus=1;
		}
		if(l==2)
		{
		score+=300*level;
		Tbonus=1;
		}
		if(l==3)
		{
		score+=500*level;
		Tbonus=1;
		}
		if(l==4)
		{
		score+=800*level*Tbonus;
		Tbonus=1.5;
		if(!supermodetime.isRunning())
		{
		supermode=true;
		supermodetime.start();
		}
		else
		{
			supermodetime.restart();
		}
	}
			
	}	
	
}






