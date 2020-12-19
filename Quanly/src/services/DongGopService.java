package services;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import models.DanhSachDongGop;
import models.DanhSachKhoanThu;
import models.HoDongGop;

public class DongGopService {
	public boolean addNew(DanhSachDongGop dsDongGop) throws ClassNotFoundException {
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlInsert = "INSERT INTO danhsachdonggop( tenDongGop, batDau, ketThuc, TongTien)" 
	                + " values (?, ?, ?, ?)";
			String sqlCreateTable = "CREATE TABLE " + dsDongGop.getTenDongGop().replaceAll(" ", "_") + " " +
					"(idHoKhau numeric not NULL, " +
					"tenHoKhau varchar(255), " +
					"tienDongGop varchar(255), " +
					"PRIMARY KEY (idHoKhau))";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlInsert);
			preparedStatement.setString(1, dsDongGop.getTenDongGop());
			preparedStatement.setString(2, dsDongGop.getBatDau());
			preparedStatement.setString(3, dsDongGop.getKetThuc());
			preparedStatement.setInt(4, dsDongGop.getTongTien());
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
	
	public void themHoKhau(DanhSachDongGop dsDongGop, List<HoDongGop> hoDongGop) {
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			for(int i = 0; i < hoDongGop.size(); i++) {
				String sqlInsert = "INSERT INTO"+ dsDongGop.getTenDongGop().replaceAll(" ", "_")
						+ " values (?, ?)";
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlInsert);
				preparedStatement.setInt(1, hoDongGop.get(i).getIdHoKhau());
				preparedStatement.setString(2, hoDongGop.get(i).getTenHoKhau());
				
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
	
	public List<HoDongGop> getHoDongGop() {
		List<HoDongGop> hoDongGop = null;
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlSelect = "select  idHoKhau, tenHoKhau from hokhau";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sqlSelect);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				HoDongGop hoDG = new HoDongGop();
				hoDG.setIdHoKhau(rs.getInt("idHoKhau"));
				hoDG.setTenHoKhau(rs.getString("tenHoKhau"));
				hoDongGop.add(hoDG);
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
		return hoDongGop;
	}
	
	public void capNhatDanhSach(DanhSachDongGop dsDongGop) {
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlUpdate = "update danhsachdonggop set "
					+ "tenDongGop = ?, "
					+ "batDau = ?, "
					+ "ketThuc = ?, " 
					+ "tongTien = ? "
					+ "where idDongGop = " + dsDongGop.getIdDongGop();
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlUpdate);
			preparedStatement.setString(1, dsDongGop.getTenDongGop());
			preparedStatement.setString(2, dsDongGop.getBatDau());
			preparedStatement.setString(3, dsDongGop.getKetThuc());
			preparedStatement.setInt(4, dsDongGop.getTongTien());
			preparedStatement.execute();
			
			preparedStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void capNhatHoDongHop(DanhSachDongGop dsDongGop, HoDongGop hoDongGop) {
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlUpdate = "update " + dsDongGop.getTenDongGop().replaceAll(" ", "_") + " set "
					+ "idHoKhau = ?, "
					+ "tenHoKhau = ?, "
					+ "tienDongGop = ?, "
					+ "where idHoKhau = " + hoDongGop.getIdHoKhau();
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlUpdate);
			preparedStatement.setInt(1, hoDongGop.getIdHoKhau());
			preparedStatement.setString(2, hoDongGop.getTenHoKhau());
			preparedStatement.setInt(3, hoDongGop.getTienDongGop());
			preparedStatement.execute();
			
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DanhSachDongGop searchDSKhoanThu(String tenDongGop) {
		DanhSachDongGop dsDongGop = new DanhSachDongGop();
		try {
			Connection connection = (Connection) MysqlConnection.getMysqlConnection();
			String sqlSelect = "select  idDongGop, tenDongGop, batDau, ketThuc, tongTien" 
			+ " from danhsachdonggop"
			+ " where tenDongGop = " + "'" + tenDongGop + "'";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sqlSelect);
			ResultSet rs = preparedStatement.executeQuery();
			
			dsDongGop.setIdDongGop(rs.getInt("idDongGop"));
			dsDongGop.setTenDongGop(rs.getString("tenDongGop"));
			dsDongGop.setBatDau(rs.getString("batDau"));
			dsDongGop.setKetThuc(rs.getString("ketThuc"));
			dsDongGop.setTongTien(rs.getInt("tongTien"));
			
			preparedStatement.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDongGop;
	}
}
