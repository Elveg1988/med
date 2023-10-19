package prof;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class UserPass extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPasswordField f_pass1;
	private JPasswordField f_pass2;

	public UserPass(JFrame f) {
		super(f, "Задать пароль", Dialog.ModalityType.DOCUMENT_MODAL);
		f_pass1 = new JPasswordField();
		f_pass2 = new JPasswordField();
		setBounds(132, 132, 300, 130);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2));
		p.add(new JLabel("Введите пароль"));
		p.add(f_pass1);
		p.add(new JLabel("Повторите"));
		p.add(f_pass2);
		cp.add(p, BorderLayout.CENTER);
		JPanel b = new JPanel();
		b.setPreferredSize(new Dimension(300, 50));
		JButton b1 = new JButton("Сохранить");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setPassUser();
			}
		});
		b.add(b1);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				f_pass1.setText("");
				f_pass2.setText("");
			}
		});
		cp.add(b, BorderLayout.SOUTH);
	}

	private void setPassUser() {
		String hash1 = Utils.calcHash(f_pass1.getPassword());
		String hash2 = Utils.calcHash(f_pass2.getPassword());
		if (hash1.equals(hash2)) {
			((User) this.getOwner()).pass(hash1);
			setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Пароли не совпадают. Повторите", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
		}
		f_pass1.setText("");
		f_pass2.setText("");
	}
}
