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

public class Endo extends JDialog {
	private static final long serialVersionUID = 1L;
	JTextField f_1;
	JTextField f_2;
	JTextField f_3;
	JTextField f_4;
	JComboBox<String> f_mkb = null;
	JTextField f_mkbc;
	
	public Endo(Osmotr osmotr) {
		super(osmotr, "Эндокринолог", Dialog.ModalityType.DOCUMENT_MODAL);
		String mkb[] = {"Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "w", "X", "Y" };
		f_mkb = new JComboBox<String>(mkb);
		setBounds(132, 132, 550, 600);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel c = new JPanel(new GridLayout(6, 4));
		JLabel l;
		l = new JLabel("Жалобы");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_1 = new JTextField();
		c.add(f_1);
		l = new JLabel("Осмотр");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_2 = new JTextField();
		c.add(f_2);
		l = new JLabel("Диагноз");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_3 = new JTextField();
		c.add(f_3);
		l = new JLabel("Заключение по осмотру (здоров,  практически  здоров,  болен,  нуждается  в  лечении)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_4 = new JTextField();
		c.add(f_4);
		l = new JLabel("Состояние здоровья (код по МКБ):");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_mkb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (!arg0.getItem().equals("Z")) {
					osmotr.b_12.setBackground(Color.RED);
				} else {
					osmotr.b_12.setBackground(Color.GREEN);
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
