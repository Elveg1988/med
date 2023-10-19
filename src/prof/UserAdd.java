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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserAdd extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField f_username;
	private JTextField f_ename;

	public UserAdd(JFrame f) {
		super(f, "Добавление", Dialog.ModalityType.DOCUMENT_MODAL);
		f_username = new JTextField();
		f_ename = new JTextField();
		setBounds(132, 132, 300, 130);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2));
		p.add(new JLabel("Пользователь"));
		p.add(f_username);
		p.add(new JLabel("Фамилия"));
		p.add(f_ename);
		cp.add(p, BorderLayout.CENTER);
		JPanel b = new JPanel();
		b.setPreferredSize(new Dimension(300, 50));
		JButton b1 = new JButton("Сохранить");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				saveUser();
			}
		});
		b.add(b1);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				f_username.setText("");
				f_ename.setText("");
			}
		});
		cp.add(b, BorderLayout.SOUTH);
	}

	private void saveUser() {
		((User) this.getOwner()).addNew(f_username.getText(), f_ename.getText());
		f_username.setText("");
		f_ename.setText("");
	}
}
