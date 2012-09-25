package NetworkTetris;
import java.awt.event.*;
public class TetrisListener implements ActionListener 
{		
		/**
		 *Moves the current piece down in Tetris
		 *Repains the frame in Tetris
		 **/
		public void actionPerformed(ActionEvent e)
		{
			Tetris.autoDown();
			Tetris.frame.paint(Tetris.frame.getGraphics());
		}
}