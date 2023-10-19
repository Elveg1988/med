package prof;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class Osmotr extends JFrame {

	private static final long serialVersionUID = 1L;
	private Osmotr instance;
	private Connection conn;
	JTextField f_fio = null;
	JTextField f_adres = null;
	JTextField f_adresbol = null;
	JTextField f_dataosm = null;
	JTextField f_denrozh = null;
	JTextField f_vozrgod = null;
	JTextField f_vozrmes = null;
	JComboBox<String> f_pol = null;
	JTextField f_nomkar = null;
	JTextField f_snils = null;
	JTextField f_strahpol = null;
	JTextField f_skola = null;
	JTextField f_paralel = null;
	JTextField f_class = null;
	JTextField f_okrgrud = null;
	JTextField f_okrplecha = null;
	JTextField f_okrgivot = null;
	JTextField f_rost = null;
	JTextField f_massa = null;
	JTextField f_okrbedra = null;
	JTextField f_okrgolov = null;
	JTextField f_IndAndrom = null;
	JTextField f_IndMasTel = null;
	JTextField f_IndChulic = null;
	JTextArea f_1;

	Pulso pulso = null;
	AD ad = null;
	EKG ekg = null;
	Spiro spiro = null;
	ObshiyKrovi obshiyKrovi = null;
	ObshiyMochi obshiyMochi = null;
	Uzi uzi = null;
	Ginekolog ginekolog = null;
	Nevrolog nevrolog = null;
	Oftalmolog oftalmolog = null;
	Psihiatr psihiatr = null;
	Travmatolog travmatolog = null;
	Urolog urolog = null;
	Hirurg hirurg = null;
	Lor lor = null;
	Pediatr pediatr = null;
	Endo endo = null;
	Stomatolog stomatolog = null;
	Integer id = null;

	JButton b_1 = null;
	JButton b_2 = null;
	JButton b_3 = null;
	JButton b_4 = null;
	JButton b_5 = null;
	JButton b_6 = null;
	JButton b_7 = null;
	JButton b_8 = null;
	JButton b_9 = null;
	JButton b_10 = null;
	JButton b_11 = null;
	JButton b_12 = null;
	JButton b_13 = null;
	JButton b_14 = null;
	JButton b_15 = null;
	JButton b_16 = null;
	JButton b_17 = null;
	JButton b_18 = null;
	JButton b_19 = null;
	JButton b_20 = null;
	JButton b_21 = null;
	JButton b_22 = null;
	JButton b_23 = null;
	JButton b_24 = null;

	public Osmotr(Connection conn) {
		super();
		if (conn == null) {
			JOptionPane.showMessageDialog(null, "Соединения с базой данных отсутствует", "Предупреждение: ",
					JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
			dispose();
		}
		this.conn = conn;
		instance = this;
		f_fio = new JTextField("");
		f_adres = new JTextField("");
		f_adresbol = new JTextField("");
		f_fio = new JTextField("");
		f_dataosm = new JTextField("10.10.2023");
		f_denrozh = new JTextField("10.10.2006");
		f_vozrgod = new JTextField("");
		f_vozrgod.setEditable(false);
		f_vozrmes = new JTextField("");
		f_vozrmes.setEditable(false);
		f_nomkar = new JTextField("");
		f_snils = new JTextField("");
		f_strahpol = new JTextField("");
		f_skola = new JTextField("");
		f_paralel = new JTextField("");
		f_class = new JTextField("");

		String pol[] = { "М", "Ж" };
		f_pol = new JComboBox<String>(pol);

		f_okrgrud = new JTextField("");
		f_okrplecha = new JTextField("");
		f_okrgivot = new JTextField("");
		f_rost = new JTextField("");
		f_massa = new JTextField("");
		f_okrbedra = new JTextField("");
		f_okrgolov = new JTextField("");
		f_IndAndrom = new JTextField("");
		f_IndMasTel = new JTextField("");
		f_IndChulic = new JTextField("");
		f_IndAndrom.setEditable(false);
		f_IndChulic.setEditable(false);
		f_IndMasTel.setEditable(false);

		paint();
	}

	private void paint() {
		setTitle("Новый профосмотр");

		Container cp = getContentPane();
		setSize(new Dimension(800, 400));
		cp.setLayout(new BorderLayout());
		JPanel h = new JPanel(new GridLayout(7, 4));
		JLabel l = new JLabel("Название медицинского учереждения");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_adresbol);
		l = new JLabel("Адресс пациента");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_adres);
		l = new JLabel("ФИО");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_fio);
		l = new JLabel("Дата рождения дд.мм.гггг");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_denrozh);
		l = new JLabel("Дата осмотра дд.мм.гггг");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_dataosm);
		b_22 = new JButton("Возраст (лет)");
		b_22.setHorizontalAlignment(JLabel.RIGHT);
		h.add(b_22);
		b_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int godR = Integer.parseInt(f_denrozh.getText().substring(6));
				int godO = Integer.parseInt(f_dataosm.getText().substring(6));
				int mesR = Integer.parseInt(f_denrozh.getText().substring(3, 5));
				int mesO = Integer.parseInt(f_dataosm.getText().substring(3, 5));
				int denR = Integer.parseInt(f_denrozh.getText().substring(0, 2));
				int denO = Integer.parseInt(f_dataosm.getText().substring(0, 2));
				int vozrgod = godO - godR;
				if (mesO < mesR) {
					vozrgod--;
					mesO = mesO + 12;
				}
				int vozrmes = mesO - mesR;
				if (denO < denR) {
					vozrmes--;
				}
				f_vozrgod.setText(String.valueOf(vozrgod));
				f_vozrmes.setText(String.valueOf(vozrmes));
				if (vozrgod >= 15) {
					b_5.setEnabled(true);
					b_7.setEnabled(true);
					b_8.setEnabled(true);
					b_12.setEnabled(true);
					b_12.setEnabled(true);
					b_13.setEnabled(true);
					b_14.setEnabled(true);
					b_15.setEnabled(true);
					b_16.setEnabled(true);
				} else {
					b_5.setEnabled(false);
					b_7.setEnabled(false);
					b_8.setEnabled(false);
					b_12.setEnabled(false);
					b_12.setEnabled(false);
					b_13.setEnabled(false);
					b_14.setEnabled(false);
					b_15.setEnabled(false);
					b_16.setEnabled(false);
				}
			}
		});
		h.add(f_vozrgod);
		l = new JLabel("Возраст (мес)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_vozrmes);
		l = new JLabel("Пол");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_pol);
		f_pol.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getItem().equals("Ж")) {
					b_11.setEnabled(true);
					b_10.setEnabled(false);
				} else {
					b_11.setEnabled(false);
					b_10.setEnabled(true);
				}
			}

		});
		l = new JLabel("Номер карты");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_nomkar);
		l = new JLabel("Снилс");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_snils);
		l = new JLabel("Страховой полис");
		l.setHorizontalAlignment(JLabel.RIGHT);
		h.add(l);
		h.add(f_strahpol);
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
		cp.add(h, BorderLayout.NORTH);
		JTabbedPane c = new JTabbedPane();
		JPanel t1 = new JPanel(new GridLayout(6, 4));
		c.addTab("Доврачебный осмотр", t1);

		l = new JLabel("Окружность груди (см)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		t1.add(l);
		t1.add(f_okrgrud);
		l = new JLabel("Окружность плеча (см)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		t1.add(l);
		t1.add(f_okrplecha);
		l = new JLabel("Окружность живота (см)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		t1.add(l);
		t1.add(f_okrgivot);
		l = new JLabel("Рост (см)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		t1.add(l);
		t1.add(f_rost);
		l = new JLabel("Масса тела (кг)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		t1.add(l);
		t1.add(f_massa);
		l = new JLabel("Окружность бедра (см)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		t1.add(l);
		t1.add(f_okrbedra);
		l = new JLabel("Окружность голени (см)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		t1.add(l);
		t1.add(f_okrgolov);
		b_19 = new JButton("Индекс массы тела");
		b_19.setHorizontalAlignment(JLabel.RIGHT);
		t1.add(b_19);
		b_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x = 0;
				x = Double.parseDouble(f_rost.getText());
				x = x / 100;
				x = x * x;
				double y = 0;
				y = Double.parseDouble(f_massa.getText()) / x;
				int vozrgod = Integer.parseInt(f_vozrgod.getText());
				if (vozrgod == 14) {
					if (y >= 15.4 && y <= 22.7) {
						f_IndMasTel.setBackground(Color.GREEN);
					} else
						f_IndMasTel.setBackground(Color.RED);
				}
				if (vozrgod == 15) {
					if (y >= 15.9 && y <= 23.5) {
						f_IndMasTel.setBackground(Color.GREEN);
					} else
						f_IndMasTel.setBackground(Color.RED);
				}
				if (vozrgod == 16) {
					if (y >= 16.2 && y <= 24.1) {
						f_IndMasTel.setBackground(Color.GREEN);
					} else
						f_IndMasTel.setBackground(Color.RED);
				}
				if (vozrgod == 17) {
					if (y >= 16.4 && y <= 24.5) {
						f_IndMasTel.setBackground(Color.GREEN);
					} else
						f_IndMasTel.setBackground(Color.RED);
				}
				if (vozrgod < 14) {
					f_IndMasTel.setBackground(Color.WHITE);
				}
				if (vozrgod > 17) {
					f_IndMasTel.setBackground(Color.WHITE);
				}
				f_IndMasTel.setText(String.format("%.2f", (Double.parseDouble(f_massa.getText()) / x)));
			}
		});
		t1.add(f_IndMasTel);
		b_20 = new JButton("Индекс Чулицкой");
		b_20.setHorizontalAlignment(JLabel.RIGHT);
		t1.add(b_20);
		b_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x1 = Double.parseDouble(f_okrplecha.getText());
				double x2 = Double.parseDouble(f_okrbedra.getText());
				double x3 = Double.parseDouble(f_okrgolov.getText());
				double x4 = Double.parseDouble(f_rost.getText());
				int vozrgod = Integer.parseInt(f_vozrgod.getText());
				double y = 0;
				y = x1 + x2 + x3 - x4;
				if (vozrgod <= 17 && vozrgod >= 14) {
					if (y == 6) {
						f_IndChulic.setBackground(Color.GREEN);
					} else
						f_IndChulic.setBackground(Color.RED);
				} else
					f_IndChulic.setBackground(Color.WHITE);
				f_IndChulic.setText(String.format("%.2f", y));
			}
		});
		t1.add(f_IndChulic);
		b_21 = new JButton("Индекс Андронеску");
		b_21.setHorizontalAlignment(JLabel.RIGHT);
		t1.add(b_21);
		b_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double x1 = Double.parseDouble(f_okrgivot.getText());
				double x4 = Double.parseDouble(f_rost.getText());
				double y = (x1 / x4) * 100;
				int vozrgod = Integer.parseInt(f_vozrgod.getText());
				if (vozrgod <= 17 && vozrgod >= 14) {
					if (y >= 41 && y <= 42) {
						f_IndAndrom.setBackground(Color.GREEN);
					} else
						f_IndAndrom.setBackground(Color.RED);
				} else
					f_IndAndrom.setBackground(Color.WHITE);
				f_IndAndrom.setText(String.format("%.1f", (x1 / x4) * 100));
			}
		});
		t1.add(f_IndAndrom);
		b_1 = new JButton("Пульсоксиметрия");
		b_1.setBackground(Color.GREEN);
		t1.add(b_1);
		b_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pulso == null)
					pulso = new Pulso(instance);
				pulso.setVisible(true);
			}
		});
		b_2 = new JButton("Измерение АД");
		b_2.setBackground(Color.GREEN);
		t1.add(b_2);
		b_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ad == null)
					ad = new AD(instance);
				ad.setVisible(true);
			}
		});
		b_3 = new JButton("ЭКГ");
		b_3.setBackground(Color.GREEN);
		t1.add(b_3);
		b_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ekg == null)
					ekg = new EKG(instance);
				ekg.setVisible(true);

			}
		});
		b_4 = new JButton("Спирометрия");
		b_4.setBackground(Color.GREEN);
		t1.add(b_4);
		b_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (spiro == null)
					spiro = new Spiro(instance);
				spiro.setVisible(true);
			}
		});

		JPanel t2 = new JPanel(new GridLayout(6, 4));
		c.addTab("ИЛ методы", t2);

		b_5 = new JButton("Общий анализ крови");
		b_5.setBackground(Color.GREEN);
		b_5.setEnabled(false);
		t2.add(b_5);
		b_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (obshiyKrovi == null)
					obshiyKrovi = new ObshiyKrovi(instance);
				obshiyKrovi.setVisible(true);
			}
		});

		b_6 = new JButton("Общий анализ мочи");
		b_6.setBackground(Color.GREEN);
		t2.add(b_6);
		b_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (obshiyMochi == null)
					obshiyMochi = new ObshiyMochi(instance);
				obshiyMochi.setVisible(true);
			}
		});

		b_7 = new JButton("Узи");
		b_7.setBackground(Color.GREEN);
		b_7.setEnabled(false);
		t2.add(b_7);
		b_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (uzi == null)
					uzi = new Uzi(instance);
				uzi.setVisible(true);
			}
		});

		JPanel t3 = new JPanel();
		c.addTab("Осмотр специалистов", t3);

		b_8 = new JButton("Хирург");
		b_8.setBackground(Color.GREEN);
		b_8.setEnabled(false);
		t3.add(b_8);
		b_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hirurg == null)
					hirurg = new Hirurg(instance);
				hirurg.setVisible(true);
			}
		});
		b_9 = new JButton("Стоматолог");
		b_9.setBackground(Color.GREEN);
		t3.add(b_9);
		b_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (stomatolog == null)
					stomatolog = new Stomatolog(instance);
				stomatolog.setVisible(true);
			}
		});
		b_10 = new JButton("Уролог");
		b_10.setBackground(Color.GREEN);
		t3.add(b_10);
		b_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (urolog == null)
					urolog = new Urolog(instance);
				urolog.setVisible(true);
			}
		});
		b_11 = new JButton("Гинеколог");
		b_11.setEnabled(false);
		b_11.setBackground(Color.GREEN);
		t3.add(b_11);
		b_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ginekolog == null)
					ginekolog = new Ginekolog(instance);
				ginekolog.setVisible(true);
			}
		});
		b_12 = new JButton("Эндокринолог");
		b_12.setBackground(Color.GREEN);
		b_12.setEnabled(false);
		t3.add(b_12);
		b_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (endo == null)
					endo = new Endo(instance);
				endo.setVisible(true);
			}
		});
		b_13 = new JButton("Невролог");
		b_13.setBackground(Color.GREEN);
		b_13.setEnabled(false);
		t3.add(b_13);
		b_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nevrolog == null)
					nevrolog = new Nevrolog(instance);
				nevrolog.setVisible(true);
			}
		});
		b_14 = new JButton("Травматолог");
		b_14.setBackground(Color.GREEN);
		b_14.setEnabled(false);
		t3.add(b_14);
		b_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (travmatolog == null)
					travmatolog = new Travmatolog(instance);
				travmatolog.setVisible(true);
			}
		});
		b_15 = new JButton("Офтальмолог");
		b_15.setBackground(Color.GREEN);
		b_15.setEnabled(false);
		t3.add(b_15);
		b_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (oftalmolog == null)
					oftalmolog = new Oftalmolog(instance);
				oftalmolog.setVisible(true);
			}
		});
		b_16 = new JButton("ЛОР-врач");
		b_16.setBackground(Color.GREEN);
		b_16.setEnabled(false);
		t3.add(b_16);
		b_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lor == null)
					lor = new Lor(instance);
				lor.setVisible(true);
			}
		});
		b_17 = new JButton("Психиатр детский");
		b_17.setBackground(Color.GREEN);
		t3.add(b_17);
		b_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (psihiatr == null)
					psihiatr = new Psihiatr(instance);
				psihiatr.setVisible(true);
			}
		});
		b_18 = new JButton("Педиатр");
		b_18.setBackground(Color.GREEN);
		t3.add(b_18);
		b_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pediatr == null)
					pediatr = new Pediatr(instance);
				if (f_pol.getSelectedItem() == "М") {
					pediatr.f_17.setEditable(false);
				}
				;
				if (f_pol.getSelectedItem() == "Ж") {
					pediatr.f_17.setEditable(true);
				}
				pediatr.setVisible(true);
			}
		});

		/*-- profosmotr definition
		
		CREATE TABLE profosmotr (
			id INTEGER PRIMARY KEY AUTOINCREMENT,
			polisnum TEXT,
			fio TEXT,
			godrozh INTEGER,
			mesrozh INTEGER,
			adresdom TEXT,
			pol TEXT,
			shkola TEXT,
			klass INTEGER,
			paral TEXT,
			osmotrdat TEXT,
			vozr INTEGER
		, okrgrud INTEGER, okrplecha INTEGER, okrgivot INTEGER, rost INTEGER, massa INTEGER, okrbedra INTEGER, okrgolov INTEGER, 
		IndMasTel INTEGER, IndChulic INTEGER, IndAndrom INTEGER, IndmasTel2 REAL);*/

		JPanel t4 = new JPanel();
		t4.add(new JLabel("2 этап профосмотра"));
		f_1 = new JTextArea();
		JScrollPane s_1 = new JScrollPane(f_1);
		s_1.setPreferredSize(new Dimension(300, 100));
		s_1.setMinimumSize(new Dimension(300, 100));
		t4.add(s_1);
		c.addTab("Заметки по второму этапу профосмотра", t4);
		cp.add(c, BorderLayout.CENTER);
		JPanel f = new JPanel();
		JButton b_19 = new JButton("Сохранить");
		f.add(b_19);
		b_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exist = 0;
				String sql = "select count(*) from profosmotr where id=?";
				String query = "insert into profosmotr (polisnum, fio, godrozh, pol, shkola, klass, paral, osmotrdat, vozr, okrgrud, "
						+ "okrplecha, okrgivot, rost, massa, okrbedra, okrgolov, IndChulic, IndAndrom, IndmasTel2, vozrmes, snils, nomkarti, adres, adresbol) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				String query2 = "update profosmotr set polisnum=?, fio=?, godrozh=?, pol=?, shkola=?, klass=?, paral=?, osmotrdat=?, vozr=?, okrgrud=?, "
						+ "okrplecha=?, okrgivot=?, rost=?, massa=?, okrbedra=?, okrgolov=?, IndChulic=?, IndAndrom=?, IndmasTel2=?, vozrmes=?, snils=?, nomkarti=?, adres=?, adresbol=? "
						+ "where id=?";
				
				try (PreparedStatement stmt = conn.prepareStatement(sql)) {
					stmt.setInt(1, id == null ? -1 : id);
					ResultSet rset = stmt.executeQuery();
					rset.next();
					exist = rset.getInt(1);
					rset.close();
				} catch (SQLException eh) {
					eh.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (exist == 0) {
					try (PreparedStatement stmt = conn.prepareStatement(query)) {
						stmt.setString(1, f_strahpol.getText());
						stmt.setString(2, f_fio.getText());
						stmt.setString(3, f_denrozh.getText());
						stmt.setString(4, (String) f_pol.getSelectedItem());
						stmt.setString(5, f_skola.getText());
						stmt.setString(6, f_class.getText());
						stmt.setString(7, f_paralel.getText());
						stmt.setString(8, f_dataosm.getText());
						stmt.setString(9, f_vozrgod.getText());
						stmt.setString(10, f_okrgrud.getText());
						stmt.setString(11, f_okrplecha.getText());
						stmt.setString(12, f_okrgivot.getText());
						stmt.setString(13, f_rost.getText());
						stmt.setString(14, f_massa.getText());
						stmt.setString(15, f_okrbedra.getText());
						stmt.setString(16, f_okrgolov.getText());
						stmt.setString(17, f_IndChulic.getText());
						stmt.setString(18, f_IndAndrom.getText());
						stmt.setString(19, f_IndMasTel.getText());
						stmt.setString(20, f_vozrmes.getText());
						stmt.setString(21, f_snils.getText());
						stmt.setString(22, f_nomkar.getText());
						stmt.setString(23, f_adres.getText());
						stmt.setString(24, f_adresbol.getText());

						int ret = stmt.executeUpdate();
						if (ret > 0) {
							ResultSet keys = stmt.getGeneratedKeys();
							if (keys.next()) {
								id = keys.getInt(1);

							} else {
								throw new SQLException("Creating user failed, no ID obtained.");
							}
						} else {
							throw new SQLException("Creating user failed, no row affected.");
						}
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка добавления данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					try (PreparedStatement stmt = conn.prepareStatement(query2)) {
						stmt.setString(1, f_strahpol.getText());
						stmt.setString(2, f_fio.getText());
						stmt.setString(3, f_denrozh.getText());
						stmt.setString(4, (String) f_pol.getSelectedItem());
						stmt.setString(5, f_skola.getText());
						stmt.setString(6, f_class.getText());
						stmt.setString(7, f_paralel.getText());
						stmt.setString(8, f_dataosm.getText());
						stmt.setString(9, f_vozrgod.getText());
						stmt.setString(10, f_okrgrud.getText());
						stmt.setString(11, f_okrplecha.getText());
						stmt.setString(12, f_okrgivot.getText());
						stmt.setString(13, f_rost.getText());
						stmt.setString(14, f_massa.getText());
						stmt.setString(15, f_okrbedra.getText());
						stmt.setString(16, f_okrgolov.getText());
						stmt.setString(17, f_IndChulic.getText());
						stmt.setString(18, f_IndAndrom.getText());
						stmt.setString(19, f_IndMasTel.getText());
						stmt.setString(20, f_vozrmes.getText());
						stmt.setString(21, f_snils.getText());
						stmt.setString(22, f_nomkar.getText());
						stmt.setString(23, f_adres.getText());
						stmt.setString(24, f_adresbol.getText());
						stmt.setInt(25, id);

						int ret = stmt.executeUpdate();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка изменения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}

				}
				if (pulso != null) {
					sql = "select count(*) from pulso where idosmotr=?";
					query = "insert into pulso(idosmotr, f_1,f_2,f_3) values(?, ?, ?, ?)";
					query2 = "update pulso set f_1=?,f_2=?,f_3=? " + "where idosmotr=?";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, pulso.f_1.getText());
							stmt.setString(3, pulso.f_2.getText());
							stmt.setString(4, pulso.f_3.isSelected() ? "Y" : "N");

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных пульсометрии",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							stmt.setString(1, pulso.f_1.getText());
							stmt.setString(2, pulso.f_2.getText());
							stmt.setString(3, pulso.f_3.isSelected() ? "Y" : "N");
							stmt.setInt(4, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных пульсометрии",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}

					}
				}

				if (ad != null) {
					sql = "select count(*) from AD where idosmotr=?";
					query2 = "update AD set f_1=?,f_2=?,f_3=? " + "where idosmotr=?";
					query = "insert into AD(idosmotr, f_1, f_2, f_3) values(?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, ad.f_1.getText());
							stmt.setString(3, ad.f_2.getText());
							stmt.setString(4, ad.f_3.isSelected() ? "Y" : "N");
							;

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных Артериального давления",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							stmt.setString(1, ad.f_1.getText());
							stmt.setString(2, ad.f_2.getText());
							stmt.setString(3, ad.f_3.isSelected() ? "Y" : "N");
							stmt.setInt(4, id);
							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных Артериального давления",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (ekg != null) {
					sql = "select count(*) from EKG where idosmotr=?";
					query2 = "update EKG set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=? "
							+ "where idosmotr=?";
					query = "insert into EKG (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, ekg.f_1.getText());
							stmt.setString(3, ekg.f_2.getText());
							stmt.setString(4, ekg.f_3.getText());
							stmt.setString(5, ekg.f_4.getText());
							stmt.setString(6, ekg.f_5.getText());
							stmt.setString(7, ekg.f_6.getText());
							stmt.setString(8, ekg.f_7.getText());
							stmt.setString(9, ekg.f_8.getText());
							stmt.setString(10, ekg.f_9.getText());
							stmt.setString(11, ekg.f_10.getText());
							stmt.setString(12, ekg.f_11.getText());
							stmt.setString(13, ekg.f_12.isSelected() ? "Y" : "N");

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных ЭКГ", "Предупреждение: ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							stmt.setString(1, ekg.f_1.getText());
							stmt.setString(2, ekg.f_2.getText());
							stmt.setString(3, ekg.f_3.getText());
							stmt.setString(4, ekg.f_4.getText());
							stmt.setString(5, ekg.f_5.getText());
							stmt.setString(6, ekg.f_6.getText());
							stmt.setString(7, ekg.f_7.getText());
							stmt.setString(8, ekg.f_8.getText());
							stmt.setString(9, ekg.f_9.getText());
							stmt.setString(10, ekg.f_10.getText());
							stmt.setString(11, ekg.f_11.getText());
							stmt.setString(12, ekg.f_12.isSelected() ? "Y" : "N");
							stmt.setInt(13, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных ЭКГ", "Предупреждение: ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}

				if (spiro != null) {
					sql = "select count(*) from spiro where idosmotr=?";
					query2 = "update spiro set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=? "
							+ "where idosmotr=?";
					query = "insert into Spiro (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, spiro.f_1.getText());
							stmt.setString(3, spiro.f_2.getText());
							stmt.setString(4, spiro.f_3.getText());
							stmt.setString(5, spiro.f_4.getText());
							stmt.setString(6, spiro.f_5.getText());
							stmt.setString(7, spiro.f_6.getText());
							stmt.setString(8, spiro.f_7.getText());
							stmt.setString(9, spiro.f_8.isSelected() ? "Y" : "N");
							;

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных спирометрии",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {

							stmt.setString(1, spiro.f_1.getText());
							stmt.setString(2, spiro.f_2.getText());
							stmt.setString(3, spiro.f_3.getText());
							stmt.setString(4, spiro.f_4.getText());
							stmt.setString(5, spiro.f_5.getText());
							stmt.setString(6, spiro.f_6.getText());
							stmt.setString(7, spiro.f_7.getText());
							stmt.setString(8, spiro.f_8.isSelected() ? "Y" : "N");
							stmt.setInt(9, id);
							;

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных спирометрии",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (obshiyKrovi != null) {
					sql = "select count(*) from obshiyKrovi where idosmotr=?";
					query2 = "update obshiyKrovi set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=?, f_13=?, f_14=?, f_15=?, f_16=?, f_17=?, f_18=?, f_19=?, f_20=?, f_21=?, f_22=? "
							+ "where idosmotr=?";
					query = "insert into ObshiyKrovi (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12, f_13, f_14, f_15, f_16, f_17, f_18, f_19, f_20, f_21, f_22) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, obshiyKrovi.f_1.getText());
							stmt.setString(3, obshiyKrovi.f_2.getText());
							stmt.setString(4, obshiyKrovi.f_3.getText());
							stmt.setString(5, obshiyKrovi.f_4.getText());
							stmt.setString(6, obshiyKrovi.f_5.getText());
							stmt.setString(7, obshiyKrovi.f_6.getText());
							stmt.setString(8, obshiyKrovi.f_7.getText());
							stmt.setString(9, obshiyKrovi.f_8.getText());
							stmt.setString(10, obshiyKrovi.f_9.getText());
							stmt.setString(11, obshiyKrovi.f_10.getText());
							stmt.setString(12, obshiyKrovi.f_11.getText());
							stmt.setString(13, obshiyKrovi.f_12.getText());
							stmt.setString(14, obshiyKrovi.f_13.getText());
							stmt.setString(15, obshiyKrovi.f_14.getText());
							stmt.setString(16, obshiyKrovi.f_15.getText());
							stmt.setString(17, obshiyKrovi.f_16.getText());
							stmt.setString(18, obshiyKrovi.f_17.getText());
							stmt.setString(19, obshiyKrovi.f_18.getText());
							stmt.setString(20, obshiyKrovi.f_19.getText());
							stmt.setString(21, obshiyKrovi.f_20.getText());
							stmt.setString(22, obshiyKrovi.f_21.getText());
							stmt.setString(23, obshiyKrovi.f_22.isSelected() ? "Y" : "N");

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных по крови", "Предупреждение: ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							stmt.setString(1, obshiyKrovi.f_1.getText());
							stmt.setString(2, obshiyKrovi.f_2.getText());
							stmt.setString(3, obshiyKrovi.f_3.getText());
							stmt.setString(4, obshiyKrovi.f_4.getText());
							stmt.setString(5, obshiyKrovi.f_5.getText());
							stmt.setString(6, obshiyKrovi.f_6.getText());
							stmt.setString(7, obshiyKrovi.f_7.getText());
							stmt.setString(8, obshiyKrovi.f_8.getText());
							stmt.setString(9, obshiyKrovi.f_9.getText());
							stmt.setString(10, obshiyKrovi.f_10.getText());
							stmt.setString(11, obshiyKrovi.f_11.getText());
							stmt.setString(12, obshiyKrovi.f_12.getText());
							stmt.setString(13, obshiyKrovi.f_13.getText());
							stmt.setString(14, obshiyKrovi.f_14.getText());
							stmt.setString(15, obshiyKrovi.f_15.getText());
							stmt.setString(16, obshiyKrovi.f_16.getText());
							stmt.setString(17, obshiyKrovi.f_17.getText());
							stmt.setString(18, obshiyKrovi.f_18.getText());
							stmt.setString(19, obshiyKrovi.f_19.getText());
							stmt.setString(20, obshiyKrovi.f_20.getText());
							stmt.setString(21, obshiyKrovi.f_21.getText());
							stmt.setString(22, obshiyKrovi.f_22.isSelected() ? "Y" : "N");
							stmt.setInt(23, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных по крови", "Предупреждение: ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (obshiyMochi != null) {
					sql = "select count(*) from obshiyMochi where idosmotr=?";
					query2 = "update obshiyMochi set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=?, f_13=?, f_14=?, f_15=?, f_16=?, f_17=?, f_18=?, f_19=?, f_20=?, f_21=?, f_22=?, f_23=?, f_24=?, f_25=?, f_26=?, f_27=? "
							+ "where idosmotr=?";
					query = "insert into ObshiyMochi (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12, f_13, f_14, f_15, f_16, f_17, f_18, f_19, f_20, f_21, f_22, f_23, f_24, f_25, f_26, f_27) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, obshiyMochi.f_1.getText());
							stmt.setString(3, obshiyMochi.f_2.getText());
							stmt.setString(4, obshiyMochi.f_3.getText());
							stmt.setString(5, obshiyMochi.f_4.getText());
							stmt.setString(6, obshiyMochi.f_5.getText());
							stmt.setString(7, obshiyMochi.f_6.getText());
							stmt.setString(8, obshiyMochi.f_7.getText());
							stmt.setString(9, obshiyMochi.f_8.getText());
							stmt.setString(10, obshiyMochi.f_9.getText());
							stmt.setString(11, obshiyMochi.f_10.getText());
							stmt.setString(12, obshiyMochi.f_11.getText());
							stmt.setString(13, obshiyMochi.f_12.getText());
							stmt.setString(14, obshiyMochi.f_13.getText());
							stmt.setString(15, obshiyMochi.f_14.getText());
							stmt.setString(16, obshiyMochi.f_15.getText());
							stmt.setString(17, obshiyMochi.f_16.getText());
							stmt.setString(18, obshiyMochi.f_17.getText());
							stmt.setString(19, obshiyMochi.f_18.getText());
							stmt.setString(20, obshiyMochi.f_19.getText());
							stmt.setString(21, obshiyMochi.f_20.getText());
							stmt.setString(22, obshiyMochi.f_21.getText());
							stmt.setString(23, obshiyMochi.f_22.getText());
							stmt.setString(24, obshiyMochi.f_23.getText());
							stmt.setString(25, obshiyMochi.f_24.getText());
							stmt.setString(26, obshiyMochi.f_25.getText());
							stmt.setString(27, obshiyMochi.f_26.getText());
							stmt.setString(28, obshiyMochi.f_27.isSelected() ? "Y" : "N");

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных по моче", "Предупреждение: ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							stmt.setString(1, obshiyMochi.f_1.getText());
							stmt.setString(2, obshiyMochi.f_2.getText());
							stmt.setString(3, obshiyMochi.f_3.getText());
							stmt.setString(4, obshiyMochi.f_4.getText());
							stmt.setString(5, obshiyMochi.f_5.getText());
							stmt.setString(6, obshiyMochi.f_6.getText());
							stmt.setString(7, obshiyMochi.f_7.getText());
							stmt.setString(8, obshiyMochi.f_8.getText());
							stmt.setString(9, obshiyMochi.f_9.getText());
							stmt.setString(10, obshiyMochi.f_10.getText());
							stmt.setString(11, obshiyMochi.f_11.getText());
							stmt.setString(12, obshiyMochi.f_12.getText());
							stmt.setString(13, obshiyMochi.f_13.getText());
							stmt.setString(14, obshiyMochi.f_14.getText());
							stmt.setString(15, obshiyMochi.f_15.getText());
							stmt.setString(16, obshiyMochi.f_16.getText());
							stmt.setString(17, obshiyMochi.f_17.getText());
							stmt.setString(18, obshiyMochi.f_18.getText());
							stmt.setString(19, obshiyMochi.f_19.getText());
							stmt.setString(20, obshiyMochi.f_20.getText());
							stmt.setString(21, obshiyMochi.f_21.getText());
							stmt.setString(22, obshiyMochi.f_22.getText());
							stmt.setString(23, obshiyMochi.f_23.getText());
							stmt.setString(24, obshiyMochi.f_24.getText());
							stmt.setString(25, obshiyMochi.f_25.getText());
							stmt.setString(26, obshiyMochi.f_26.getText());
							stmt.setString(27, obshiyMochi.f_27.isSelected() ? "Y" : "N");
							stmt.setInt(28, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных по моче", "Предупреждение: ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (uzi != null) {
					sql = "select count(*) from uzi where idosmotr=?";
					query2 = "update uzi set f_1=?, f_2=? " + "where idosmotr=?";
					query = "insert into Uzi (idosmotr, f_1, f_2) values(?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, uzi.f_1.getText());
							stmt.setString(3, uzi.f_2.isSelected() ? "Y" : "N");

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных по УЗИ", "Предупреждение: ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {

							stmt.setString(1, uzi.f_1.getText());
							stmt.setString(2, uzi.f_2.isSelected() ? "Y" : "N");
							stmt.setInt(3, id);
							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных по УЗИ", "Предупреждение: ",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (hirurg != null) {
					sql = "select count(*) from hirurg where idosmotr=?";
					query2 = "update hirurg set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=?, f_13=?, f_14=?, f_15=?, f_16=?, f_17=?, f_18=?, f_19=?, f_20=? "
							+ "where idosmotr=?";
					query = "insert into Hirurg (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12, f_13, f_14, f_15, f_16, f_17, f_18, f_19,f_20) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, hirurg.f_1.getText());
							stmt.setString(3, hirurg.f_2.getText());
							stmt.setString(4, hirurg.f_3.getText());
							stmt.setString(5, hirurg.f_4.getText());
							stmt.setString(6, hirurg.f_5.getText());
							stmt.setString(7, hirurg.f_6.getText());
							stmt.setString(8, hirurg.f_7.getText());
							stmt.setString(9, hirurg.f_8.getText());
							stmt.setString(10, hirurg.f_9.getText());
							stmt.setString(11, hirurg.f_10.getText());
							stmt.setString(12, hirurg.f_11.getText());
							stmt.setString(13, hirurg.f_12.getText());
							stmt.setString(14, hirurg.f_13.getText());
							stmt.setString(15, hirurg.f_14.getText());
							stmt.setString(16, hirurg.f_15.getText());
							stmt.setString(17, hirurg.f_16.getText());
							stmt.setString(18, hirurg.f_17.getText());
							stmt.setString(19, hirurg.f_18.getText());
							stmt.setString(20, (String) hirurg.f_mkb.getSelectedItem());
							stmt.setString(21, hirurg.f_mkbc.getText());

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Хирурга",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							stmt.setString(1, hirurg.f_1.getText());
							stmt.setString(2, hirurg.f_2.getText());
							stmt.setString(3, hirurg.f_3.getText());
							stmt.setString(4, hirurg.f_4.getText());
							stmt.setString(5, hirurg.f_5.getText());
							stmt.setString(6, hirurg.f_6.getText());
							stmt.setString(7, hirurg.f_7.getText());
							stmt.setString(8, hirurg.f_8.getText());
							stmt.setString(9, hirurg.f_9.getText());
							stmt.setString(10, hirurg.f_10.getText());
							stmt.setString(11, hirurg.f_11.getText());
							stmt.setString(12, hirurg.f_12.getText());
							stmt.setString(13, hirurg.f_13.getText());
							stmt.setString(14, hirurg.f_14.getText());
							stmt.setString(15, hirurg.f_15.getText());
							stmt.setString(16, hirurg.f_16.getText());
							stmt.setString(17, hirurg.f_17.getText());
							stmt.setString(18, hirurg.f_18.getText());
							stmt.setString(19, (String) hirurg.f_mkb.getSelectedItem());
							stmt.setString(20, hirurg.f_mkbc.getText());
							stmt.setInt(21, id);
							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Хирурга",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (stomatolog != null) {
					sql = "select count(*) from Stomatolog where idosmotr=?";
					query2 = "update Stomatolog set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=?, f_13=?, f_14=?, f_15=?, f_16=?, f_17=?, f_18=?, f_19=?, f_20=?, f_21=?, f_22=?, f_23=?, f_24=?, f_25=?, f_26=?, f_27=?, f_28=?, f_29=?, f_30=?, f_31=?, f_32=?, f_33=?, f_34=?, f_35=?, f_36=?, f_37=?, f_38=?, f_39=?, f_40=?, f_41=? "
							+ "where idosmotr=?";
					query = "insert into Stomatolog (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12, f_13, f_14, f_15, f_16, f_17, f_18, f_19, f_20, f_21, f_22, f_23, f_24, f_25, f_26, f_27, f_28, f_29, f_30, f_31, f_32, f_33, f_34, f_35, f_36, f_37, f_38, f_39, f_40,f_41) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, stomatolog.f_1.getText());
							stmt.setString(3, stomatolog.f_2.getText());
							stmt.setString(4, stomatolog.f_3.getText());
							stmt.setString(5, stomatolog.f_4.getText());
							stmt.setString(6, stomatolog.f_5.getText());
							stmt.setString(7, stomatolog.f_6.getText());
							stmt.setString(8, stomatolog.f_7.getText());
							stmt.setString(9, stomatolog.f_8.getText());
							stmt.setString(10, stomatolog.f_9.getText());
							stmt.setString(11, stomatolog.f_10.getText());
							stmt.setString(12, stomatolog.f_11.getText());
							stmt.setString(13, stomatolog.f_12.getText());
							stmt.setString(14, stomatolog.f_13.getText());
							stmt.setString(15, stomatolog.f_14.getText());
							stmt.setString(16, stomatolog.f_15.getText());
							stmt.setString(17, stomatolog.f_16.getText());
							stmt.setString(18, stomatolog.f_17.getText());
							stmt.setString(19, stomatolog.f_18.getText());
							stmt.setString(20, stomatolog.f_19.getText());
							stmt.setString(21, stomatolog.f_20.getText());
							stmt.setString(22, stomatolog.f_21.getText());
							stmt.setString(23, stomatolog.f_22.getText());
							stmt.setString(24, stomatolog.f_23.getText());
							stmt.setString(25, stomatolog.f_24.getText());
							stmt.setString(26, stomatolog.f_25.getText());
							stmt.setString(27, stomatolog.f_26.getText());
							stmt.setString(28, stomatolog.f_27.getText());
							stmt.setString(29, stomatolog.f_28.getText());
							stmt.setString(30, stomatolog.f_29.getText());
							stmt.setString(31, stomatolog.f_30.getText());
							stmt.setString(32, stomatolog.f_31.getText());
							stmt.setString(33, stomatolog.f_32.getText());
							stmt.setString(34, stomatolog.f_33.getText());
							stmt.setString(35, stomatolog.f_34.getText());
							stmt.setString(36, stomatolog.f_35.getText());
							stmt.setString(37, stomatolog.f_36.getText());
							stmt.setString(38, stomatolog.f_37.getText());
							stmt.setString(39, stomatolog.f_38.getText());
							stmt.setString(40, stomatolog.f_39.getText());
							stmt.setString(41, (String) stomatolog.f_mkb.getSelectedItem());
							stmt.setString(42, stomatolog.f_mkbc.getText());

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Стоматолога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							stmt.setString(1, stomatolog.f_1.getText());
							stmt.setString(2, stomatolog.f_2.getText());
							stmt.setString(3, stomatolog.f_3.getText());
							stmt.setString(4, stomatolog.f_4.getText());
							stmt.setString(5, stomatolog.f_5.getText());
							stmt.setString(6, stomatolog.f_6.getText());
							stmt.setString(7, stomatolog.f_7.getText());
							stmt.setString(8, stomatolog.f_8.getText());
							stmt.setString(9, stomatolog.f_9.getText());
							stmt.setString(10, stomatolog.f_10.getText());
							stmt.setString(11, stomatolog.f_11.getText());
							stmt.setString(12, stomatolog.f_12.getText());
							stmt.setString(13, stomatolog.f_13.getText());
							stmt.setString(14, stomatolog.f_14.getText());
							stmt.setString(15, stomatolog.f_15.getText());
							stmt.setString(16, stomatolog.f_16.getText());
							stmt.setString(17, stomatolog.f_17.getText());
							stmt.setString(18, stomatolog.f_18.getText());
							stmt.setString(19, stomatolog.f_19.getText());
							stmt.setString(20, stomatolog.f_20.getText());
							stmt.setString(21, stomatolog.f_21.getText());
							stmt.setString(22, stomatolog.f_22.getText());
							stmt.setString(23, stomatolog.f_23.getText());
							stmt.setString(24, stomatolog.f_24.getText());
							stmt.setString(25, stomatolog.f_25.getText());
							stmt.setString(26, stomatolog.f_26.getText());
							stmt.setString(27, stomatolog.f_27.getText());
							stmt.setString(28, stomatolog.f_28.getText());
							stmt.setString(29, stomatolog.f_29.getText());
							stmt.setString(30, stomatolog.f_30.getText());
							stmt.setString(31, stomatolog.f_31.getText());
							stmt.setString(32, stomatolog.f_32.getText());
							stmt.setString(33, stomatolog.f_33.getText());
							stmt.setString(34, stomatolog.f_34.getText());
							stmt.setString(35, stomatolog.f_35.getText());
							stmt.setString(36, stomatolog.f_36.getText());
							stmt.setString(37, stomatolog.f_37.getText());
							stmt.setString(38, stomatolog.f_38.getText());
							stmt.setString(39, stomatolog.f_39.getText());
							stmt.setString(40, (String) stomatolog.f_mkb.getSelectedItem());
							stmt.setString(41, stomatolog.f_mkbc.getText());
							stmt.setInt(42, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Стоматолога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (urolog != null) {
					sql = "select count(*) from Urolog where idosmotr=?";
					query2 = "update Urolog set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=?, f_13=? "
							+ "where idosmotr=?";
					query = "insert into Urolog (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12, f_13) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, urolog.f_1.getText());
							stmt.setString(3, urolog.f_2.getText());
							stmt.setString(4, urolog.f_3.getText());
							stmt.setString(5, urolog.f_4.getText());
							stmt.setString(6, urolog.f_5.getText());
							stmt.setString(7, urolog.f_6.getText());
							stmt.setString(8, urolog.f_7.getText());
							stmt.setString(9, urolog.f_8.getText());
							stmt.setString(10, urolog.f_9.getText());
							stmt.setString(11, urolog.f_10.getText());
							stmt.setString(12, urolog.f_11.getText());
							stmt.setString(13, (String) urolog.f_mkb.getSelectedItem());
							stmt.setString(14, urolog.f_mkbc.getText());

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Уролога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							stmt.setString(1, urolog.f_1.getText());
							stmt.setString(2, urolog.f_2.getText());
							stmt.setString(3, urolog.f_3.getText());
							stmt.setString(4, urolog.f_4.getText());
							stmt.setString(5, urolog.f_5.getText());
							stmt.setString(6, urolog.f_6.getText());
							stmt.setString(7, urolog.f_7.getText());
							stmt.setString(8, urolog.f_8.getText());
							stmt.setString(9, urolog.f_9.getText());
							stmt.setString(10, urolog.f_10.getText());
							stmt.setString(11, urolog.f_11.getText());
							stmt.setString(12, (String) urolog.f_mkb.getSelectedItem());
							stmt.setString(13, urolog.f_mkbc.getText());
							stmt.setInt(14, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Уролога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (ginekolog != null) {
					sql = "select count(*) from Ginekolog where idosmotr=?";
					query2 = "update Ginekolog set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=? "
							+ "where idosmotr=?";
					query = "insert into Ginekolog (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, ginekolog.f_1.getText());
							stmt.setString(3, ginekolog.f_2.getText());
							stmt.setString(4, ginekolog.f_3.getText());
							stmt.setString(5, ginekolog.f_4.getText());
							stmt.setString(6, ginekolog.f_5.getText());
							stmt.setString(7, ginekolog.f_6.getText());
							stmt.setString(8, ginekolog.f_7.getText());
							stmt.setString(9, ginekolog.f_8.getText());
							stmt.setString(10, ginekolog.f_9.getText());
							stmt.setString(11, (String) ginekolog.f_mkb.getSelectedItem());
							stmt.setString(12, ginekolog.f_mkbc.getText());

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Гинеколога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {

							stmt.setString(1, ginekolog.f_1.getText());
							stmt.setString(2, ginekolog.f_2.getText());
							stmt.setString(3, ginekolog.f_3.getText());
							stmt.setString(4, ginekolog.f_4.getText());
							stmt.setString(5, ginekolog.f_5.getText());
							stmt.setString(6, ginekolog.f_6.getText());
							stmt.setString(7, ginekolog.f_7.getText());
							stmt.setString(8, ginekolog.f_8.getText());
							stmt.setString(9, ginekolog.f_9.getText());
							stmt.setString(10, (String) ginekolog.f_mkb.getSelectedItem());
							stmt.setString(11, ginekolog.f_mkbc.getText());
							stmt.setInt(12, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Гинеколога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (endo != null) {
					sql = "select count(*) from Endo where idosmotr=?";
					query2 = "update Endo set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=? " + "where idosmotr=?";
					query = "insert into Endo (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6) values(?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, endo.f_1.getText());
							stmt.setString(3, endo.f_2.getText());
							stmt.setString(4, endo.f_3.getText());
							stmt.setString(5, endo.f_4.getText());
							stmt.setString(6, (String) endo.f_mkb.getSelectedItem());
							stmt.setString(7, endo.f_mkbc.getText());

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Эндокринолога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {

							stmt.setString(1, endo.f_1.getText());
							stmt.setString(2, endo.f_2.getText());
							stmt.setString(3, endo.f_3.getText());
							stmt.setString(4, endo.f_4.getText());
							stmt.setString(5, (String) endo.f_mkb.getSelectedItem());
							stmt.setString(6, endo.f_mkbc.getText());
							stmt.setInt(7, id);
							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Эндокринолога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (nevrolog != null) {
					sql = "select count(*) from Nevrolog where idosmotr=?";
					query2 = "update Nevrolog set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=?, f_13=?, f_14=?, f_15=?, f_16=?, f_17=?, f_18=?, f_19=?, f_20=?, f_21=?, f_22=?, f_23=?, f_24=?, f_25=?, f_26=?, f_27=? "
							+ "where idosmotr=?";
					query = "insert into Nevrolog (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12, f_13, f_14, f_15, f_16, f_17, f_18, f_19, f_20, f_21, f_22, f_23, f_24, f_25, f_26, f_27) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, nevrolog.f_1.getText());
							stmt.setString(3, nevrolog.f_2.getText());
							stmt.setString(4, nevrolog.f_3.getText());
							stmt.setString(5, nevrolog.f_4.getText());
							stmt.setString(6, nevrolog.f_5.getText());
							stmt.setString(7, nevrolog.f_6.getText());
							stmt.setString(8, nevrolog.f_7.getText());
							stmt.setString(9, nevrolog.f_8.getText());
							stmt.setString(10, nevrolog.f_9.getText());
							stmt.setString(11, nevrolog.f_10.getText());
							stmt.setString(12, nevrolog.f_11.getText());
							stmt.setString(13, nevrolog.f_12.getText());
							stmt.setString(14, nevrolog.f_13.getText());
							stmt.setString(15, nevrolog.f_14.getText());
							stmt.setString(16, nevrolog.f_15.getText());
							stmt.setString(17, nevrolog.f_16.getText());
							stmt.setString(18, nevrolog.f_17.getText());
							stmt.setString(19, nevrolog.f_18.getText());
							stmt.setString(20, nevrolog.f_19.getText());
							stmt.setString(21, nevrolog.f_20.getText());
							stmt.setString(22, nevrolog.f_21.getText());
							stmt.setString(23, nevrolog.f_22.getText());
							stmt.setString(24, nevrolog.f_23.getText());
							stmt.setString(25, nevrolog.f_24.getText());
							stmt.setString(26, nevrolog.f_25.getText());
							stmt.setString(27, (String) nevrolog.f_mkb.getSelectedItem());
							stmt.setString(28, nevrolog.f_mkbc.getText());

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Невролога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {

							stmt.setString(1, nevrolog.f_1.getText());
							stmt.setString(2, nevrolog.f_2.getText());
							stmt.setString(3, nevrolog.f_3.getText());
							stmt.setString(4, nevrolog.f_4.getText());
							stmt.setString(5, nevrolog.f_5.getText());
							stmt.setString(6, nevrolog.f_6.getText());
							stmt.setString(7, nevrolog.f_7.getText());
							stmt.setString(8, nevrolog.f_8.getText());
							stmt.setString(9, nevrolog.f_9.getText());
							stmt.setString(10, nevrolog.f_10.getText());
							stmt.setString(11, nevrolog.f_11.getText());
							stmt.setString(12, nevrolog.f_12.getText());
							stmt.setString(13, nevrolog.f_13.getText());
							stmt.setString(14, nevrolog.f_14.getText());
							stmt.setString(15, nevrolog.f_15.getText());
							stmt.setString(16, nevrolog.f_16.getText());
							stmt.setString(17, nevrolog.f_17.getText());
							stmt.setString(18, nevrolog.f_18.getText());
							stmt.setString(19, nevrolog.f_19.getText());
							stmt.setString(20, nevrolog.f_20.getText());
							stmt.setString(21, nevrolog.f_21.getText());
							stmt.setString(22, nevrolog.f_22.getText());
							stmt.setString(23, nevrolog.f_23.getText());
							stmt.setString(24, nevrolog.f_24.getText());
							stmt.setString(25, nevrolog.f_25.getText());
							stmt.setString(26, (String) nevrolog.f_mkb.getSelectedItem());
							stmt.setString(27, nevrolog.f_mkbc.getText());
							stmt.setInt(28, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Невролога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (travmatolog != null) {
					sql = "select count(*) from Travmatolog where idosmotr=?";
					query2 = "update Travmatolog set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=?, f_13=?, f_14=?, f_15=?, f_16=?, f_17=?, f_18=?, f_19=?, f_20=?, f_21=?, f_22=?, f_23=?, f_24=? "
							+ "where idosmotr=?";
					query = "insert into Travmatolog (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12, f_13, f_14, f_15, f_16, f_17, f_18, f_19, f_20, f_21, f_22, f_23, f_24) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, travmatolog.f_1.getText());
							stmt.setString(3, travmatolog.f_2.getText());
							stmt.setString(4, travmatolog.f_3.getText());
							stmt.setString(5, travmatolog.f_4.getText());
							stmt.setString(6, travmatolog.f_5.getText());
							stmt.setString(7, travmatolog.f_6.getText());
							stmt.setString(8, travmatolog.f_7.getText());
							stmt.setString(9, travmatolog.f_8.getText());
							stmt.setString(10, travmatolog.f_9.getText());
							stmt.setString(11, travmatolog.f_10.getText());
							stmt.setString(12, travmatolog.f_11.getText());
							stmt.setString(13, travmatolog.f_12.getText());
							stmt.setString(14, travmatolog.f_13.getText());
							stmt.setString(15, travmatolog.f_14.getText());
							stmt.setString(16, travmatolog.f_15.getText());
							stmt.setString(17, travmatolog.f_16.getText());
							stmt.setString(18, travmatolog.f_17.getText());
							stmt.setString(19, travmatolog.f_18.getText());
							stmt.setString(20, travmatolog.f_19.getText());
							stmt.setString(21, travmatolog.f_20.getText());
							stmt.setString(22, travmatolog.f_21.getText());
							stmt.setString(23, travmatolog.f_22.getText());
							stmt.setString(24, (String) travmatolog.f_mkb.getSelectedItem());
							stmt.setString(25, travmatolog.f_mkbc.getText());
							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Травмотолога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							stmt.setString(1, travmatolog.f_1.getText());
							stmt.setString(2, travmatolog.f_2.getText());
							stmt.setString(3, travmatolog.f_3.getText());
							stmt.setString(4, travmatolog.f_4.getText());
							stmt.setString(5, travmatolog.f_5.getText());
							stmt.setString(6, travmatolog.f_6.getText());
							stmt.setString(7, travmatolog.f_7.getText());
							stmt.setString(8, travmatolog.f_8.getText());
							stmt.setString(9, travmatolog.f_9.getText());
							stmt.setString(10, travmatolog.f_10.getText());
							stmt.setString(11, travmatolog.f_11.getText());
							stmt.setString(12, travmatolog.f_12.getText());
							stmt.setString(13, travmatolog.f_13.getText());
							stmt.setString(14, travmatolog.f_14.getText());
							stmt.setString(15, travmatolog.f_15.getText());
							stmt.setString(16, travmatolog.f_16.getText());
							stmt.setString(17, travmatolog.f_17.getText());
							stmt.setString(18, travmatolog.f_18.getText());
							stmt.setString(19, travmatolog.f_19.getText());
							stmt.setString(20, travmatolog.f_20.getText());
							stmt.setString(21, travmatolog.f_21.getText());
							stmt.setString(22, travmatolog.f_22.getText());
							stmt.setString(23, (String) travmatolog.f_mkb.getSelectedItem());
							stmt.setString(24, travmatolog.f_mkbc.getText());
							stmt.setInt(25, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Травмотолога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (oftalmolog != null) {
					sql = "select count(*) from oftalmolog where idosmotr=?";
					query2 = "update oftalmolog set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=?, f_13=?, f_14=?, f_15=?, f_16=?, f_17=?, f_18=?, f_19=?, f_20=?, f_21=? "
							+ "where idosmotr=?";
					query = "insert into Oftalmolog (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12, f_13, f_14, f_15, f_16, f_17, f_18, f_19, f_20, f_21) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, oftalmolog.f_1.getText());
							stmt.setString(3, oftalmolog.f_2.getText());
							stmt.setString(4, oftalmolog.f_3.getText());
							stmt.setString(5, oftalmolog.f_4.getText());
							stmt.setString(6, oftalmolog.f_5.getText());
							stmt.setString(7, oftalmolog.f_6.getText());
							stmt.setString(8, oftalmolog.f_7.getText());
							stmt.setString(9, oftalmolog.f_8.getText());
							stmt.setString(10, oftalmolog.f_9.getText());
							stmt.setString(11, oftalmolog.f_10.getText());
							stmt.setString(12, oftalmolog.f_11.getText());
							stmt.setString(13, oftalmolog.f_12.getText());
							stmt.setString(14, oftalmolog.f_13.getText());
							stmt.setString(15, oftalmolog.f_14.getText());
							stmt.setString(16, oftalmolog.f_15.getText());
							stmt.setString(17, oftalmolog.f_16.getText());
							stmt.setString(18, oftalmolog.f_17.getText());
							stmt.setString(19, oftalmolog.f_18.getText());
							stmt.setString(20, oftalmolog.f_19.getText());
							stmt.setString(21, (String) oftalmolog.f_mkb.getSelectedItem());
							stmt.setString(22, oftalmolog.f_mkbc.getText());

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Офтальмолога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							stmt.setString(1, oftalmolog.f_1.getText());
							stmt.setString(2, oftalmolog.f_2.getText());
							stmt.setString(3, oftalmolog.f_3.getText());
							stmt.setString(4, oftalmolog.f_4.getText());
							stmt.setString(5, oftalmolog.f_5.getText());
							stmt.setString(6, oftalmolog.f_6.getText());
							stmt.setString(7, oftalmolog.f_7.getText());
							stmt.setString(8, oftalmolog.f_8.getText());
							stmt.setString(9, oftalmolog.f_9.getText());
							stmt.setString(10, oftalmolog.f_10.getText());
							stmt.setString(11, oftalmolog.f_11.getText());
							stmt.setString(12, oftalmolog.f_12.getText());
							stmt.setString(13, oftalmolog.f_13.getText());
							stmt.setString(14, oftalmolog.f_14.getText());
							stmt.setString(15, oftalmolog.f_15.getText());
							stmt.setString(16, oftalmolog.f_16.getText());
							stmt.setString(17, oftalmolog.f_17.getText());
							stmt.setString(18, oftalmolog.f_18.getText());
							stmt.setString(19, oftalmolog.f_19.getText());
							stmt.setString(20, (String) oftalmolog.f_mkb.getSelectedItem());
							stmt.setString(21, oftalmolog.f_mkbc.getText());
							stmt.setInt(22, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Офтальмолога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (lor != null) {
					sql = "select count(*) from Lor where idosmotr=?";
					query2 = "update Lor set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=?, f_13=?, f_14=?, f_15=?, f_16=?, f_17=?, f_18=?, f_19=?, f_20=?, f_21=?, f_22=?, f_23=?, f_24=?, f_25=?, f_26=?, f_27=?, f_28=?, f_29=?, f_30=?, f_31=?, f_32=? "
							+ "where idosmotr=?";
					query = "insert into Lor (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12, f_13, f_14, f_15, f_16, f_17, f_18, f_19, f_20, f_21, f_22, f_23, f_24, f_25, f_26, f_27, f_28, f_29, f_30, f_31, f_32) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, lor.f_1.getText());
							stmt.setString(3, lor.f_2.getText());
							stmt.setString(4, lor.f_3.getText());
							stmt.setString(5, lor.f_4.getText());
							stmt.setString(6, lor.f_5.getText());
							stmt.setString(7, lor.f_6.getText());
							stmt.setString(8, lor.f_7.getText());
							stmt.setString(9, lor.f_8.getText());
							stmt.setString(10, lor.f_9.getText());
							stmt.setString(11, lor.f_10.getText());
							stmt.setString(12, lor.f_11.getText());
							stmt.setString(13, lor.f_12.getText());
							stmt.setString(14, lor.f_13.getText());
							stmt.setString(15, lor.f_14.getText());
							stmt.setString(16, lor.f_15.getText());
							stmt.setString(17, lor.f_16.getText());
							stmt.setString(18, lor.f_17.getText());
							stmt.setString(19, lor.f_18.getText());
							stmt.setString(20, lor.f_19.getText());
							stmt.setString(21, lor.f_20.getText());
							stmt.setString(22, lor.f_21.getText());
							stmt.setString(23, lor.f_22.getText());
							stmt.setString(24, lor.f_23.getText());
							stmt.setString(25, lor.f_24.getText());
							stmt.setString(26, lor.f_25.getText());
							stmt.setString(27, lor.f_26.getText());
							stmt.setString(28, lor.f_27.getText());
							stmt.setString(29, lor.f_28.getText());
							stmt.setString(30, lor.f_29.getText());
							stmt.setString(31, lor.f_30.getText());
							stmt.setString(32, (String) lor.f_mkb.getSelectedItem());
							stmt.setString(33, lor.f_mkbc.getText());

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления от Оталоринголога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {

							stmt.setString(1, lor.f_1.getText());
							stmt.setString(2, lor.f_2.getText());
							stmt.setString(3, lor.f_3.getText());
							stmt.setString(4, lor.f_4.getText());
							stmt.setString(5, lor.f_5.getText());
							stmt.setString(6, lor.f_6.getText());
							stmt.setString(7, lor.f_7.getText());
							stmt.setString(8, lor.f_8.getText());
							stmt.setString(9, lor.f_9.getText());
							stmt.setString(10, lor.f_10.getText());
							stmt.setString(11, lor.f_11.getText());
							stmt.setString(12, lor.f_12.getText());
							stmt.setString(13, lor.f_13.getText());
							stmt.setString(14, lor.f_14.getText());
							stmt.setString(15, lor.f_15.getText());
							stmt.setString(16, lor.f_16.getText());
							stmt.setString(17, lor.f_17.getText());
							stmt.setString(18, lor.f_18.getText());
							stmt.setString(19, lor.f_19.getText());
							stmt.setString(20, lor.f_20.getText());
							stmt.setString(21, lor.f_21.getText());
							stmt.setString(22, lor.f_22.getText());
							stmt.setString(23, lor.f_23.getText());
							stmt.setString(24, lor.f_24.getText());
							stmt.setString(25, lor.f_25.getText());
							stmt.setString(26, lor.f_26.getText());
							stmt.setString(27, lor.f_27.getText());
							stmt.setString(28, lor.f_28.getText());
							stmt.setString(29, lor.f_29.getText());
							stmt.setString(30, lor.f_30.getText());
							stmt.setString(31, (String) lor.f_mkb.getSelectedItem());
							stmt.setString(32, lor.f_mkbc.getText());
							stmt.setInt(33, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления от Оталоринголога",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
				if (psihiatr != null) {
					sql = "select count(*) from Psihiatr where idosmotr=?";
					query2 = "update Psihiatr set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=? " + "where idosmotr=?";
					query = "insert into Psihiatr (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6) values(?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, psihiatr.f_1.getText());
							stmt.setString(3, psihiatr.f_2.getText());
							stmt.setString(4, psihiatr.f_3.getText());
							stmt.setString(5, psihiatr.f_4.getText());
							stmt.setString(6, (String) psihiatr.f_mkb.getSelectedItem());
							stmt.setString(7, psihiatr.f_mkbc.getText());

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данныхданных от Психиатра",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {

							stmt.setString(1, psihiatr.f_1.getText());
							stmt.setString(2, psihiatr.f_2.getText());
							stmt.setString(3, psihiatr.f_3.getText());
							stmt.setString(4, psihiatr.f_4.getText());
							stmt.setString(5, (String) psihiatr.f_mkb.getSelectedItem());
							stmt.setString(6, psihiatr.f_mkbc.getText());
							stmt.setInt(7, id);

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данныхданных от Психиатра",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}

				}
				if (pediatr != null) {
					sql = "select count(*) from Pediatr where idosmotr=?";
					query2 = "update Pediatr set f_1=?, f_2=?, f_3=?, f_4=?, f_5=?, f_6=?, f_7=?, f_8=?, f_9=?, f_10=?, f_11=?, f_12=?, f_13=?, f_14=?, f_15=?, f_16=?, f_17=?, f_18=?, f_19=?, f_20=?, f_21=?, f_22=?, f_23=?, f_24=?, f_25=?, f_26=?, f_27=?, f_28=?, f_29=?, f_30=? "
							+ "where idosmotr=?";
					query = "insert into Pediatr (idosmotr, f_1, f_2, f_3, f_4, f_5, f_6, f_7, f_8, f_9, f_10, f_11, f_12, f_13, f_14, f_15, f_16, f_17, f_18, f_19, f_20, f_21, f_22, f_23, f_24, f_25, f_26, f_27, f_28, f_29, f_30) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					try (PreparedStatement stmt = conn.prepareStatement(sql)) {
						stmt.setInt(1, id);
						ResultSet rset = stmt.executeQuery();
						rset.next();
						exist = rset.getInt(1);
						rset.close();
					} catch (SQLException eh) {
						eh.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ошибка чтения данных", "Предупреждение: ",
								JOptionPane.INFORMATION_MESSAGE);
					}
					if (exist == 0) {
						try (PreparedStatement stmt = conn.prepareStatement(query)) {
							stmt.setInt(1, id);
							stmt.setString(2, pediatr.f_1.getText());
							stmt.setString(3, pediatr.f_2.getText());
							stmt.setString(4, pediatr.f_3.getText());
							stmt.setString(5, pediatr.f_4.getText());
							stmt.setString(6, pediatr.f_5.getText());
							stmt.setString(7, pediatr.f_6.getText());
							stmt.setString(8, pediatr.f_7.getText());
							stmt.setString(9, pediatr.f_8.getText());
							stmt.setString(10, pediatr.f_9.getText());
							stmt.setString(11, pediatr.f_10.getText());
							stmt.setString(12, pediatr.f_11.getText());
							stmt.setString(13, pediatr.f_12.getText());
							stmt.setString(14, pediatr.f_13.getText());
							stmt.setString(15, pediatr.f_14.getText());
							stmt.setString(16, pediatr.f_15.getText()); // stmt.setString(17, pediatr.f_16.getText());
							stmt.setString(18, pediatr.f_17.getText());
							stmt.setString(19, pediatr.f_18.getText());
							stmt.setString(20, (String) pediatr.f_mkb.getSelectedItem());
							stmt.setString(21, (String) pediatr.f_gruppaf.getSelectedItem());
							stmt.setString(22, (String) pediatr.f_gruppaz.getSelectedItem());
							stmt.setString(23, pediatr.f_22.getText());
							stmt.setString(24, pediatr.f_23.getText());
							stmt.setString(25, pediatr.f_24.getText());
							stmt.setString(26, pediatr.f_25.getText());
							stmt.setString(27, pediatr.f_26.getText());
							stmt.setString(28, pediatr.f_27.getText());
							stmt.setString(29, pediatr.f_28.getText());
							stmt.setString(30, pediatr.f_29.isSelected() ? "Y" : "N");
							stmt.setString(31, pediatr.f_mkbc.getText());

							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Педиатора",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						try (PreparedStatement stmt = conn.prepareStatement(query2)) {
							
							stmt.setString(1, pediatr.f_1.getText());
							stmt.setString(2, pediatr.f_2.getText());
							stmt.setString(3, pediatr.f_3.getText());
							stmt.setString(4, pediatr.f_4.getText());
							stmt.setString(5, pediatr.f_5.getText());
							stmt.setString(6, pediatr.f_6.getText());
							stmt.setString(7, pediatr.f_7.getText());
							stmt.setString(8, pediatr.f_8.getText());
							stmt.setString(9, pediatr.f_9.getText());
							stmt.setString(10, pediatr.f_10.getText());
							stmt.setString(11, pediatr.f_11.getText());
							stmt.setString(12, pediatr.f_12.getText());
							stmt.setString(13, pediatr.f_13.getText());
							stmt.setString(14, pediatr.f_14.getText());
							stmt.setString(15, pediatr.f_15.getText()); 
							//stmt.setString(16, pediatr.f_16.getText());
							stmt.setString(17, pediatr.f_17.getText());
							stmt.setString(18, pediatr.f_18.getText());
							stmt.setString(19, (String) pediatr.f_mkb.getSelectedItem());
							stmt.setString(20, (String) pediatr.f_gruppaf.getSelectedItem());
							stmt.setString(21, (String) pediatr.f_gruppaz.getSelectedItem());
							stmt.setString(22, pediatr.f_22.getText());
							stmt.setString(23, pediatr.f_23.getText());
							stmt.setString(24, pediatr.f_24.getText());
							stmt.setString(25, pediatr.f_25.getText());
							stmt.setString(26, pediatr.f_26.getText());
							stmt.setString(27, pediatr.f_27.getText());
							stmt.setString(28, pediatr.f_28.getText());
							stmt.setString(29, pediatr.f_29.isSelected() ? "Y" : "N");
							stmt.setString(30, pediatr.f_mkbc.getText());
							stmt.setInt(31, id);
							
							stmt.executeUpdate();
						} catch (SQLException eh) {
							eh.printStackTrace();
							JOptionPane.showMessageDialog(null, "Ошибка добавления данных от Педиатора",
									"Предупреждение: ", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}

			}
		});

		JButton b_24 = new JButton("Сформировать крату");
		f.add(b_24);
		b_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document myPDFDoc = new Document(PageSize.A4);
				//Font defFont = new Font(Font.HELVETICA, 8f, Font.NORMAL, Color.BLACK);
				FileOutputStream pdfOutputFile = null;
				try {
					pdfOutputFile = new FileOutputStream("sample1.pdf");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				final PdfWriter pdfWriter = PdfWriter.getInstance(myPDFDoc, pdfOutputFile);
				myPDFDoc.open();
				myPDFDoc.add(new Paragraph(
						"                  Карта профилактического медицинского осмотра несовершенолетнего"));
				myPDFDoc.add(new Paragraph("1. " + f_fio.getText() + "; пол: " + f_pol.getSelectedItem()
						+ "; дата рождения:" + f_denrozh.getText() + "; номер полиса ОМС: " + f_strahpol.getText()
						+ "; адрес проживания: " + f_adres.getText()));
				myPDFDoc.add(new Paragraph("2. Медицинская организация: " + f_adresbol.getText()));
				myPDFDoc.add(new Paragraph("3. Школа: " + f_skola.getText()));
				myPDFDoc.add(new Paragraph("4. Дата начала прохождения профосмотра: " + f_dataosm.getText()));
				if (pediatr != null) {
					myPDFDoc.add(new Paragraph("5. Оценка физического развитя. Рост: " + f_rost.getText() + " ; вес: "
							+ f_massa.getText() + " ; окружность груди: " + f_okrgrud.getText()
							+ " ; окружность плеча: " + f_okrplecha.getText() + " ; окружность живота: "
							+ f_okrgivot.getText() + " ; окружность бедра: " + f_okrbedra.getText()
							+ " ; окружность голени: " + f_okrgolov.getText() + " ; ИМТ: " + f_IndMasTel.getText()
							+ " ; Заключение: " + pediatr.f_6.getText()));
				} else {
					myPDFDoc.add(new Paragraph(
							"5. Оценка физического развитя. Рост: " + f_rost.getText() + " ; вес: " + f_massa.getText()
									+ " ; окружность груди: " + f_okrgrud.getText() + " ; окружность плеча: "
									+ f_okrplecha.getText() + " ; окружность живота: " + f_okrgivot.getText()
									+ " ; окружность бедра: " + f_okrbedra.getText() + " ; окружность голени: "
									+ f_okrgolov.getText() + " ; ИМТ: " + f_IndMasTel.getText() + " ; Заключение: "));
				}
				if (pediatr != null) {
					myPDFDoc.add(new Paragraph("6. Психомоторная сфера: " + pediatr.f_12.getText()));
				} else {
					myPDFDoc.add(new Paragraph("6. Психомоторная сфера: "));
				}
				if (pediatr != null) {
					myPDFDoc.add(new Paragraph("7. Эмоционально-вегетативная сфера: " + pediatr.f_14.getText()));
				} else {
					myPDFDoc.add(new Paragraph("7. Эмоционально-вегетативная сфера: "));
				}
				if (pediatr != null) {
					myPDFDoc.add(new Paragraph("8. Интелект: " + pediatr.f_13.getText()));
				} else {
					myPDFDoc.add(new Paragraph("8. Интелект: "));
				}
				if (pediatr != null) {
					myPDFDoc.add(new Paragraph("9. Оценка полового развитя: " + pediatr.f_15.getText()));
				} else {
					myPDFDoc.add(new Paragraph("9. Оценка полового развитя: "));
				}
				if (pediatr != null) {
					if (f_pol.getSelectedItem() == "Ж") {
						myPDFDoc.add(
								new Paragraph("9.5. Характеристика менструальной функции: " + pediatr.f_17.getText()));
					}
				}
				if (pediatr != null) {
					myPDFDoc.add(new Paragraph(
							"10. Состояние здоровья до проведения настоящего профосмотра: " + pediatr.f_18.getText()));
				} else {
					myPDFDoc.add(new Paragraph("10. Состояние здоровья до проведения настоящего профосмотра: "));
				}
				if (pediatr != null) {
					if (pediatr.f_24.getText().equals("")) {
						myPDFDoc.add(new Paragraph("11. Диспансерное наблюдение установлено: нет"));
					} else {
						myPDFDoc.add(
								new Paragraph("11. Диспансерное наблюдение установлено: " + pediatr.f_24.getText()));
					}
				} else {
					myPDFDoc.add(new Paragraph("11. Диспансерное наблюдение установлено: нет"));
				}
				if (endo != null) {
					if (endo.f_mkb.getSelectedItem() != "Z") {
						myPDFDoc.add(new Paragraph("Эндокриноголог - " + endo.f_mkb.getSelectedItem() + " "
								+ endo.f_mkbc.getText() + "\n"));
					}
				}
				if (ginekolog != null) {
					if (f_pol.getSelectedItem() == "Ж") {
						if (ginekolog.f_mkb.getSelectedItem() != "Z") {
							myPDFDoc.add(new Paragraph("Гинеколог - " + ginekolog.f_mkb.getSelectedItem() + " "
									+ ginekolog.f_mkbc.getText() + "\n"));
						}
					}
				}
				if (hirurg != null) {
					if (hirurg.f_mkb.getSelectedItem() != "Z") {
						myPDFDoc.add(new Paragraph(
								"Хирург - " + hirurg.f_mkb.getSelectedItem() + " " + hirurg.f_mkbc.getText() + "\n"));
					}
				}
				if (lor != null) {
					if (lor.f_mkb.getSelectedItem() != "Z") {
						myPDFDoc.add(new Paragraph(
								"ЛОР - " + lor.f_mkb.getSelectedItem() + " " + lor.f_mkbc.getText() + "\n"));
					}
				}
				if (nevrolog != null) {
					if (nevrolog.f_mkb.getSelectedItem() != "Z") {
						myPDFDoc.add(new Paragraph("Невролог - " + nevrolog.f_mkb.getSelectedItem() + " "
								+ nevrolog.f_mkbc.getText() + "\n"));
					}
				}
				if (oftalmolog != null) {
					if (oftalmolog.f_mkb.getSelectedItem() != "Z") {
						myPDFDoc.add(new Paragraph("Офтальмолог - " + oftalmolog.f_mkb.getSelectedItem() + " "
								+ oftalmolog.f_mkbc.getText() + "\n"));
					}
				}
				if (psihiatr != null) {
					if (psihiatr.f_mkb.getSelectedItem() != "Z") {
						myPDFDoc.add(new Paragraph("Психиатр - " + psihiatr.f_mkb.getSelectedItem() + " "
								+ psihiatr.f_mkbc.getText() + "\n"));
					}
				}
				if (stomatolog != null) {
					if (stomatolog.f_mkb.getSelectedItem() != "Z") {
						myPDFDoc.add(new Paragraph("Стоматолог - " + stomatolog.f_mkb.getSelectedItem() + " "
								+ stomatolog.f_mkbc.getText() + "\n"));
					}
				}
				if (travmatolog != null) {
					if (travmatolog.f_mkb.getSelectedItem() != "Z") {
						myPDFDoc.add(new Paragraph("Травматолог - " + travmatolog.f_mkb.getSelectedItem() + " "
								+ travmatolog.f_mkbc.getText() + "\n"));
					}
				}
				if (urolog != null) {
					if (f_pol.getSelectedItem() == "М") {
						if (urolog.f_mkb.getSelectedItem() != "Z") {
							myPDFDoc.add(new Paragraph("Уролог - " + urolog.f_mkb.getSelectedItem() + " "
									+ urolog.f_mkbc.getText() + "\n"));
						}
					}
				}
				if (pediatr != null) {
					myPDFDoc.add(new Paragraph("12. Группа здоровья - " + pediatr.f_gruppaz.getSelectedItem()));
				} else {
					myPDFDoc.add(new Paragraph("12. Группа здоровья - I"));
				}
				if (pediatr != null) {
					myPDFDoc.add(new Paragraph("13. Медицинская группа для занятия физической культурой - "
							+ pediatr.f_gruppaf.getSelectedItem()));
				} else
					myPDFDoc.add(new Paragraph("13. Медицинская группа для занятия физической культурой - I"));
				if (pediatr != null) {
					myPDFDoc.add(new Paragraph(
							"14. Состояние здоровья по результатам проведения настоящего профилактического осмотра - "
									+ pediatr.f_22.getText()));
				} else {
					myPDFDoc.add(new Paragraph(
							"14. Состояние здоровья по результатам проведения настоящего профилактического осмотра -   не определенно"));
				}
				if (pediatr != null) {
					if (pediatr.f_23 != null) {
						myPDFDoc.add(new Paragraph("15. Диагноз установлен впервые - " + pediatr.f_23.getText()));
					} else {
						myPDFDoc.add(new Paragraph("15. Диагноз установлен впервые - да"));
					}
				} else {
					myPDFDoc.add(new Paragraph("15. Диагноз установлен впервые - да"));
				}
				if (pediatr != null) {
					if (pediatr.f_25.getText().equals("")) {
						myPDFDoc.add(new Paragraph("16. Дополнительные консультации и иследования назначены: нет"));
					} else {
						myPDFDoc.add(
								new Paragraph("16. Диспансерное наблюдение установлено: " + pediatr.f_25.getText()));
					}
				} else {
					myPDFDoc.add(new Paragraph("16. Дополнительные консультации и иследования назначены: нет"));
				}
				if (pediatr != null) {
					if (pediatr.f_26.getText().equals("")) {
						myPDFDoc.add(new Paragraph("17. Лечение назначено: нет"));
					} else {
						myPDFDoc.add(new Paragraph("17. Лечение назначено: " + pediatr.f_26.getText()));
					}
				} else {
					myPDFDoc.add(new Paragraph("17. Лечение назначено: нет"));
				}
				if (pediatr != null) {
					if (pediatr.f_27.getText().equals("")) {
						myPDFDoc.add(new Paragraph(
								"18. Медицинская реабилитация и санаторно-курортное лечение назначено: нет"));
					} else {
						myPDFDoc.add(
								new Paragraph("18. Медицинская реабилитация и санаторно-курортное лечение назначено: "
										+ pediatr.f_27.getText()));
					}
				} else {
					myPDFDoc.add(
							new Paragraph("18. Медицинская реабилитация и санаторно-курортное лечение назначено: нет"));
				}
				myPDFDoc.close();
				pdfWriter.close();
			}

		});

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

	public void loadData(Integer id) {
		this.id = id;
		String query = "select * from profosmotr where id=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				f_fio.setText(rset.getString("fio"));
				f_dataosm.setText(rset.getString("osmotrdat"));
				f_denrozh.setText(rset.getString("godrozh"));
				f_vozrgod.setText(String.valueOf(rset.getInt("vozr")));
				f_vozrmes.setText(String.valueOf(rset.getInt("vozrmes")));
				f_pol.setSelectedIndex(rset.getString("pol").equals("М") ? 0 : 1);
				f_nomkar.setText(rset.getString("nomkarti"));
				f_snils.setText(rset.getString("snils"));
				f_strahpol.setText(rset.getString("polisnum"));
				f_skola.setText(rset.getString("shkola"));
				f_paralel.setText(rset.getString("paral"));
				f_class.setText(rset.getString("klass"));
				f_okrgrud.setText(String.valueOf(rset.getInt("okrgrud")));
				f_okrplecha.setText(String.valueOf(rset.getInt("okrplecha")));
				f_okrgivot.setText(String.valueOf(rset.getInt("okrgivot")));
				f_rost.setText(String.valueOf(rset.getInt("rost")));
				f_massa.setText(String.valueOf(rset.getInt("massa")));
				f_okrbedra.setText(String.valueOf(rset.getInt("okrbedra")));
				f_okrgolov.setText(String.valueOf(rset.getInt("okrgolov")));
				f_IndAndrom.setText(String.valueOf(rset.getInt("IndAndrom")));
				f_IndMasTel.setText(String.valueOf(rset.getDouble("IndMasTel2")));
				f_IndChulic.setText(String.valueOf(rset.getInt("IndChulic")));
				f_adres.setText(String.valueOf(rset.getString("adres")));
				f_adresbol.setText(String.valueOf(rset.getString("adresbol")));
			}
			rset.close();
			if (Integer.parseInt(f_vozrgod.getText()) >= 15) {
				b_5.setEnabled(true);
				b_7.setEnabled(true);
				b_8.setEnabled(true);
				b_12.setEnabled(true);
				b_12.setEnabled(true);
				b_13.setEnabled(true);
				b_14.setEnabled(true);
				b_15.setEnabled(true);
				b_16.setEnabled(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from pulso where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (pulso == null)
					pulso = new Pulso(instance);
				pulso.f_1.setText(rset.getString("f_1"));
				pulso.f_2.setText(rset.getString("f_2"));
				pulso.f_3.setSelected(
						rset.getString("f_3") == null ? false : rset.getString("f_3").equals("Y") ? true : false);
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from spiro where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (spiro == null)
					spiro = new Spiro(instance);
				spiro.f_1.setText(rset.getString("f_1"));
				spiro.f_2.setText(rset.getString("f_2"));
				spiro.f_3.setText(rset.getString("f_3"));
				spiro.f_4.setText(rset.getString("f_4"));
				spiro.f_5.setText(rset.getString("f_5"));
				spiro.f_6.setText(rset.getString("f_6"));
				spiro.f_7.setText(rset.getString("f_7"));
				spiro.f_8.setSelected(
						rset.getString("f_8") == null ? false : rset.getString("f_8").equals("Y") ? true : false);
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from AD where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (ad == null)
					ad = new AD(instance);
				ad.f_1.setText(rset.getString("f_1"));
				ad.f_2.setText(rset.getString("f_2"));
				ad.f_3.setSelected(
						rset.getString("f_3") == null ? false : rset.getString("f_3").equals("Y") ? true : false);
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from EKG where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (ekg == null)
					ekg = new EKG(instance);
				ekg.f_1.setText(rset.getString("f_1"));
				ekg.f_2.setText(rset.getString("f_2"));
				ekg.f_3.setText(rset.getString("f_3"));
				ekg.f_4.setText(rset.getString("f_4"));
				ekg.f_5.setText(rset.getString("f_5"));
				ekg.f_6.setText(rset.getString("f_6"));
				ekg.f_7.setText(rset.getString("f_7"));
				ekg.f_8.setText(rset.getString("f_8"));
				ekg.f_9.setText(rset.getString("f_9"));
				ekg.f_10.setText(rset.getString("f_10"));
				ekg.f_11.setText(rset.getString("f_11"));
				ekg.f_12.setSelected(
						rset.getString("f_12") == null ? false : rset.getString("f_12").equals("Y") ? true : false);
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from ObshiyKrovi where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (obshiyKrovi == null)
					obshiyKrovi = new ObshiyKrovi(instance);
				obshiyKrovi.f_1.setText(rset.getString("f_1"));
				obshiyKrovi.f_2.setText(rset.getString("f_2"));
				obshiyKrovi.f_3.setText(rset.getString("f_3"));
				obshiyKrovi.f_4.setText(rset.getString("f_4"));
				obshiyKrovi.f_5.setText(rset.getString("f_5"));
				obshiyKrovi.f_6.setText(rset.getString("f_6"));
				obshiyKrovi.f_7.setText(rset.getString("f_7"));
				obshiyKrovi.f_8.setText(rset.getString("f_8"));
				obshiyKrovi.f_9.setText(rset.getString("f_9"));
				obshiyKrovi.f_10.setText(rset.getString("f_10"));
				obshiyKrovi.f_11.setText(rset.getString("f_11"));
				obshiyKrovi.f_12.setText(rset.getString("f_12"));
				obshiyKrovi.f_13.setText(rset.getString("f_13"));
				obshiyKrovi.f_14.setText(rset.getString("f_14"));
				obshiyKrovi.f_15.setText(rset.getString("f_15"));
				obshiyKrovi.f_16.setText(rset.getString("f_16"));
				obshiyKrovi.f_17.setText(rset.getString("f_17"));
				obshiyKrovi.f_18.setText(rset.getString("f_18"));
				obshiyKrovi.f_19.setText(rset.getString("f_19"));
				obshiyKrovi.f_20.setText(rset.getString("f_20"));
				obshiyKrovi.f_21.setText(rset.getString("f_21"));
				obshiyKrovi.f_22.setSelected(
						rset.getString("f_22") == null ? false : rset.getString("f_22").equals("Y") ? true : false);
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from ObshiyMochi where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (obshiyMochi == null)
					obshiyMochi = new ObshiyMochi(instance);
				obshiyMochi.f_1.setText(rset.getString("f_1"));
				obshiyMochi.f_2.setText(rset.getString("f_2"));
				obshiyMochi.f_3.setText(rset.getString("f_3"));
				obshiyMochi.f_4.setText(rset.getString("f_4"));
				obshiyMochi.f_5.setText(rset.getString("f_5"));
				obshiyMochi.f_6.setText(rset.getString("f_6"));
				obshiyMochi.f_7.setText(rset.getString("f_7"));
				obshiyMochi.f_8.setText(rset.getString("f_8"));
				obshiyMochi.f_9.setText(rset.getString("f_9"));
				obshiyMochi.f_10.setText(rset.getString("f_10"));
				obshiyMochi.f_11.setText(rset.getString("f_11"));
				obshiyMochi.f_12.setText(rset.getString("f_12"));
				obshiyMochi.f_13.setText(rset.getString("f_13"));
				obshiyMochi.f_14.setText(rset.getString("f_14"));
				obshiyMochi.f_15.setText(rset.getString("f_15"));
				obshiyMochi.f_16.setText(rset.getString("f_16"));
				obshiyMochi.f_17.setText(rset.getString("f_17"));
				obshiyMochi.f_18.setText(rset.getString("f_18"));
				obshiyMochi.f_19.setText(rset.getString("f_19"));
				obshiyMochi.f_20.setText(rset.getString("f_20"));
				obshiyMochi.f_21.setText(rset.getString("f_21"));
				obshiyMochi.f_22.setText(rset.getString("f_22"));
				obshiyMochi.f_23.setText(rset.getString("f_23"));
				obshiyMochi.f_24.setText(rset.getString("f_24"));
				obshiyMochi.f_25.setText(rset.getString("f_25"));
				obshiyMochi.f_26.setText(rset.getString("f_26"));
				obshiyMochi.f_27.setSelected(
						rset.getString("f_27") == null ? false : rset.getString("f_27").equals("Y") ? true : false);
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from Uzi where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (uzi == null)
					uzi = new Uzi(instance);
				uzi.f_1.setText(rset.getString("f_1"));
				uzi.f_2.setSelected(
						rset.getString("f_2") == null ? false : rset.getString("f_2").equals("Y") ? true : false);
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from Endo where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (endo == null)
					endo = new Endo(instance);
				endo.f_1.setText(rset.getString("f_1"));
				endo.f_2.setText(rset.getString("f_2"));
				endo.f_3.setText(rset.getString("f_3"));
				endo.f_4.setText(rset.getString("f_4"));
				endo.f_mkb.setSelectedItem(rset.getString("f_5"));
				endo.f_mkbc.setText(rset.getString("f_6"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from Ginekolog where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (ginekolog == null)
					ginekolog = new Ginekolog(instance);
				ginekolog.f_1.setText(rset.getString("f_1"));
				ginekolog.f_2.setText(rset.getString("f_2"));
				ginekolog.f_3.setText(rset.getString("f_3"));
				ginekolog.f_4.setText(rset.getString("f_4"));
				ginekolog.f_5.setText(rset.getString("f_5"));
				ginekolog.f_6.setText(rset.getString("f_6"));
				ginekolog.f_7.setText(rset.getString("f_7"));
				ginekolog.f_8.setText(rset.getString("f_8"));
				ginekolog.f_9.setText(rset.getString("f_9"));
				ginekolog.f_mkb.setSelectedItem(rset.getString("f_10"));
				ginekolog.f_mkbc.setText(rset.getString("f_11"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from hirurg where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (hirurg == null)
					hirurg = new Hirurg(instance);
				hirurg.f_1.setText(rset.getString("f_1"));
				hirurg.f_2.setText(rset.getString("f_2"));
				hirurg.f_3.setText(rset.getString("f_3"));
				hirurg.f_4.setText(rset.getString("f_4"));
				hirurg.f_5.setText(rset.getString("f_5"));
				hirurg.f_6.setText(rset.getString("f_6"));
				hirurg.f_7.setText(rset.getString("f_7"));
				hirurg.f_8.setText(rset.getString("f_8"));
				hirurg.f_9.setText(rset.getString("f_9"));
				hirurg.f_10.setText(rset.getString("f_10"));
				hirurg.f_11.setText(rset.getString("f_11"));
				hirurg.f_12.setText(rset.getString("f_12"));
				hirurg.f_13.setText(rset.getString("f_13"));
				hirurg.f_14.setText(rset.getString("f_14"));
				hirurg.f_15.setText(rset.getString("f_15"));
				hirurg.f_16.setText(rset.getString("f_16"));
				hirurg.f_17.setText(rset.getString("f_17"));
				hirurg.f_18.setText(rset.getString("f_18"));
				hirurg.f_mkb.setSelectedItem(rset.getString("f_19"));
				hirurg.f_mkbc.setText(rset.getString("f_20"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from lor where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (lor == null)
					lor = new Lor(instance);
				lor.f_1.setText(rset.getString("f_1"));
				lor.f_2.setText(rset.getString("f_2"));
				lor.f_3.setText(rset.getString("f_3"));
				lor.f_4.setText(rset.getString("f_4"));
				lor.f_5.setText(rset.getString("f_5"));
				lor.f_6.setText(rset.getString("f_6"));
				lor.f_7.setText(rset.getString("f_7"));
				lor.f_8.setText(rset.getString("f_8"));
				lor.f_9.setText(rset.getString("f_9"));
				lor.f_10.setText(rset.getString("f_10"));
				lor.f_11.setText(rset.getString("f_11"));
				lor.f_12.setText(rset.getString("f_12"));
				lor.f_13.setText(rset.getString("f_13"));
				lor.f_14.setText(rset.getString("f_14"));
				lor.f_15.setText(rset.getString("f_15"));
				lor.f_16.setText(rset.getString("f_16"));
				lor.f_17.setText(rset.getString("f_17"));
				lor.f_18.setText(rset.getString("f_18"));
				lor.f_19.setText(rset.getString("f_19"));
				lor.f_20.setText(rset.getString("f_20"));
				lor.f_21.setText(rset.getString("f_21"));
				lor.f_22.setText(rset.getString("f_22"));
				lor.f_23.setText(rset.getString("f_23"));
				lor.f_24.setText(rset.getString("f_24"));
				lor.f_25.setText(rset.getString("f_25"));
				lor.f_26.setText(rset.getString("f_26"));
				lor.f_27.setText(rset.getString("f_27"));
				lor.f_28.setText(rset.getString("f_28"));
				lor.f_29.setText(rset.getString("f_29"));
				lor.f_30.setText(rset.getString("f_30"));
				lor.f_mkb.setSelectedItem(rset.getString("f_31"));
				lor.f_mkbc.setText(rset.getString("f_32"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from Nevrolog where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (nevrolog == null)
					nevrolog = new Nevrolog(instance);
				nevrolog.f_1.setText(rset.getString("f_1"));
				nevrolog.f_2.setText(rset.getString("f_2"));
				nevrolog.f_3.setText(rset.getString("f_3"));
				nevrolog.f_4.setText(rset.getString("f_4"));
				nevrolog.f_5.setText(rset.getString("f_5"));
				nevrolog.f_6.setText(rset.getString("f_6"));
				nevrolog.f_7.setText(rset.getString("f_7"));
				nevrolog.f_8.setText(rset.getString("f_8"));
				nevrolog.f_9.setText(rset.getString("f_9"));
				nevrolog.f_10.setText(rset.getString("f_10"));
				nevrolog.f_11.setText(rset.getString("f_11"));
				nevrolog.f_12.setText(rset.getString("f_12"));
				nevrolog.f_13.setText(rset.getString("f_13"));
				nevrolog.f_14.setText(rset.getString("f_14"));
				nevrolog.f_15.setText(rset.getString("f_15"));
				nevrolog.f_16.setText(rset.getString("f_16"));
				nevrolog.f_17.setText(rset.getString("f_17"));
				nevrolog.f_18.setText(rset.getString("f_18"));
				nevrolog.f_19.setText(rset.getString("f_19"));
				nevrolog.f_20.setText(rset.getString("f_20"));
				nevrolog.f_21.setText(rset.getString("f_21"));
				nevrolog.f_22.setText(rset.getString("f_22"));
				nevrolog.f_23.setText(rset.getString("f_23"));
				nevrolog.f_24.setText(rset.getString("f_24"));
				nevrolog.f_25.setText(rset.getString("f_25"));
				nevrolog.f_mkb.setSelectedItem(rset.getString("f_26"));
				nevrolog.f_mkbc.setText(rset.getString("f_27"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from oftalmolog where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (oftalmolog == null)
					oftalmolog = new Oftalmolog(instance);
				oftalmolog.f_1.setText(rset.getString("f_1"));
				oftalmolog.f_2.setText(rset.getString("f_2"));
				oftalmolog.f_3.setText(rset.getString("f_3"));
				oftalmolog.f_4.setText(rset.getString("f_4"));
				oftalmolog.f_5.setText(rset.getString("f_5"));
				oftalmolog.f_6.setText(rset.getString("f_6"));
				oftalmolog.f_7.setText(rset.getString("f_7"));
				oftalmolog.f_8.setText(rset.getString("f_8"));
				oftalmolog.f_9.setText(rset.getString("f_9"));
				oftalmolog.f_10.setText(rset.getString("f_10"));
				oftalmolog.f_11.setText(rset.getString("f_11"));
				oftalmolog.f_12.setText(rset.getString("f_12"));
				oftalmolog.f_13.setText(rset.getString("f_13"));
				oftalmolog.f_14.setText(rset.getString("f_14"));
				oftalmolog.f_15.setText(rset.getString("f_15"));
				oftalmolog.f_16.setText(rset.getString("f_16"));
				oftalmolog.f_17.setText(rset.getString("f_17"));
				oftalmolog.f_18.setText(rset.getString("f_18"));
				oftalmolog.f_19.setText(rset.getString("f_19"));
				oftalmolog.f_mkb.setSelectedItem(rset.getString("f_20"));
				oftalmolog.f_mkbc.setText(rset.getString("f_21"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from Psihiatr where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (psihiatr == null)
					psihiatr = new Psihiatr(instance);
				psihiatr.f_1.setText(rset.getString("f_1"));
				psihiatr.f_2.setText(rset.getString("f_2"));
				psihiatr.f_3.setText(rset.getString("f_3"));
				psihiatr.f_4.setText(rset.getString("f_4"));
				psihiatr.f_mkb.setSelectedItem(rset.getString("f_5"));
				psihiatr.f_mkbc.setText(rset.getString("f_6"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from stomatolog where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (stomatolog == null)
					stomatolog = new Stomatolog(instance);
				stomatolog.f_1.setText(rset.getString("f_1"));
				stomatolog.f_2.setText(rset.getString("f_2"));
				stomatolog.f_3.setText(rset.getString("f_3"));
				stomatolog.f_4.setText(rset.getString("f_4"));
				stomatolog.f_5.setText(rset.getString("f_5"));
				stomatolog.f_6.setText(rset.getString("f_6"));
				stomatolog.f_7.setText(rset.getString("f_7"));
				stomatolog.f_8.setText(rset.getString("f_8"));
				stomatolog.f_9.setText(rset.getString("f_9"));
				stomatolog.f_10.setText(rset.getString("f_10"));
				stomatolog.f_11.setText(rset.getString("f_11"));
				stomatolog.f_12.setText(rset.getString("f_12"));
				stomatolog.f_13.setText(rset.getString("f_13"));
				stomatolog.f_14.setText(rset.getString("f_14"));
				stomatolog.f_15.setText(rset.getString("f_15"));
				stomatolog.f_16.setText(rset.getString("f_16"));
				stomatolog.f_17.setText(rset.getString("f_17"));
				stomatolog.f_18.setText(rset.getString("f_18"));
				stomatolog.f_19.setText(rset.getString("f_19"));
				stomatolog.f_20.setText(rset.getString("f_20"));
				stomatolog.f_21.setText(rset.getString("f_21"));
				stomatolog.f_22.setText(rset.getString("f_22"));
				stomatolog.f_23.setText(rset.getString("f_23"));
				stomatolog.f_24.setText(rset.getString("f_24"));
				stomatolog.f_25.setText(rset.getString("f_25"));
				stomatolog.f_26.setText(rset.getString("f_26"));
				stomatolog.f_27.setText(rset.getString("f_27"));
				stomatolog.f_28.setText(rset.getString("f_28"));
				stomatolog.f_29.setText(rset.getString("f_29"));
				stomatolog.f_30.setText(rset.getString("f_30"));
				stomatolog.f_31.setText(rset.getString("f_31"));
				stomatolog.f_32.setText(rset.getString("f_32"));
				stomatolog.f_33.setText(rset.getString("f_33"));
				stomatolog.f_34.setText(rset.getString("f_34"));
				stomatolog.f_35.setText(rset.getString("f_35"));
				stomatolog.f_36.setText(rset.getString("f_36"));
				stomatolog.f_37.setText(rset.getString("f_37"));
				stomatolog.f_38.setText(rset.getString("f_38"));
				stomatolog.f_39.setText(rset.getString("f_39"));
				stomatolog.f_mkb.setSelectedItem(rset.getString("f_40"));
				stomatolog.f_mkbc.setText(rset.getString("f_41"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from Travmatolog where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (travmatolog == null)
					travmatolog = new Travmatolog(instance);
				travmatolog.f_1.setText(rset.getString("f_1"));
				travmatolog.f_2.setText(rset.getString("f_2"));
				travmatolog.f_3.setText(rset.getString("f_3"));
				travmatolog.f_4.setText(rset.getString("f_4"));
				travmatolog.f_5.setText(rset.getString("f_5"));
				travmatolog.f_6.setText(rset.getString("f_6"));
				travmatolog.f_7.setText(rset.getString("f_7"));
				travmatolog.f_8.setText(rset.getString("f_8"));
				travmatolog.f_9.setText(rset.getString("f_9"));
				travmatolog.f_10.setText(rset.getString("f_10"));
				travmatolog.f_11.setText(rset.getString("f_11"));
				travmatolog.f_12.setText(rset.getString("f_12"));
				travmatolog.f_13.setText(rset.getString("f_13"));
				travmatolog.f_14.setText(rset.getString("f_14"));
				travmatolog.f_15.setText(rset.getString("f_15"));
				travmatolog.f_16.setText(rset.getString("f_16"));
				travmatolog.f_17.setText(rset.getString("f_17"));
				travmatolog.f_18.setText(rset.getString("f_18"));
				travmatolog.f_19.setText(rset.getString("f_19"));
				travmatolog.f_20.setText(rset.getString("f_20"));
				travmatolog.f_21.setText(rset.getString("f_21"));
				travmatolog.f_22.setText(rset.getString("f_22"));
				travmatolog.f_mkb.setSelectedItem(rset.getString("f_23"));
				travmatolog.f_mkbc.setText(rset.getString("f_24"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from Urolog where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (urolog == null)
					urolog = new Urolog(instance);
				urolog.f_1.setText(rset.getString("f_1"));
				urolog.f_2.setText(rset.getString("f_2"));
				urolog.f_3.setText(rset.getString("f_3"));
				urolog.f_4.setText(rset.getString("f_4"));
				urolog.f_5.setText(rset.getString("f_5"));
				urolog.f_6.setText(rset.getString("f_6"));
				urolog.f_7.setText(rset.getString("f_7"));
				urolog.f_8.setText(rset.getString("f_8"));
				urolog.f_9.setText(rset.getString("f_9"));
				urolog.f_10.setText(rset.getString("f_10"));
				urolog.f_11.setText(rset.getString("f_11"));
				urolog.f_mkb.setSelectedItem(rset.getString("f_12"));
				urolog.f_mkbc.setText(rset.getString("f_13"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		query = "select * from pediatr where idosmotr=?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, id);
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) {
				if (pediatr == null)
					pediatr = new Pediatr(instance);
				pediatr.f_1.setText(rset.getString("f_1"));
				pediatr.f_2.setText(rset.getString("f_2"));
				pediatr.f_3.setText(rset.getString("f_3"));
				pediatr.f_4.setText(rset.getString("f_4"));
				pediatr.f_5.setText(rset.getString("f_5"));
				pediatr.f_6.setText(rset.getString("f_6"));
				pediatr.f_7.setText(rset.getString("f_7"));
				pediatr.f_8.setText(rset.getString("f_8"));
				pediatr.f_9.setText(rset.getString("f_9"));
				pediatr.f_10.setText(rset.getString("f_10"));
				pediatr.f_11.setText(rset.getString("f_11"));
				pediatr.f_12.setText(rset.getString("f_12"));
				pediatr.f_13.setText(rset.getString("f_13"));
				pediatr.f_14.setText(rset.getString("f_14"));
				pediatr.f_15.setText(rset.getString("f_15"));
				// pediatr.f_16.setText(rset.getString("f_16"));
				pediatr.f_17.setText(rset.getString("f_17"));
				pediatr.f_18.setText(rset.getString("f_18"));
				pediatr.f_22.setText(rset.getString("f_22"));
				pediatr.f_23.setText(rset.getString("f_23"));
				pediatr.f_24.setText(rset.getString("f_24"));
				pediatr.f_25.setText(rset.getString("f_25"));
				pediatr.f_26.setText(rset.getString("f_26"));
				pediatr.f_27.setText(rset.getString("f_27"));
				pediatr.f_28.setText(rset.getString("f_28"));
				pediatr.f_29.setSelected(
						rset.getString("f_29") == null ? false : rset.getString("f_29").equals("Y") ? true : false);
				pediatr.f_gruppaf.setSelectedItem(rset.getString("f_20"));
				pediatr.f_gruppaz.setSelectedItem(rset.getString("f_21"));
				pediatr.f_mkb.setSelectedItem(rset.getString("f_19"));
				pediatr.f_mkbc.setText(rset.getString("f_30"));
			}
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
