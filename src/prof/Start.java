package prof;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Start extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Start instance;

	private JTextField username;
	private JPasswordField password;
	private JButton loginButton;
	private JButton cancelButton;
	private Connection conn;
	private final String adminHash = "/OM9kE5aqo1GDLq+RcENy8hRNRwRi40KzlwYQWni7lg=";
	private final String url = "jdbc:sqlite:profdb";

	public static void main(String[] args) {
		Start start = new Start();
		instance = start;
		start.setVisible(true);
	}

	private Start() {
		super();
		username = new JTextField("ivan");
		password = new JPasswordField("bdfy");
		loginButton = new JButton("Вход");
		cancelButton = new JButton("Отмена");
		paint();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!validateRequired())
					return;
				String hash = calcHash();
				if (username.getText().toLowerCase().equals("admin")) {
					if (!validateAdmin(hash)) {
						return;
					}
				}
				try {
					conn = DriverManager.getConnection(url);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "База данных не доступна: " + e.getMessage(),
							"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if (!username.getText().toLowerCase().equals("admin")) {
					if (!validateUser(hash)) {
						return;
					}
				}
				setVisible(false);
				JFrame main = new Main(instance);
				main.setVisible(true);
			}
		});
	}

	private void paint() {
		setTitle("Вход");
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel h = new JPanel();
		h.add(new JLabel("Профосмотры"));
		JPanel c = new JPanel();
		c.setLayout(new GridLayout(2, 2));
		c.add(new JLabel("Имя пользователя:"));
		c.add(username);
		c.add(new JLabel("Пароль:"));
		c.add(password);
		JPanel f = new JPanel();
		f.add(loginButton);
		f.add(cancelButton);
		cp.add(h, BorderLayout.NORTH);
		cp.add(c);
		cp.add(f, BorderLayout.SOUTH);
		pack();
		center();
		getRootPane().setDefaultButton(loginButton);
	}

	private void center() {
		Dimension ws = getSize();
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ss.width - ws.width) / 2;
		int y = (ss.height - ws.height) / 2;
		setLocation(x, y);
	}

	private boolean validateRequired() {
		if (username.getText() == null || username.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Заполните имя пользователя", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if (password.getPassword() == null || password.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Заполните пароль", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}

	private boolean validateAdmin(String hash) {
		if (hash != null && hash.equals(adminHash)) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Неверный пароль", "Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}

	private boolean validateUser(String hash) {
		String query = "select hash from emp where username=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, username.getText());
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (rset.getString(1).equals(hash)) {
					rset.close();
					return true;
				} else {
					rset.close();
					JOptionPane.showMessageDialog(null, "Неверный пароль", "Предупреждение: ",
							JOptionPane.INFORMATION_MESSAGE);
					return false;
				}
			}
			rset.close();
			JOptionPane.showMessageDialog(null, "Неверное имя пользователя", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Таблица служащих отсутствует", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
		}
		return false;
	}

	private String calcHash() {
		return Utils.calcHash(password.getPassword());
	}

	public Connection getConnection() {
		return conn;
	}

	public String getUsername() {
		return username.getText();
	}
}
