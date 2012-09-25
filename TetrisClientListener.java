package NetworkTetris;
import java.awt.event.*;
public class TetrisClientListener implements ActionListener 
{		
		/**
		 *Moves the current piece down in ClientNetworkTetris
		 *Repains the frame in ClientNetworkTetris
		 **/
		public void actionPerformed(ActionEvent e)
		{
			ClientNetworkTetris.autoDown();
			ClientNetworkTetris.frame.paint(ClientNetworkTetris.frame.getGraphics());
		}
}