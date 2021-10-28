package windows;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

public class MainFrame extends JFrame{
	private JPanel mainContentPanel;
	private Dimension generalSize;
	public MainFrame() {
		generalSize = new Dimension(900, 500);
		mainContentPanel = new Panel1();
		setContentPane(mainContentPanel);
		mainContentPanel.setVisible(true);
		mainContentPanel.setSize(generalSize);
		
		
		setSize(generalSize);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
