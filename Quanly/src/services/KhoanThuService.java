package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import models.DanhSachKhoanThu;
import models.HoNopTien;

public class KhoanThuService {
	public boolean addNew(DanhSachKhoanThu dsKhoanThu) {
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlInsert = "INSERT INTO danhsachkhoanthu( tenKhoanThu, batDau, ketThuc, soTien)" 
	                + " values (?, ?, ?, ?)";
			String sqlCreateTable = "CREATE TABLE " + dsKhoanThu.getTenKhoanThu().replaceAll(" ", "_") + " " +
					"(idKhoanThu numeric not NULL, " +
					"tenKhoanThu varchar(255), " + 
					"soNhanKhau int(3), " +
					"soTien int(10), " +
					"PRIMARY KEY (idHoKhau))";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlInsert);
			preparedStatement.setString(1, dsKhoanThu.getTenKhoanThu());
			preparedStatement.setString(2, dsKhoanThu.getBatDau());
			preparedStatement.setString(3, dsKhoanThu.getKetThuc());
			preparedStatement.setInt(4, dsKhoanThu.getSoTien());
			preparedStatement.execute();
			
			preparedStatement = (PreparedStatement) connection.prepareStatement(sqlCreateTable);
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
	        connection.close();
		}  catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		return true;
	}
	
	public void themHoKhau(DanhSachKhoanThu dsKhoanThu, List<HoNopTien> hoNopTien) {
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			for(int i = 0; i < hoNopTien.size(); i++) {
				String sqlInsert = "INSERT INTO"+ dsKhoanThu.getTenKhoanThu().replaceAll(" ", "_")
						+ " values (?, ?, ?, ?)";
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlInsert);
				preparedStatement.setInt(1, hoNopTien.get(i).getIdHoKhau());
				preparedStatement.setString(2, hoNopTien.get(i).getTenHoKhau());
				preparedStatement.setInt(3, hoNopTien.get(i).getSoNhanKhau());
				preparedStatement.setInt(4, hoNopTien.get(i).getSoNhanKhau() * dsKhoanThu.getSoTien());
				
				preparedStatement.execute();
				
				preparedStatement.close();
				connection.close();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<HoNopTien> getHoDongGop() {
		List<HoNopTien> hoNopTien = null;
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlSelect = "select  idHoKhau, tenHoKhau, soNhanKhau from hokhau";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sqlSelect);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				HoNopTien hoNT = new HoNopTien();
				hoNT.setIdHoKhau(rs.getInt("idHoKhau"));
				hoNT.setTenHoKhau(rs.getString("tenHoKhau"));
				hoNT.setSoNhanKhau(rs.getInt("soNhanKhau"));
				hoNopTien.add(hoNT);
			}
			
			stmt.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hoNopTien;
	}
	
	public void capNhatDanhSach(DanhSachKhoanThu dsKhoanThu) {
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlUpdate = "update danhsachkhoanthu set "
					+ "tenKhoanThu = ?, "
					+ "batDau = ?, "
					+ "ketThuc = ?, " 
					+ "soTien = ? "
					+ "where idKhoanThu = " + dsKhoanThu.getIdKhoanThu();
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, dsKhoanThu.getTenKhoanThu());
			preparedStatement.setString(2, dsKhoanThu.getBatDau());
			preparedStatement.setString(3, dsKhoanThu.getKetThuc());
			preparedStatement.setInt(4, dsKhoanThu.getSoTien());
			preparedStatement.execute();
			
			preparedStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void capNhatHoNopTien(DanhSachKhoanThu dsKhoanThu, HoNopTien hoNopTien) {
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlUpdate = "update " + dsKhoanThu.getTenKhoanThu().replaceAll(" ", "_") + " set "
					+ "idHoKhau = ?, "
					+ "tenHoKhau = ?, " 
					+ "soNhanKhau = ?, "
					+ "soTien = ?, "
					+ "where idHoKhau = " + hoNopTien.getIdHoKhau();
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlUpdate);
			preparedStatement.setInt(1, hoNopTien.getIdHoKhau());
			preparedStatement.setString(2, hoNopTien.getTenHoKhau());
			preparedStatement.setInt(3, hoNopTien.getSoNhanKhau());
			preparedStatement.setInt(4, hoNopTien.getSoNhanKhau() * dsKhoanThu.getSoTien());
			preparedStatement.execute();
			
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DanhSachKhoanThu searchDSKhoanThu(String tenKhoanThu) {
		DanhSachKhoanThu dsKhoanThu = new DanhSachKhoanThu();
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlSelect = "select  idKhoanThu, tenKhoanThu, batDau, ketThuc, soTien" 
			+ " from danhsachkhoanthu"
			+ " where tenKhoanThu = " + "'" + tenKhoanThu + "'";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlSelect);
			ResultSet rs = preparedStatement.executeQuery();
			
			dsKhoanThu.setIdKhoanThu(rs.getInt("idKhoanThu"));
			dsKhoanThu.setTenKhoanThu(rs.getString("tenKhoanThu"));
			dsKhoanThu.setBatDau(rs.getString("batDau"));
			dsKhoanThu.setKetThuc(rs.getString("ketThuc"));
			dsKhoanThu.setSoTien(rs.getInt("soTien"));
			
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKhoanThu;
	}
}
