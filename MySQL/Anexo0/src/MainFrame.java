import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainFrame extends JFrame {
    private JPasswordField passwordField;
    private JTextField textField;

    public MainFrame() {

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Nombre");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameLabel.setBounds(10, 22, 86, 18);
        panel.add(nameLabel);

        JLabel passwdLabel = new JLabel("Contrase\u00F1a");
        passwdLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwdLabel.setBounds(10, 51, 86, 18);
        panel.add(passwdLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setBounds(88, 50, 107, 20);
        panel.add(passwordField);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField.setBounds(88, 23, 107, 20);
        panel.add(textField);
        textField.setColumns(10);

        JButton aceptButton = new JButton("Aceptar");
        aceptButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        acc
        aceptButton.setBounds(286, 35, 89, 23);
        panel.add(aceptButton);

        JLabel lblNewLabel = new JLabel("Introduce el Nombre y la Contrase\u00F1a");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(62, 171, 261, 18);
        panel.add(lblNewLabel);

    }
}
