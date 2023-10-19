package prof;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.io.FileOutputStream;

public class Poisk extends JFrame implements TableModel {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Vector<Object> colNames = null;
	private Vector<Vector<Object>> data = null;
	private JTable table;
	protected EventListenerList listenerList = new EventListenerList();
	private JScrollPane scrollPane;
	private Integer id;

	private String query = "select p.id, p.fio,	p.osmotrdat, p.pol, p.vozr, ped.f_21, p.shkola, p.klass, p.paral, ped.f_19, ped.f_20 "
			+ "from profosmotr p left outer join pediatr ped on (p.id=ped.idosmotr)";

	JTextField f_fio = null;
	JTextField f_dataosm = null;
	JTextField f_nomkar = null;
	JTextField f_snils = null;
	JTextField f_strahpol = null;
	JTextField f_skola = null;
	JTextField f_paralel = null;
	JTextField f_class = null;
	JComboBox<String> f_pol = null;
	JTextField f_vozrgod = null;
	JComboBox<String> f_mkb = null;
	JComboBox<String> f_gruppaz = null;
	JComboBox<String> f_gruppaf = null;
	JCheckBox f_pat;

	public Poisk(Connection conn) {
		super();
		this.conn = conn;
		f_fio = new JTextField("");
		f_dataosm = new JTextField("");
		f_nomkar = new JTextField("");
		f_snils = new JTextField("");
		f_strahpol = new JTextField("");
		f_skola = new JTextField("");
		f_class = new JTextField("");
		f_paralel = new JTextField("");
		String pol[] = { "", "М", "Ж" };
		f_pol = new JComboBox<String>(pol);
		f_vozrgod = new JTextField("");
		String mkb[] = { "", "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
				"R", "S", "T", "U", "V", "W", "X", "Y" };
		f_mkb = new JComboBox<String>(mkb);
		String gruppaz[] = { "", "I", "II", "III", "IV", "V" };
		f_gruppaz = new JComboBox<String>(gruppaz);
		String gruppaf[] = { "", "I", "II", "III", "IV", "не допущен" };
		f_gruppaf = new JComboBox<String>(gruppaf);

		loadHead();
		loadData();
		paint();
	}

	private void loadHead() {
		colNames = new Vector<Object>();
		colNames.addElement("Ид");
		colNames.addElement("Фамилия");
		colNames.addElement("Дата осмотра");
		colNames.addElement("Пол");
		colNames.addElement("Возраст");
		colNames.addElement("Группа Зд");
		colNames.addElement("Номер школы");
		colNames.addElement("Класс");
		colNames.addElement("Параллель");
		colNames.addElement("МКБ");
		colNames.addElement("Физ. группа");
	}

	private void loadData() {
		data = new Vector<Vector<Object>>();
		Vector<Object> row = new Vector<Object>();
		row.addElement(0);
		row.addElement("");
		row.addElement("");
		row.addElement("");
		row.addElement("");
		row.addElement("");
		row.addElement("");
		row.addElement("");
		row.addElement("");
		row.addElement("");
		row.addElement("");
		data.addElement(row);
	}

	private void reloadData() {
		String where = " where 1=1";
		if (!f_fio.getText().equals("")) {
			where = where + " and fio='" + f_fio.getText() + "'";
		}
		if (!f_dataosm.getText().equals("")) {
			where = where + " and osmotrdat='" + f_dataosm.getText() + "'";
		}
		if (!f_pol.getSelectedItem().equals("")) {
			where = where + " and pol='" + f_pol.getSelectedItem() + "'";
		}
		if (!f_vozrgod.getText().equals("")) {
			where = where + " and vozr ='" + f_vozrgod.getText() + "'";
		}
		if (!f_gruppaz.getSelectedItem().equals("")) {
			where = where + " and exists (select f_21 from pediatr where idosmotr=id and f_21='"
					+ f_gruppaz.getSelectedItem() + "')";
		}
		if (!f_skola.getText().equals("")) {
			where = where + " and shkola = '" + f_skola.getText() + "'";
		}
		if (!f_class.getText().equals("")) {
			where = where + " and klass = '" + f_class.getText() + "'";
		}
		if (!f_paralel.getText().equals("")) {
			where = where + " and paral = '" + f_paralel.getText() + "'";
		}
		if (!f_mkb.getSelectedItem().equals("")) {
			where = where + " and exists (select f_19 from pediatr where idosmotr=id and f_19='"
					+ f_mkb.getSelectedItem() + "')";
		}
		if (!f_gruppaf.getSelectedItem().equals("")) {
			where = where + " and exists (select f_20 from pediatr where idosmotr=id and f_20='"
					+ f_gruppaf.getSelectedItem() + "')";
		}
		if (f_pat.isSelected()) {
			where = where + " and (exists (select f_3 from AD where idosmotr=id and f_3='Y')"
					+ " or exists (select f_12 from EKG where idosmotr=id and f_12='Y')"
					+ " or exists (select f_22 from ObshiyKrovi where idosmotr=id and f_22='Y')"
					+ " or exists (select f_27 from ObshiyMochi where idosmotr=id and f_27='Y')"
					+ " or exists (select f_3 from pulso where idosmotr=id and f_3='Y')"
					+ " or exists (select f_8 from spiro where idosmotr=id and f_8='Y')"
					+ " or exists (select f_2 from uzi where idosmotr=id and f_2='Y'))";
		}
		System.out.println(query + where);
		try (Statement stmt = conn.createStatement()) {
			ResultSet rset = stmt.executeQuery(query + where);
			data.clear();
			while (rset.next()) {
				Vector<Object> row = new Vector<Object>();
				row.addElement(rset.getInt(1));
				row.addElement(rset.getString(2));
				row.addElement(rset.getString(3));
				row.addElement(rset.getString(4));
				row.addElement(rset.getString(5));
				row.addElement(rset.getString(6));
				row.addElement(rset.getString(7));
				row.addElement(rset.getString(8));
				row.addElement(rset.getString(9));
				row.addElement(rset.getString(10));
				row.addElement(rset.getString(11));
				data.addElement(row);
			}
			rset.close();
			fireTableDataChanged();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void report() {
        try (FileOutputStream fos = new FileOutputStream("sample1.csv");) {
            for (int i = 0; i < data.size(); i++) {
                Vector<Object> row = data.get(i);
                fos.write(((String)
row.get(1)).getBytes(Charset.forName("windows-1251")));
                fos.write(";".getBytes());
                fos.write(((String)
row.get(4)).getBytes(Charset.forName("windows-1251")));
                fos.write("\n".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private void paint() {
		setTitle("Поиск");

		Container cp = getContentPane();
		setSize(new Dimension(800, 400));
		cp.setLayout(new BorderLayout());
		JPanel h = new JPanel(new GridLayout(6, 4));
		JLabel l = new JLabel("ФИО");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_fio);
		l = new JLabel("Дата осмотра");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_dataosm);
		l = new JLabel("Пол");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_pol);
		l = new JLabel("Возраст");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_vozrgod);
		l = new JLabel("Код МКБ Педиатра");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_mkb);
		l = new JLabel("Школа");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_skola);
		l = new JLabel("Класс");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_class);
		l = new JLabel("Параллель");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_paralel);
		l = new JLabel("группа здоровья");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_gruppaz);
		l = new JLabel("физ группа");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_gruppaf);
		l = new JLabel("Патология");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		f_pat = new JCheckBox();
		h.add(f_pat);
		JButton b = new JButton("Найти");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reloadData();
			}
		});
		h.add(b);
		JButton b2 = new JButton("печать");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				report();
			}
		});
		h.add(b2);
		cp.add(h, BorderLayout.NORTH);
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
				} else {
					int selectedRow = lsm.getMinSelectionIndex();
					id = (Integer) table.getValueAt(selectedRow, 0);
				}
			}
		});
		scrollPane = new JScrollPane(table);
		cp.add(scrollPane, BorderLayout.CENTER);
		JButton b1 = new JButton("Открыть");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Osmotr osmotr = new Osmotr(conn);
				osmotr.loadData(id);
				osmotr.setVisible(true);
			}
		});
		cp.add(b1, BorderLayout.SOUTH);
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
		// System.out.print(columnIndex);
		// System.out.print("-");
		// System.out.println(getValueAt(0, columnIndex));
		if (getValueAt(0, columnIndex) != null) {
			return getValueAt(0, columnIndex).getClass();
		} else {
			return "".getClass();
		}
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

}
