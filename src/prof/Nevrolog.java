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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Nevrolog extends JDialog {
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
	JComboBox<String> f_mkb = null;
	JTextField f_mkbc;
	
	public Nevrolog(Osmotr osmotr) {
		super(osmotr, "Невролог", Dialog.ModalityType.DOCUMENT_MODAL);
		String mkb[] = {"Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "w", "X", "Y" };
		f_mkb = new JComboBox<String>(mkb);
		setBounds(132, 132, 1200, 1000);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel c = new JPanel(new GridLayout(27, 4));
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
		l = new JLabel("Сознание");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_3 = new JTextField();
		c.add(f_3);
		l = new JLabel("Менингеальные симптомы:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_4 = new JTextField();
		c.add(f_4);
		l = new JLabel("Обоняние:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_5 = new JTextField();
		c.add(f_5);
		l = new JLabel("Зрение:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_6 = new JTextField();
		c.add(f_6);
		l = new JLabel("Глазодвигательные функции:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_7 = new JTextField();
		c.add(f_7);
		l = new JLabel("Функции тройничного нерва: ");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_8 = new JTextField();
		c.add(f_8);
		l = new JLabel("Лицевой нерв: ");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_9 = new JTextField();
		c.add(f_9);
		l = new JLabel("Слух и вестибулярные функции: ");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_10 = new JTextField();
		c.add(f_10);
		l = new JLabel("Языкоглоточный   нерв   и  блуждающий  нерв: ");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_11 = new JTextField();
		c.add(f_11);
		l = new JLabel("Добавочный нерв:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_12 = new JTextField();
		c.add(f_12);
		l = new JLabel("Подъязычный нерв:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_13 = new JTextField();
		c.add(f_13);
		l = new JLabel("Бульбарный синдром:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_14 = new JTextField();
		c.add(f_14);
		l = new JLabel("Двигательная   сфера:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_15 = new JTextField();
		c.add(f_15);
		l = new JLabel("Двигательная гиперактивность:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_16 = new JTextField();
		c.add(f_16);
		l = new JLabel("Чувствительная сфера:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_17 = new JTextField();
		c.add(f_17);
		l = new JLabel("Вегетативная сфера:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_18 = new JTextField();
		c.add(f_18);
		l = new JLabel("Тазовые функции:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_19 = new JTextField();
		c.add(f_19);
		l = new JLabel("Энурез:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_20 = new JTextField();
		c.add(f_20);
		l = new JLabel("Эмоциональная   сфера:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_21 = new JTextField();
		c.add(f_21);
		l = new JLabel("Проводимые манипуляции:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_22 = new JTextField();
		c.add(f_22);
		l = new JLabel("Дополнительные данные:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_23 = new JTextField();
		c.add(f_23);	
		l = new JLabel("Диагноз");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_24 = new JTextField();
		c.add(f_24);
		l = new JLabel("Заключение по осмотру (здоров,  практически  здоров,  болен,  нуждается  в  лечении)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_25 = new JTextField();
		c.add(f_25);
		l = new JLabel("Состояние здоровья (код по МКБ):");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_mkb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (!arg0.getItem().equals("Z")) {
					osmotr.b_13.setBackground(Color.RED);
				} else {
					osmotr.b_13.setBackground(Color.GREEN);
				}
			}

		});
		JPanel cmkb = new JPanel();
		cmkb.add(f_mkb);
		f_mkbc = new JTextField();
		f_mkbc.setPreferredSize(new Dimension(50,25));
		cmkb.add(f_mkbc);
		c.add(cmkb);
	
		
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
