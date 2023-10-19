package prof;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ObshiyMochi extends JDialog {
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
	JCheckBox f_27;
	
	public ObshiyMochi(Osmotr osmotr) {
		super(osmotr, "Общий анализ мочи", Dialog.ModalityType.DOCUMENT_MODAL);
		setBounds(132, 132, 600, 550);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel c = new JPanel(new GridLayout(28, 4));
		JLabel l;
		l = new JLabel("Количество");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_1 = new JTextField();
		c.add(f_1);
		l = new JLabel("Цвет");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_2 = new JTextField();
		c.add(f_2);
		l = new JLabel("Прозрачность");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_3 = new JTextField();
		c.add(f_3);
		l = new JLabel("Относительная плотность");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_4 = new JTextField();
		c.add(f_4);
		l = new JLabel("Реакция");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_5 = new JTextField();
		c.add(f_5);
		l = new JLabel("Белок");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_6 = new JTextField();
		c.add(f_6);
		l = new JLabel("Глюкоза");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_7 = new JTextField();
		c.add(f_7);
		l = new JLabel("Кетоновые тела");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_8 = new JTextField();
		c.add(f_8);
		l = new JLabel("Реакция на кровь");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_9 = new JTextField();
		c.add(f_9);
		l = new JLabel("Билирубин");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_10 = new JTextField();
		c.add(f_10);
		l = new JLabel("Уробилиноиды");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_11 = new JTextField();
		c.add(f_11);
		l = new JLabel("Желчные кислоты");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_12 = new JTextField();
		c.add(f_12);
		l = new JLabel("Эпителий плоский (п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_13 = new JTextField();
		c.add(f_13);
		l = new JLabel("Эпителий переходный (п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_14 = new JTextField();
		c.add(f_14);
		l = new JLabel("Эпителий почечный (п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_15 = new JTextField();
		c.add(f_15);
		l = new JLabel("Лейкоциты (п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_16 = new JTextField();
		c.add(f_16);
		l = new JLabel("Эритроциты (п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_17 = new JTextField();
		c.add(f_17);
		l = new JLabel("Цилиндры геалиновые (в п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_18 = new JTextField();
		c.add(f_18);
		l = new JLabel("Цилиндры зернистые (в п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_19 = new JTextField();
		c.add(f_19);
		l = new JLabel("Цилиндры восковидные (в п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_20 = new JTextField();
		c.add(f_20);
		l = new JLabel("Цилиндры эпитеальные (в п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_21 = new JTextField();
		c.add(f_21);
		l = new JLabel("Цилиндры лейкоцитарные (в п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_22 = new JTextField();
		c.add(f_22);
		l = new JLabel("Цилиндры пигментные (в п/зр)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_23 = new JTextField();
		c.add(f_23);
		l = new JLabel("Слизь");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_24 = new JTextField();
		c.add(f_24);
		l = new JLabel("Соли");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_25 = new JTextField();
		c.add(f_25);
		l = new JLabel("Бактерии");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_26 = new JTextField();
		c.add(f_26);
	
		l = new JLabel("Патология");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_27 = new JCheckBox();
		f_27.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					osmotr.b_6.setBackground(Color.RED);
				} else {
					osmotr.b_6.setBackground(Color.GREEN);
				}
			}
		});
		c.add(f_27);
		
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
