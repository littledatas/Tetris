package NetworkTetris;

import java.util.TimerTask;
import java.util.Timer;

public class OutConverterManager extends TimerTask 
{
	/**
	 *Timer to execute the convert() at a certain frequency
	 **/
	Timer time;
	/**
	 *The grid representation in a String
	 **/
	static String rep="";
	/**
	 *The grid matrix of the Tetris game
	 **/
	static Block[][] locs;
	/**
	 *The grid that needs to be onverted into a String
	 **/
	static Grid gr;
	public OutConverterManager(Grid g)
	{
		gr=g;
		time=new Timer();
		time.schedule(this,(long)100,(long)100);
		
	}
	/**
	 *Changes the Grid object
	 **/
	public void change(Grid g)
	{
		gr=g; 
	}
	/**
	 *Runs the convert()
	 **/
	public void run()
	{
		convert();
	}
	/**
	 *Converts the Grid gr into a String stored as rep
	 **/
	public static void convert()
	{
		//rep+="\n";
		
		rep="";
		locs=gr.getGrid();
		for(int r=3; r<23; r++)
		{
			for(int c=0; c<10; c++)
			{
			if(locs[r][c]==null)	
				rep+="em ";
			else
			{
				if(locs[r][c].getIdent()==0)
					rep+="cu ";
				else if(locs[r][c].getIdent()==6)
					rep+="ll ";
				else if(locs[r][c].getIdent()==2)
					rep+="lr ";
				else if(locs[r][c].getIdent()==3)
					rep+="sl ";
				else if(locs[r][c].getIdent()==4)
					rep+="sr ";
				else if(locs[r][c].getIdent()==5)
					rep+="sm ";
				else if(locs[r][c].getIdent()==1)
					rep+="st ";
			}
						
			}
			//rep+="\n";
		}
		//rep+="\n";
	}
	/**
	 *Returns the String representation of the Grid
	 **/
	public String getString()
	{
		return rep;
	}
}
