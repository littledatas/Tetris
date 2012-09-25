package NetworkTetris;
import java.awt.event.*;

public class SuperModeListener implements ActionListener
{
		/**
	 *Sets supermode in Tetris to false
	 **/
	public void actionPerformed(ActionEvent e)
	{
		Tetris.supermode=false;
	}
}