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

public class EKG extends JDialog {
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
	JCheckBox f_12;
	
	public EKG(Osmotr osmotr) {
		super(osmotr, "ЭКГ", Dialog.ModalityType.DOCUMENT_MODAL);
		setBounds(132, 132, 600, 390);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel c = new JPanel(new GridLayout(13, 2));
		JLabel l;
		l = new JLabel("Зубец P");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_1 = new JTextField();
		c.add(f_1);
		l = new JLabel("Зубец R");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_2 = new JTextField();
		c.add(f_2);
		l = new JLabel("Зубец T");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_3 = new JTextField();
		c.add(f_3);
		l = new JLabel("Интервал P");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_4 = new JTextField();
		c.add(f_4);
		l = new JLabel("Интервал PQ");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_5 = new JTextField();
		c.add(f_5);
		l = new JLabel("Интервал QS");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_6 = new JTextField();
		c.add(f_6);
		l = new JLabel("Интервал ST");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_7 = new JTextField();
		c.add(f_7);
		l = new JLabel("Интервал QRS");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_8 = new JTextField();
		c.add(f_8);
		l = new JLabel("Интервал RR");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_9 = new JTextField();
		c.add(f_9);
		l = new JLabel("Отклонение эл. оси");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_10 = new JTextField();
		c.add(f_10);
		l = new JLabel("Экстрасистолия");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_11 = new JTextField();
		c.add(f_11);
		
		l = new JLabel("Патология");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_12 = new JCheckBox();
		f_12.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					osmotr.b_3.setBackground(Color.RED);
				} else {
					osmotr.b_3.setBackground(Color.GREEN);
				}
			}
		});
		c.add(f_12);
		
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
