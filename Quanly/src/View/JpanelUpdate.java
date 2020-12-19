package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import image.*;
public class JpanelUpdate extends JPanel {
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public JpanelUpdate() {
		setBounds(337, 0, 814, 742);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 250, 240));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhâp tên khoản thu cần sửa");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(121, 24, 220, 30);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(407, 26, 229, 30);
		add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(121, 97, 577, 410);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("   Danh sách các khoản thu cần sửa");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 577, 38);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 38, 577, 372);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		loadData();
		}
		public void loadData() {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Mã CK");
			model.addColumn("Mã CK");
			model.addColumn("+/-(%)");
			model.addRow(new Object[] {"ff", "ff", "ff"});
			model.addRow(new Object[] {"ff", "ff", "ff"});
			model.addRow(new Object[] {"ff", "ff", "ff"});
			table_1.setModel(model);
		}
}
