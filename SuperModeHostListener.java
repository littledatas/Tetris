package NetworkTetris;
import java.awt.event.*;

public class SuperModeHostListener implements ActionListener
{
	/**
	 *Sets supermode in HostNetworkTetris to false
	 **/
	public void actionPerformed(ActionEvent e)
	{
		HostNetworkTetris.supermode=false;
	}
}