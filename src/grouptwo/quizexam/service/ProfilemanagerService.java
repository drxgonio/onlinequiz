
package grouptwo.quizexam.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grouptwo.quizexam.model.Profilemanager;

public class ProfilemanagerService extends BaseService {

	public ProfilemanagerService() {
		super();
	}

	public static List<Profilemanager> getAllProfilemanager() {

		String query = "select * from profilemanagers";
		List<Profilemanager> lstProfilemanager = new ArrayList<>();

		try {
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				Profilemanager profilemanager = new Profilemanager(rs.getInt("Id"), rs.getString("Name"),
						rs.getDate("DateOfBirth"), rs.getString("Gender"), rs.getString("PhoneNumber"),
						rs.getString("Image"), rs.getBoolean("ShowProfile"), rs.getInt("User"));
				lstProfilemanager.add(profilemanager);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return lstProfilemanager;

	}
	
	public static Profilemanager getManagerById(int id) {

		String query = "select * from onlinequiz.profilemanagers where id=?";
		List<Profilemanager> lstProfilemanager = new ArrayList<>();
		List<Object> params = new ArrayList<>();
		params.add(id);

		try {
			ResultSet rs = excuteQuery(query,params);
			while (rs.next()) {
				Profilemanager profilemanager = new Profilemanager(rs.getInt("Id"), rs.getString("Name"),
						rs.getDate("DateOfBirth"), rs.getString("Gender"), rs.getString("PhoneNumber"),
						rs.getString("Image"), rs.getBoolean("ShowProfile"), rs.getInt("User"));
				lstProfilemanager.add(profilemanager);
				return profilemanager;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;

	}
	
	public static boolean deleteManager(int id) {
		String query = "DELETE FROM onlinequiz.profilemanagers WHERE Id = ?";
		
		List<Object> params = new ArrayList<>();
		params.add(id);
		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateManager(Profilemanager profilemanager)
	{
		String query = "UPDATE onlinequiz.profilemanagers SET "
				+ "Name=?, "
				+ "DateOfBirth=?, "
				+ "Gender=?, "
				+ "PhoneNumber = ?, "
				+ "Image=?, "
				+ "ShowProfile = ?, "
				+ "UserId = ? "
				+ "WHERE Id =?";
		List<Object> params = new ArrayList<>();
		params.add(profilemanager.getName());
		params.add(profilemanager.getDateOfBirth());
		params.add(profilemanager.getGender());
		params.add(profilemanager.getPhoneNumber());
		params.add(profilemanager.getImage());
		params.add(profilemanager.isShowProfile());
		params.add(profilemanager.getUserId());
		params.add(profilemanager.getManagerId());


		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	public static boolean addCourse(Profilemanager profilemanager) {
		String query = "INSERT INTO onlinequiz.profilemanagers (Name, DateOfBirth, Gender,PhoneNumber,Image,ShowProfile,UserId)" + 
				"VALUES (?,?,?,?,?,?,?)";
		
		List<Object> params = new ArrayList<>();
		params.add(profilemanager.getName());
		params.add(profilemanager.getDateOfBirth());
		params.add(profilemanager.getGender());
		params.add(profilemanager.getPhoneNumber());
		params.add(profilemanager.getImage());
		params.add(profilemanager.isShowProfile());
		params.add(profilemanager.getUserId());
		
		try {
			return executeUpdate(query, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
