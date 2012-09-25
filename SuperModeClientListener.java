package NetworkTetris;
import java.awt.event.*;

public class SuperModeClientListener implements ActionListener
{
		/**
	 *Sets supermode in ClientNetworkTetris to false
	 **/
	public void actionPerformed(ActionEvent e)
	{
		ClientNetworkTetris.supermode=false;
	}
}