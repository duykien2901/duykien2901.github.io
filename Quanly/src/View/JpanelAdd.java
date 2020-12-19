package View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JpanelAdd extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public JpanelAdd() {
		setBounds(337, 0, 814, 742);
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setBackground(new Color(255, 255, 240));
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên khoản thu: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(183, 248, 108, 25);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(comboBox.getSelectedItem().equals("Khoản thu")) {
				} else {
					textField_2.setText("Không phải điền");
				}
				
			}
		});
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textField_1.setBounds(342, 242, 274, 36);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Số tiền thu : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(183, 318, 108, 25);
		add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		textField_2.setBounds(342, 312, 274, 36);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ngày bắt đầu : ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(183, 392, 108, 25);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hạn kết thúc :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(183, 465, 108, 25);
		add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(679, 610, 108, 36);
		add(btnNewButton);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("SansSerif", Font.PLAIN, 18));
		dateChooser.setBorder(new EmptyBorder(0, 0, 0, 0));
		dateChooser.setBounds(342, 381, 274, 36);
		add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		dateChooser_1.setBounds(342, 454, 274, 36);
		add(dateChooser_1);
		
		comboBox = new JComboBox();
		
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Khoản thu", "Đóng góp"}));
		comboBox.setBounds(611, 91, 147, 30);
		add(comboBox);
//		setData(comboBox);
	}
	
	public void setData(JComboBox jComboBox) {
		if(jComboBox.getSelectedItem().equals("Đóng góp")) {
			textField_1.setText("Không phải điền");
		} else {
			textField_1.setText("");
		}
	}
}
