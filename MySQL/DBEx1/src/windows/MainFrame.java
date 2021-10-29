package windows;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import javax.swing.JLabel;

public class MainFrame extends JFrame{
	private JPanel mainContentPanel;
	private Dimension generalSize;
	public MainFrame() {
		generalSize = new Dimension(900, 500);
		mainContentPanel = new JPanel();
		setContentPane(mainContentPanel);
		mainContentPanel.setLayout(null);
		Panel1 p1 = new Panel1();
		p1.setBounds(10, 11, 530, 439);
		mainContentPanel.add(p1);
		mainContentPanel.setVisible(true);
		mainContentPanel.setSize(generalSize);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(585, 11, 72, 21);
		mainContentPanel.add(lblNewLabel);
		
		
		setSize(generalSize);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
