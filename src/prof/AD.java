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

public class AD extends JDialog {
	private static final long serialVersionUID = 1L;
	JTextField f_1;
	JTextField f_2;
	JCheckBox f_3;
	
	public AD(Osmotr osmotr) {
		super(osmotr, "Измерение АД", Dialog.ModalityType.DOCUMENT_MODAL);
		setBounds(132, 132, 500, 150);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel c = new JPanel(new GridLayout(4, 2));
		JLabel l;
		l = new JLabel("АД систолическое (мм.рт.ст.)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_1 = new JTextField();
		c.add(f_1);
		l = new JLabel("АД диастолическое (мм.рт.ст.)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_2 = new JTextField();
		c.add(f_2);
		
		l = new JLabel("Патология");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_3 = new JCheckBox();
		f_3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					osmotr.b_2.setBackground(Color.RED);
				} else {
					osmotr.b_2.setBackground(Color.GREEN);
				}
			}
		});
		c.add(f_3);
		
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
