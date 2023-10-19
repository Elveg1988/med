package prof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private User user = null;

	public Main(Start start) {
		super();
		int admin = start.getUsername().equals("admin") ? 1 : 0;
		paint(admin);
		conn = start.getConnection();
		if (conn == null) {
			JOptionPane.showMessageDialog(null, "Соединения с базой данных отсутствует", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			dispose();
			System.exit(0);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void paint(int admin) {
		setTitle("Профосмотры");
		setSize(600, 100);

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;

		menuBar = new JMenuBar();

		menu = new JMenu("Профосмотр");
		menuBar.add(menu);

		menuItem = new JMenuItem("Новый");
		menuItem.addActionListener(this);
		menuItem.setName("po_nov");
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Найти");
		menuItem.addActionListener(this);
		menuItem.setName("po_isk");
		menu.add(menuItem);

		/*menu = new JMenu("Отчеты");
		menuBar.add(menu);

		menuItem = new JMenuItem("Отчет PDF");
		menuItem.addActionListener(this);
		menuItem.setName("ot_pdf");
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Отчет CSV");
		menuItem.addActionListener(this);
		menuItem.setName("ot_csv");
		menu.add(menuItem);*/

		menuBar.add(Box.createHorizontalGlue());
		if (admin == 1) {
			menu = new JMenu("Администрирование");
			menuBar.add(menu);

			menuItem = new JMenuItem("Список");
			menuItem.addActionListener(this);
			menuItem.setName("ad_spi");
			menu.add(menuItem);
		}
		setJMenuBar(menuBar);
	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem mi = (JMenuItem) e.getSource();
		if (mi.getName().equals("ad_spi")) {
			if (user == null)
				user = new User(conn);
			user.setVisible(true);
		}
		if (mi.getName().equals("po_nov")) {
			Osmotr osmotr = new Osmotr(conn);
			osmotr.setVisible(true);
		}
		if (mi.getName().equals("po_isk")) {
			Poisk poisk = new Poisk(conn);
			poisk.setVisible(true);
		}
		if (mi.getName().equals("ot_pdf")) {
			Otchet1.build();
			JOptionPane.showMessageDialog(null, "Создан отчет PDF", "Информация: ", JOptionPane.INFORMATION_MESSAGE);
		}
		if (mi.getName().equals("ot_csv")) {
			Otchet2 otchet2 = new Otchet2(conn);
			otchet2.buildCSV();
			JOptionPane.showMessageDialog(null, "Создан отчет 2", "Информация: ", JOptionPane.INFORMATION_MESSAGE);
			otchet2 = null;
		}
	}
}
