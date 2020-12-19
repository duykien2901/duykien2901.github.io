package View;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Thongke extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Thongke() {
		setBackground(new Color(255, 250, 240));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JButton btnNewButton = new JButton("Chọn hộ");
		btnNewButton.setBounds(81, 45, 113, 36);
		add(btnNewButton);
		
		JButton btnTngSH = new JButton("Tổng số hộ");
		btnTngSH.setBounds(329, 45, 113, 36);
		add(btnTngSH);
		
		JButton btnTngSTin = new JButton("Tổng số tiền");
		btnTngSTin.setBounds(561, 45, 113, 36);
		add(btnTngSTin);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(81, 136, 593, 372);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Danh sách các hộ");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(0, 0, 593, 49);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 49, 593, 323);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		loadData();
	}
	
	public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã CK");
		model.addColumn("+/-(giá)");
		model.addColumn("+/-(%)");
		model.addRow(new Object[] {"ff", "ff", "ff"});
		table.setModel(model);
	}
}
