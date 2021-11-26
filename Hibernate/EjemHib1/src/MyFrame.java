import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	private JPanel contentPane;

	public MyFrame(String[] lista) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);	
		
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		
		JComboBox<String> myCB = new JComboBox<>();
		myCB.setModel(new DefaultComboBoxModel<>(lista));
		contentPane.add(myCB);
		
		setVisible(true);
	}
}