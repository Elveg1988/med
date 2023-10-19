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

public class Stomatolog extends JDialog {
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
	JTextField f_29;
	JTextField f_30;
	JTextField f_31;
	JTextField f_32;
	JTextField f_33;
	JTextField f_34;
	JTextField f_35;
	JTextField f_36;
	JTextField f_37;
	JTextField f_38;
	JTextField f_39;
	JComboBox<String> f_mkb = null;
	JTextField f_mkbc;
	
	public Stomatolog(Osmotr osmotr) {
		super(osmotr, "Стоматолог", Dialog.ModalityType.DOCUMENT_MODAL);
		setBounds(132, 132, 600, 500);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		String mkb[] = {"Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "w", "X", "Y" };
		f_mkb = new JComboBox<String>(mkb);
		JPanel c = new JPanel(new GridLayout(3, 16));
		JLabel l;
		f_1 = new JTextField();
		c.add(f_1);
		f_2 = new JTextField();
		c.add(f_2);
		f_3 = new JTextField();
		c.add(f_3);
		f_4 = new JTextField();
		c.add(f_4);
		f_5 = new JTextField();
		c.add(f_5);
		f_6 = new JTextField();
		c.add(f_6);
		f_7 = new JTextField();
		c.add(f_7);
		f_8 = new JTextField();
		c.add(f_8);
		f_9 = new JTextField();
		c.add(f_9);
		f_10 = new JTextField();
		c.add(f_10);
		f_11 = new JTextField();
		c.add(f_11);
		f_12 = new JTextField();
		c.add(f_12);
		f_13 = new JTextField();
		c.add(f_13);
		f_14 = new JTextField();
		c.add(f_14);
		f_15 = new JTextField();
		c.add(f_15);
		f_16 = new JTextField();
		c.add(f_16);
		l = new JLabel("8");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("7");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("6");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("5");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("4");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("3");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("2");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("1");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("1");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("2");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("3");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("4");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("5");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("6");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("7");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		l = new JLabel("8");
		l.setHorizontalAlignment(JLabel.CENTER);
		c.add(l);
		f_17 = new JTextField();
		c.add(f_17);
		f_18 = new JTextField();
		c.add(f_18);
		f_19 = new JTextField();
		c.add(f_19);
		f_20 = new JTextField();
		c.add(f_20);
		f_21 = new JTextField();
		c.add(f_21);
		f_22 = new JTextField();
		c.add(f_22);
		f_23 = new JTextField();
		c.add(f_23);	
		f_24 = new JTextField();
		c.add(f_24);	
		f_25 = new JTextField();
		c.add(f_25);	
		f_26 = new JTextField();
		c.add(f_26);	
		f_27 = new JTextField();
		c.add(f_27);	
		f_28 = new JTextField();
		c.add(f_28);	
		f_29 = new JTextField();
		c.add(f_29);
		f_30 = new JTextField();
		c.add(f_30);
		f_31 = new JTextField();
		c.add(f_31);
		f_32 = new JTextField();
		c.add(f_32);
		cp.add(c, BorderLayout.NORTH);
		
		JPanel f = new JPanel(new GridLayout(9, 2));
		l = new JLabel("Жалобы");
		l.setHorizontalAlignment(JLabel.RIGHT);
		f.add(l);
		f_33 = new JTextField();
		f.add(f_33);
		l = new JLabel("Данные объективного исследования, внешний осмотр");
		l.setHorizontalAlignment(JLabel.RIGHT);
		f.add(l);
		f_34 = new JTextField();
		f.add(f_34);
		l = new JLabel("Прикус");
		l.setHorizontalAlignment(JLabel.RIGHT);
		f.add(l);
		f_35 = new JTextField();
		f.add(f_35);
		l = new JLabel("Состояние слизистой оболочки");
		l.setHorizontalAlignment(JLabel.RIGHT);
		f.add(l);
		f_36 = new JTextField();
		f.add(f_36);
		l = new JLabel("Данные рентгеновских, лабораторных исследований");
		l.setHorizontalAlignment(JLabel.RIGHT);
		f.add(l);
		f_37 = new JTextField();
		f.add(f_37);
		l = new JLabel("Диагноз:");
		l.setHorizontalAlignment(JLabel.RIGHT);
		f.add(l);
		f_38 = new JTextField();
		f.add(f_38);
		l = new JLabel("Заключение по осмотру");
		l.setHorizontalAlignment(JLabel.RIGHT);
		f.add(l);
		f_39 = new JTextField();
		f.add(f_39);
		l = new JLabel("Состояние здоровья (код по МКБ):");
		l.setHorizontalAlignment(JLabel.RIGHT);
		f.add(l);
		f_mkb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (!arg0.getItem().equals("Z")) {
					osmotr.b_9.setBackground(Color.RED);
				} else {
					osmotr.b_9.setBackground(Color.GREEN);
				}
			}

		});
		JPanel cmkb = new JPanel();
		cmkb.add(f_mkb);
		f_mkbc = new JTextField();
		f_mkbc.setPreferredSize(new Dimension(50,25));
		cmkb.add(f_mkbc);
		f.add(cmkb);
		
		JButton b_2 = new JButton("Выход");
		f.add(b_2);
		b_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		cp.add(f, BorderLayout.CENTER);
		
		

	}
}
