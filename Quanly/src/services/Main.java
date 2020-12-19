package services;

import java.sql.SQLException;
import java.util.Calendar;

import models.DanhSachDongGop;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH) + 1;
		int year = c.get(Calendar.YEAR);
		String batDau = day + "/" + month + "/" + year;
		System.out.println(batDau);
		DanhSachDongGop ds = new DanhSachDongGop(1, "Ung ho mien Trung", "1/12/2020", "5/12/2020", 100000);
		DongGopService ser = new DongGopService();
		ser.addNew(ds);
	}

}
