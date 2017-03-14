package com.mmt.model.bl;

import java.io.IOException;
import java.sql.SQLException;

import com.mmt.model.bean.Admin;
import com.mmt.model.bean.Flight;
import com.mmt.model.bean.Hotel;
import com.mmt.model.dao.AdminDaoImplMMT;
import com.mmt.model.dao.FlightDaoImplMMT;
import com.mmt.model.dao.HotelDaoImplMMT;

public class AdminBlMMT {
	private FlightDaoImplMMT flightdao = new FlightDaoImplMMT();
	private HotelDaoImplMMT hoteldao = new HotelDaoImplMMT();
	private AdminDaoImplMMT admindao = new AdminDaoImplMMT();

	public int insertHotel(Hotel h) throws ClassNotFoundException, IOException, SQLException {
		return hoteldao.insertHotel(h);
	}

	public int insertFlight(Flight f) throws ClassNotFoundException, SQLException, IOException {
		return flightdao.insertFlight(f);
	}

	public int deleteHotel(String hotelId) throws ClassNotFoundException, SQLException, IOException {
		return hoteldao.deleteHotel(hotelId);
	}

	public int deleteFlight(String flightId) throws ClassNotFoundException, SQLException, IOException {
		return flightdao.deleteFlight(flightId);
	}

	public int modifyHotel(String hotelId, Hotel newhotel) throws ClassNotFoundException, SQLException, IOException {
		return hoteldao.updateHotel(hotelId, newhotel);
	}

	public int modifyFlight(String flightId, Flight newflight) throws ClassNotFoundException, SQLException, IOException {
		return flightdao.updateFlight(flightId, newflight);
	}

	public Admin searchAdmin(String adminId) throws SQLException, ClassNotFoundException, IOException {
		return admindao.search(adminId);
	}

	public boolean addAdmin(Admin admin) throws SQLException, ClassNotFoundException, IOException {
		if (admindao.search(admin.getAdminName()) == null) {

			admindao.insert(admin);
			return true;
		} else {
			System.out.println("UserName already taken.Please select another  Username.");
			return false;
		}
	}

	public int removeAdmin(String adminId) throws SQLException, ClassNotFoundException, IOException {
		return admindao.delete(adminId);
	}

	public int modifyAdmin(String adminId, Admin admin) throws SQLException, ClassNotFoundException, IOException {
		return admindao.update(adminId, admin);
	}

	public Admin checkAdminLogin(String username, String password) throws SQLException, ClassNotFoundException, IOException {
		
		Admin admin = (Admin) admindao.search(username);
		if(admin==null){
			
			return null;
		}
		else if (admin!=null && (admin.getAdminId().equals(username) && admin.getAdminPassword().equals(password))){
			
			return admin;
		}
		return null;
	}

}
