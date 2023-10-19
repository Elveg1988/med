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

public class ObshiyKrovi extends JDialog {
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
	JCheckBox f_22;
	
	public ObshiyKrovi(Osmotr osmotr) {
		super(osmotr, "Общий анализ крови", Dialog.ModalityType.DOCUMENT_MODAL);
		setBounds(132, 132, 600, 550);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel c = new JPanel(new GridLayout(23, 4));
		JLabel l;
		l = new JLabel("Эритроциты (х10 в 12)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_1 = new JTextField();
		c.add(f_1);
		l = new JLabel("Гемоглобин (г/л)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_2 = new JTextField();
		c.add(f_2);
		l = new JLabel("Цветовой показатель");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_3 = new JTextField();
		c.add(f_3);
		l = new JLabel("Гематокрит (%)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_4 = new JTextField();
		c.add(f_4);
		l = new JLabel("Ретикулоциты (%)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_5 = new JTextField();
		c.add(f_5);
		l = new JLabel("Тромбоциты (х10 в 9");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_6 = new JTextField();
		c.add(f_6);
		l = new JLabel("Лейкоциты (абс.)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_7 = new JTextField();
		c.add(f_7);
		l = new JLabel("Базофилы (%)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_8 = new JTextField();
		c.add(f_8);
		l = new JLabel("Эозинофилы (%)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_9 = new JTextField();
		c.add(f_9);
		l = new JLabel("Нейтрофилы: миелоциты (%)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_10 = new JTextField();
		c.add(f_10);
		l = new JLabel("Нейтрофилы: юные (%)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_11 = new JTextField();
		c.add(f_11);
		l = new JLabel("Нейтрофилы: палочкоядерные (%)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_12 = new JTextField();
		c.add(f_12);
		l = new JLabel("Нейтрофилы: сегментоядерные (%)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_13 = new JTextField();
		c.add(f_13);
		l = new JLabel("Лимфоциты (%)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_14 = new JTextField();
		c.add(f_14);
		l = new JLabel("Моноциты (%)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_15 = new JTextField();
		c.add(f_15);
		l = new JLabel("Индекс сдвига");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_16 = new JTextField();
		c.add(f_16);
		l = new JLabel("Анизоцитоз");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_17 = new JTextField();
		c.add(f_17);
		l = new JLabel("Пойкилоцитоз");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_18 = new JTextField();
		c.add(f_18);
		l = new JLabel("Резистентность эритоцитов");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_19 = new JTextField();
		c.add(f_19);
		l = new JLabel("Время свёртывания");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_20 = new JTextField();
		c.add(f_20);
		l = new JLabel("Скорость оседания эритоцитов (мм/час)");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_21 = new JTextField();
		c.add(f_21);
		
		l = new JLabel("Патология");
		l.setHorizontalAlignment(JLabel.RIGHT);
		c.add(l);
		f_22 = new JCheckBox();
		f_22.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					osmotr.b_5.setBackground(Color.RED);
				} else {
					osmotr.b_5.setBackground(Color.GREEN);
				}
			}
		});
		c.add(f_22);
		
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
