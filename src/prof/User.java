package prof;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.EventListenerList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class User extends JFrame implements TableModel, ActionListener {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Vector<Object> colNames = null;
	private Vector<Vector<Object>> data = null;
	private JTable table;
	protected EventListenerList listenerList = new EventListenerList();
	private Integer id;
	private String username;
	private String ename;
	private JTextField f_id;
	private JTextField f_username;
	private JTextField f_ename;
	private UserAdd userAdd;
	private UserEdit userEdit;
	private UserPass userPass;

	public User(Connection conn) {
		if (conn == null) {
			JOptionPane.showMessageDialog(null, "Соединения с базой данных отсутствует", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			dispose();
		}
		this.conn = conn;
		id = null;
		username = null;
		ename = null;
		f_id = new JTextField();
		f_id.setEditable(false);
		f_username = new JTextField();
		f_username.setEditable(false);
		f_ename = new JTextField();
		f_ename.setEditable(false);
		loadHead();
		loadData();
		paint();
	}

	private void loadHead() {
		colNames = new Vector<Object>();
		colNames.addElement("Ид");
		colNames.addElement("Пользователь");
		colNames.addElement("Фамилия");
	}

	private void loadData() {
		String query = "select id, username, ename from emp order by id";
		try (Statement stmt = conn.createStatement()) {
			ResultSet rset = stmt.executeQuery(query);
			data = new Vector<Vector<Object>>();
			while (rset.next()) {
				Vector<Object> row = new Vector<Object>();
				row.addElement(rset.getInt(1));
				row.addElement(rset.getString(2));
				row.addElement(rset.getString(3));
				data.addElement(row);
			}
			rset.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Таблица служащих отсутствует", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			dispose();
		}
	}

	private void paint() {
		setTitle("Сотрудники");
		setSize(300, 225);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;

		menuBar = new JMenuBar();

		menu = new JMenu("Действия");
		menuBar.add(menu);

		menuItem = new JMenuItem("Новый");
		menuItem.addActionListener(this);
		menuItem.setName("us_nov");
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Изменить");
		menuItem.addActionListener(this);
		menuItem.setName("us_izm");
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Удалить");
		menuItem.addActionListener(this);
		menuItem.setName("us_yda");
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Задать пароль");
		menuItem.addActionListener(this);
		menuItem.setName("us_par");
		menu.add(menuItem);

		setJMenuBar(menuBar);

		table = new JTable(this);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ListSelectionModel rowSM = table.getSelectionModel();
		rowSM.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting())
					return;
				ListSelectionModel lsm = (ListSelectionModel) e.getSource();
				if (lsm.isSelectionEmpty()) {
					id = null;
					username = null;
					ename = null;
				} else {
					int selectedRow = lsm.getMinSelectionIndex();
					id = (Integer) table.getValueAt(selectedRow, 0);
					username = (String) table.getValueAt(selectedRow, 1);
					ename = (String) table.getValueAt(selectedRow, 2);
				}
				showRec();
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		cp.add(scrollPane, BorderLayout.CENTER);
		JPanel f = new JPanel();
		f.setSize(300, 150);
		f.setLayout(new GridLayout(3, 2));
		f.add(new JLabel("Ид"));
		f.add(f_id);
		f.add(new JLabel("Пользователь"));
		f.add(f_username);
		f.add(new JLabel("Фамилия"));
		f.add(f_ename);
		showRec();
		cp.add(f, BorderLayout.SOUTH);
		center();
	}

	private void center() {
		Dimension ws = getSize();
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ss.width - ws.width) / 2;
		int y = (ss.height - ws.height) / 2;
		setLocation(x, y);
	}

	private void showRec() {
		if (id == null)
			f_id.setText("");
		else
			f_id.setText(String.valueOf(id));
		f_username.setText(username);
		f_ename.setText(ename);
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return colNames.size();
	}

	@Override
	public String getColumnName(int columnIndex) {
		return (String) colNames.elementAt(columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data.get(rowIndex).set(columnIndex, aValue);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		listenerList.add(TableModelListener.class, l);
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listenerList.remove(TableModelListener.class, l);
	}

	public void fireTableDataChanged() {
		fireTableChanged(new TableModelEvent(this));
	}

	public void fireTableChanged(TableModelEvent e) {
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == TableModelListener.class) {
				((TableModelListener) listeners[i + 1]).tableChanged(e);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem mi = (JMenuItem) e.getSource();
		if (mi.getName().equals("us_nov")) {
			if (userAdd == null)
				userAdd = new UserAdd(this);
			userAdd.setVisible(true);
		}
		if (mi.getName().equals("us_izm")) {
			if (userEdit == null)
				userEdit = new UserEdit(this);
			userEdit.loadUser();
			userEdit.setVisible(true);
		}
		if (mi.getName().equals("us_yda")) {
			int ret = JOptionPane.showConfirmDialog(null, "Подтвердите удаление записи. Согласны?", "Удаление",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (ret == 0) {
				delete();
			}
		}
		if (mi.getName().equals("us_par")) {
			if (userPass == null)
				userPass = new UserPass(this);
			userPass.setVisible(true);
		}
	}

	public void addNew(String username, String ename) {
		String query = "insert into emp (username, ename, rolid) values (?, ?, 3)";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, username);
			stmt.setString(2, ename);
			int ret = stmt.executeUpdate();
			if (ret > 0) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					id = keys.getInt(1);
					this.username = username;
					this.ename = ename;
					Vector<Object> row = new Vector<Object>();
					row.addElement(id);
					row.addElement(username);
					row.addElement(ename);
					data.addElement(row);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			} else {
				throw new SQLException("Creating user failed, no row affected.");
			}
			table.repaint();
			fireTableDataChanged();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ошибка добавления служащих", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void edit(String username, String ename) {
		String query = "update emp set username=?, ename=? where id=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, username);
			stmt.setString(2, ename);
			stmt.setInt(3, id);
			int ret = stmt.executeUpdate();
			if (ret > 0) {
				for (int i = 0; i < data.size(); i++) {
					Vector<Object> row = data.get(i);
					if (row.get(0) == id) {
						row.set(2, ename);
					}
				}
				this.username = username;
				this.ename = ename;
			} else {
				throw new SQLException("Editing user failed, no row affected.");
			}
			showRec();
			table.repaint();
			fireTableDataChanged();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ошибка изменения служащих", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void delete() {
		String query = "delete from emp where id=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			int ret = stmt.executeUpdate();
			if (ret > 0) {
				for (int i = 0; i < data.size(); i++) {
					Vector<Object> row = data.get(i);
					if (row.get(0) == id) {
						data.removeElementAt(i);
					}
				}
				this.id = null;
				this.username = null;
				this.ename = null;
			} else {
				throw new SQLException("Editing user failed, no row affected.");
			}
			showRec();
			table.repaint();
			table.clearSelection();
			fireTableDataChanged();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ошибка изменения служащих", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void pass(String hash) {
		String query = "update emp set hash=? where id=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, hash);
			stmt.setInt(2, id);
			int ret = stmt.executeUpdate();
			if (ret > 0) {
				JOptionPane.showMessageDialog(null, "Пароль задан", "Информация: ", JOptionPane.INFORMATION_MESSAGE);
			} else {
				throw new SQLException("Editing user failed, no row affected.");
			}
			showRec();
			table.repaint();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Ошибка установки пароля служащих", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public String get_username() {
		return username;
	}

	public String get_ename() {
		return ename;
	}
}
