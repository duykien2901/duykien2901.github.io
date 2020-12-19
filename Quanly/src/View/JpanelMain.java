package View;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class JpanelMain extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public JpanelMain() {
		setBounds(337, 0, 814, 742);
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		
		JLabel lblUs = new JLabel("Username");
		lblUs.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\image\\iconfinder_User_4200769.png"));
		lblUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblUs.setFont(new Font("Monospaced", Font.BOLD, 22));
		lblUs.setBounds(481, 13, 169, 44);
		add(lblUs);
		
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(1, 1, 1, 1));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(85, 197, 624, 414);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("SansSerif", Font.PLAIN, 17));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Đăng xuất");
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnNewButton.setBounds(674, 20, 108, 35);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
		comboBox.setBackground(new Color(211, 211, 211));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Khoản thu", "Đóng góp"}));
		comboBox.setFont(new Font("SansSerif", Font.PLAIN, 17));
		comboBox.setBounds(555, 131, 153, 35);
		add(comboBox);
		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		textField.setBackground(new Color(255, 250, 240));
		textField.setFont(new Font("SansSerif", Font.PLAIN, 20));
		textField.setBounds(179, 132, 221, 35);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Trang chủ");
		lblNewLabel.setForeground(new Color(255, 160, 122));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\Quanly\\src\\image\\iconfinder_house-home-main-menu-start-building_3643769.png"));
		lblNewLabel.setBounds(57, 13, 202, 44);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Tìm kiếm:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(85, 131, 92, 35);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\eclipse-workspace\\Quanly\\src\\image\\search.png"));
		lblNewLabel_3.setBounds(404, 122, 48, 44);
		add(lblNewLabel_3);
		loadData();
	}
	public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã CK");
		model.addColumn("Mã CK");
		model.addColumn("+/-(%)");
		model.addRow(new Object[] {"ff", "kk", "ff"});
		model.addRow(new Object[] {"ff", "pp", "ff"});
		model.addRow(new Object[] {"ff", "ff", "ff"});
		table.setModel(model);
	}
}
