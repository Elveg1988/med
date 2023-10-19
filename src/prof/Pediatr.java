package prof;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pediatr extends JDialog {
	private static final long serialVersionUID = 1L;
	JTextField f_1;
	JTextField f_2;
	JTextField f_3;
	JTextField f_4;
	JTextField f_5;
	JTextField f_6;
	JTextField f_7;
	JTextField f_8;
	JTextField f_9;
	JTextField f_10;
	JTextField f_11;
	JTextField f_12;
	JTextField f_13;
	JTextField f_14;
	JTextField f_15;
	JTextField f_16;
	JTextField f_17;
	JTextField f_18;
	JTextField f_19;
	JTextField f_20;
	JTextField f_21;
	JTextField f_22;
	JTextField f_23;
	JTextField f_24;
	JTextField f_25;
	JTextField f_26;
	JTextField f_27;
	JTextField f_28;
	JCheckBox f_29;
	JComboBox<String> f_gruppaz = null;
	JComboBox<String> f_gruppaf = null;
	JComboBox<String> f_mkb = null;
	JTextField f_mkbc;
	
	public Pediatr(Osmotr osmotr) {
		super(osmotr, "Педиатр", Dialog.ModalityType.DOCUMENT_MODAL);
		String gruppaz[] = { "I", "II", "III", "IV", "V" };
		f_gruppaz = new JComboBox<String>(gruppaz);
		String gruppaf[] = { "I", "II", "III", "IV", "не допущен" };
		f_gruppaf = new JComboBox<String>(gruppaf);
		String mkb[] = {"Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y" };
		f_mkb = new JComboBox<String>(mkb);
		setBounds(132, 132, 1200, 1000);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel c = new JPanel(new GridLayout(29, 4));
		JLabel l;
		l = new JLabel("Жалобы");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_1 = new JTextField();
		c.add(f_1);
		l = new JLabel("Анамнез");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_2 = new JTextField();
		c.add(f_2);
		l = new JLabel("масса (кг)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_3 = new JTextField();
		f_3.setText(osmotr.f_massa.getText());
		c.add(f_3);
		l = new JLabel("рост (см)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_4 = new JTextField();
		f_4.setText(osmotr.f_rost.getText());
		c.add(f_4);
		l = new JLabel("окружность головы для детей до 4-х лет(см)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_5 = new JTextField();
		c.add(f_5);
		l = new JLabel("физическое развитие");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_6 = new JTextField();
		c.add(f_6);
		l = new JLabel("нарушения");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_7 = new JTextField();
		c.add(f_7);
		l = new JLabel("познавательная функция");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_8 = new JTextField();
		c.add(f_8);
		l = new JLabel("моторная функция");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_9 = new JTextField();
		c.add(f_9);
		l = new JLabel("эмоциональная и социальная");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_10 = new JTextField();
		c.add(f_10);
		l = new JLabel("речевое развитие");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_11 = new JTextField();
		c.add(f_11);
		l = new JLabel("Психомоторная сфера: ");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_12 = new JTextField();
		c.add(f_12);
		l = new JLabel("Интеллект:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_13 = new JTextField();
		c.add(f_13);
		l = new JLabel("Эмоционально-вегетативная cфера:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_14 = new JTextField();
		c.add(f_14);
		l = new JLabel("Оценка полового развития: ");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_15 = new JTextField();
		c.add(f_15);
		l = new JLabel("Характеристика менструальной функции для Д: ");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_17 = new JTextField();
		c.add(f_17);
		l = new JLabel("Состояние здоровья до проведения настоящего профилактического осмотра:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_18 = new JTextField();
		c.add(f_18);
		l = new JLabel("Состояние здоровья по результатам настоящего профилактического осмотра (код по МКБ):");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		//f_19 = new JTextField();
		f_mkb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (!arg0.getItem().equals("Z")) {
					osmotr.b_18.setBackground(Color.RED);
				} else {
					osmotr.b_18.setBackground(Color.GREEN);
				}
			}

		});
		JPanel cmkb = new JPanel();
		cmkb.add(f_mkb);
		f_mkbc = new JTextField();
		f_mkbc.setPreferredSize(new Dimension(50,25));
		cmkb.add(f_mkbc);
		c.add(cmkb);
		l = new JLabel("Медицинская группа для занятий физической культурой:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		//f_20 = new JTextField();
		c.add(f_gruppaf);
		l = new JLabel("Группа здоровья:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		//f_21 = new JTextField();
		c.add(f_gruppaz);
		l = new JLabel("Диагноз:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_22 = new JTextField();
		c.add(f_22);
		l = new JLabel("Диагноз установлен впервые:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_23 = new JTextField();
		c.add(f_23);	
		l = new JLabel("Диспансерное наблюдение установлено:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_24 = new JTextField();
		c.add(f_24);
		l = new JLabel("Дополнительные консультации и исследования назначены:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_25 = new JTextField();
		c.add(f_25);
		l = new JLabel("Дополнительные консультации и исследования выполнены:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_26 = new JTextField();
		c.add(f_26);	
		l = new JLabel("Лечение назначено:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_27 = new JTextField();
		c.add(f_27);	
		l = new JLabel("Медицинская реабилитация и (или) санаторно-курортное лечение назначены:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_28 = new JTextField();
		c.add(f_28);	
		
		l = new JLabel("Направление на второй этап проф.осмотра");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_29 = new JCheckBox();
		c.add(f_29);
	
		
		JButton b_2 = new JButton("Выход");
		c.add(b_2);
		b_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		cp.add(c, BorderLayout.CENTER);
		

	}
}
