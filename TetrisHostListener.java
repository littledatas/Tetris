package NetworkTetris;
import java.awt.event.*;
public class TetrisHostListener implements ActionListener 
{		
		/**
		 *Moves the current piece down in HostNetworkTetris
		 *Repains the frame in HostNetworkTetris
		 **/
		public void actionPerformed(ActionEvent e)
		{
			HostNetworkTetris.autoDown();
			HostNetworkTetris.frame.paint(HostNetworkTetris.frame.getGraphics());
		}
}