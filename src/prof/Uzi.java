package prof;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Uzi extends JDialog {
	private static final long serialVersionUID = 1L;
	JTextArea f_1;
	JCheckBox f_2;

	public Uzi(Osmotr osmotr) {
		super(osmotr, "Узи", Dialog.ModalityType.DOCUMENT_MODAL);
		setBounds(132, 132, 600, 200);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel c = new JPanel(new GridBagLayout());
		GridBagConstraints k = new GridBagConstraints();
		k.weightx = 100.0;
		k.weighty = 100.0;

		JLabel l;
		l = new JLabel("Узи брюшной плости и почек");
		l.setHorizontalAlignment(JLabel.RIGHT);
		k.gridx = 0;
		k.gridy = 0;
		c.add(l, k);

		f_1 = new JTextArea();
		JScrollPane s_1 = new JScrollPane(f_1);
		s_1.setPreferredSize(new Dimension(300, 100));
		s_1.setMinimumSize(new Dimension(300, 100));
		k.gridx = 1;
		k.gridy = 0;
		k.fill = GridBagConstraints.BOTH;
		c.add(s_1, k);

		l = new JLabel("Патология");
		l.setHorizontalAlignment(JLabel.RIGHT);
		k.gridx = 0;
		k.gridy = 1;
		c.add(l, k);

		f_2 = new JCheckBox();
		k.gridx = 1;
		k.gridy = 1;
		f_2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					osmotr.b_7.setBackground(Color.RED);
				} else {
					osmotr.b_7.setBackground(Color.GREEN);
				}
			}
		});
		c.add(f_2, k);

		JButton b_2 = new JButton("Выход");
		k.gridx = 0;
		k.gridy = 2;
		k.gridwidth = 2;
		c.add(b_2, k);
		b_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		cp.add(c, BorderLayout.CENTER);

	}
}
