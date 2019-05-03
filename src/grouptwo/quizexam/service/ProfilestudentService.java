package grouptwo.quizexam.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grouptwo.quizexam.model.Profilestudent;

public class ProfilestudentService extends BaseService {
	public ProfilestudentService() {
		super();
	}

	public static List<Profilestudent> getAllProfilesutudent() {

		String query = "select * from profilestudents";
		List<Profilestudent> lstProfilemanager = new ArrayList<>();

		try {
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				Profilestudent profilestudent = new Profilestudent(
						rs.getInt("Id"), 
						rs.getString("Name"),
						rs.getInt("IdentityCardNumber"),
						rs.getDate("DateOfBirth"),
						rs.getString("Gender"),
						rs.getString("PhoneNumber"),
						rs.getString("Country"),
						rs.getString("Address"),
						rs.getString("Religion"),
						rs.getInt("YearOfAdmission"),
						rs.getInt("YearOfGraduation"),
						rs.getString("Image"),
						rs.getBoolean("ShowProfile"),
						rs.getInt("User"));
				lstProfilemanager.add(profilestudent);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return lstProfilemanager;

	}
	public static  List<Profilestudent>  getAllProfilesutudentByCourse(int courseId)
	{
		String sql="SELECT * FROM detailcourses,profilestudents where detailcourses.Student=profilestudents.Id and Course=?";
		List<Profilestudent> lstProfilemanager = new ArrayList<>();
		List<Object> param=new ArrayList<>();
		param.add(courseId);
		try {
			ResultSet rs = excuteQuery(sql,param);
			while (rs.next()) {
				Profilestudent profilestudent = new Profilestudent(
						rs.getInt("Id"), 
						rs.getString("Name"),
						rs.getInt("IdentityCardNumber"),
						rs.getDate("DateOfBirth"),
						rs.getString("Gender"),
						rs.getString("PhoneNumber"),
						rs.getString("Country"),
						rs.getString("Address"),
						rs.getString("Religion"),
						rs.getInt("YearOfAdmission"),
						rs.getInt("YearOfGraduation"),
						rs.getString("Image"),
						rs.getBoolean("ShowProfile"),
						rs.getInt("User"));
				lstProfilemanager.add(profilestudent);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return lstProfilemanager;
	}
	public static Profilestudent getProfilestudentByUser(int id_User) {
		String query = "select * from onlinequiz.profilestudents where User ="+id_User;
		Profilestudent profilestudent=null;
		
		try {
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				profilestudent = new Profilestudent(
					
					rs.getInt("Id"), 
					rs.getString("Name"),
					rs.getInt("IdentityCardNumber"),
					rs.getDate("DateOfBirth"),
					rs.getString("Gender"),
					rs.getString("PhoneNumber"),
					rs.getString("Country"),
					rs.getString("Address"),
					rs.getString("Religion"),
					rs.getInt("YearOfAdmission"),
					rs.getInt("YearOfGraduation"),
					rs.getString("Image"),
					rs.getBoolean("ShowProfile"),
					rs.getInt("User"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return profilestudent;
	}
	
	
	public static int getIdStudentByUser(int id) {
		String query = "SELECT * FROM onlinequiz.profilestudents where user= " + id;
		try {
			ResultSet rs = excuteQuery(query);
			rs.next();
			return rs.getInt("Id");
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return 0;
	}

	public static List<Profilestudent> getProfilestudentByName(String name) {
		String query = "select * from profilestudents where Name like '%" + name + "%'";
		try {
			List<Profilestudent> lstStudent = new ArrayList<>();
			ResultSet rs = excuteQuery(query);
			while(rs.next())
			{
				Profilestudent profilestudent = new Profilestudent(
						rs.getInt("Id"), 
						rs.getString("Name"),
						rs.getInt("IdentityCardNumber"),
						rs.getDate("DateOfBirth"),
						rs.getString("Gender"),
						rs.getString("PhoneNumber"),
						rs.getString("Country"),
						rs.getString("Address"),
						rs.getString("Religion"),
						rs.getInt("YearOfAdmission"),
						rs.getInt("YearOfGraduation"),
						rs.getString("Image"),
						rs.getBoolean("ShowProfile"),
						rs.getInt("User"));
				lstStudent.add(profilestudent);
			}
			
			return lstStudent;
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return null;
	}

	public static boolean deleteProfilestudent(int id) {
		String query = "DELETE FROM Profilestudents WHERE Id=?";
		List<Object> params = new ArrayList<>();
		params.add(id);
		try {

			return executeUpdate(query, params);

		} catch (SQLException ex) {

		}

		return false;
	}

	public static boolean InsertProfilestudent(String user, String name, int identityCardNumber, Date dateOfBirth,
			String gender, String email, int phoneNumber, String country, Date yearOfAdmission, Date yearOfGraduation,
			boolean showProfile) {
		// String query = "INSERT INTO EXAMS VALUES(?,?,?,?,?)" ;
		String query = "Insert into profilestudent(profilestudent.User,profilestudent.Name,IdentityCardNumber,DateOfBirth,Gender,Email,PhoneNumber,Country,Address,Religion,YearOfAdmission,YearOfGraduation,Image,ShowProfile) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<>();
		params.add(user);
		params.add(name);
		params.add(identityCardNumber);
		params.add(dateOfBirth);
		params.add(gender);
		params.add(email);
		params.add(phoneNumber);
		params.add(country);
		params.add(yearOfAdmission);
		params.add(yearOfGraduation);
		params.add(showProfile);

		try {

			return executeUpdate(query, params);

		} catch (SQLException ex) {

			// Logger.getLogger(ExamsService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return false;
	}
	public static boolean addProfilestudent(Profilestudent student) {
		String query = "Insert into onlinequiz.profilestudents(Name,IdentityCardNumber,DateOfBirth,Gender,PhoneNumber,Country,Address,Religion,YearOfAdmission,YearOfGraduation,Image,ShowProfile,User)"
				+ " Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<>();
		params.add(student.getName());
		params.add(student.getIdentityCardNumber());
		params.add(student.getDateOfBirth());
		params.add(student.getGender());
		params.add(student.getPhoneNumber());
		params.add(student.getCountry());
		params.add(student.getAddress());
		params.add("Khác");
		params.add(student.getYearOfAdmission());
		params.add(student.getYearOfGraduation());
		params.add("");
		params.add(student.isShowProfile());
		params.add(student.getUserId());

		try {

			return executeUpdate(query, params);

		} catch (SQLException ex) {

			ex.printStackTrace();
			// Logger.getLogger(ExamsService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return false;
	}

	public static boolean UpdateProfilestudent(String user, String name, int identityCardNumber, Date dateOfBirth,
			String gender, String email, int phoneNumber, String country, Date yearOfAdmission, Date yearOfGraduation,
			boolean showProfile) {
		String query = "update profilestudents set profilestudent.Name=?,IdentityCardNumber=?,DateOfBirth=?,Gender=?,Email=?,PhoneNumber=?,Country=?,Address=?,Religion=?,YearOfAdmission=?,YearOfGraduation=?,Image=?,ShowProfile=? where profilestudent.User=?";
		List<Object> params = new ArrayList<>();
		
		params.add(user);
		params.add(name);
		params.add(identityCardNumber);
		params.add(dateOfBirth);
		params.add(gender);
		params.add(email);
		params.add(phoneNumber);
		params.add(country);
		params.add(yearOfAdmission);
		params.add(yearOfGraduation);
		params.add(showProfile);
		try {

			return executeUpdate(query, params);

		} catch (SQLException ex) {

			// Logger.getLogger(ExamsService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return false;
	}


	public static List<Profilestudent> getAllProfilesutudent(int idCourse,int firstReSult, int amoutResult) {
		String query = "SELECT * FROM detailcourses,profilestudents where detailcourses.Student=profilestudents.Id and Course=? order by profilestudents.Id LIMIT ?,?";
		List<Object> param=new ArrayList<>();
		param.add(idCourse);
		param.add(firstReSult);
		param.add(amoutResult);
		List<Profilestudent> lstProFile = new ArrayList<>();
		try {
			ResultSet rs = excuteQuery(query,param);
			while (rs.next()) {
				Profilestudent profilestudent = new Profilestudent(
						rs.getInt("Id"), 
						rs.getString("Name"),
						rs.getInt("IdentityCardNumber"),
						rs.getDate("DateOfBirth"),
						rs.getString("Gender"),
						rs.getString("PhoneNumber"),
						rs.getString("Country"),
						rs.getString("Address"),
						rs.getString("Religion"),
						rs.getInt("YearOfAdmission"),
						rs.getInt("YearOfGraduation"),
						rs.getString("Image"),
						rs.getBoolean("ShowProfile"),
						rs.getInt("User"));
				lstProFile.add(profilestudent);
			}
			return lstProFile;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return null;
	
	}

	public static int countProfileForCourse(int idCourse) {
		String sql="SELECT Count(*) FROM detailcourses,profilestudents where detailcourses.Student=profilestudents.Id and detailcourses.course=?";
		List<Object> param=new ArrayList<>();
		param.add(idCourse);
		try
		{
			ResultSet rs=excuteQuery(sql,param);
			while(rs.next())
			{
				return rs.getInt(1);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public static List<Profilestudent> getAllStudent(int firstResult, int amoutResult) {
		String query = "select * from profilestudents order by Id LIMIT ?,?";
		List<Object> param=new ArrayList<>();
		param.add(firstResult);
		param.add(amoutResult);
		List<Profilestudent> lstProfileStu =null;

		try {	
			lstProfileStu= new ArrayList<>();
			ResultSet rs = excuteQuery(query,param);
			while (rs.next()) {
				Profilestudent ProfileStu = new Profilestudent(
						rs.getInt("Id"), 
						rs.getString("Name"),
						rs.getInt("IdentityCardNumber"),
						rs.getDate("DateOfBirth"),
						rs.getString("Gender"),
						rs.getString("PhoneNumber"),
						rs.getString("Country"),
						rs.getString("Address"),
						rs.getString("Religion"),
						rs.getInt("YearOfAdmission"),
						rs.getInt("YearOfGraduation"),
						rs.getString("Image"),
						rs.getBoolean("ShowProfile"),
						rs.getInt("User"));
				lstProfileStu.add(ProfileStu);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return lstProfileStu;
	}

	public static int countProfile() {
		String sql="select count(id) from profilestudents";
		try
		{
			ResultSet rs=excuteQuery(sql);
			while(rs.next())
			{
				return rs.getInt(1);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public static Profilestudent getProfilestudentById(int id) {
		String query = "select * from profilestudents where Id = " + id;
		Profilestudent profilestudent=null;
		
		try {
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				profilestudent = new Profilestudent(
					
					rs.getInt("Id"), 
					rs.getString("Name"),
					rs.getInt("IdentityCardNumber"),
					rs.getDate("DateOfBirth"),
					rs.getString("Gender"),
					rs.getString("PhoneNumber"),
					rs.getString("Country"),
					rs.getString("Address"),
					rs.getString("Religion"),
					rs.getInt("YearOfAdmission"),
					rs.getInt("YearOfGraduation"),
					rs.getString("Image"),
					rs.getBoolean("ShowProfile"),
					rs.getInt("User"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return profilestudent;
	}
	public static boolean UpdateProfilestudent(Profilestudent c) {
		//String query = "update profilestudents set Name=?,IdentityCardNumber=?,DateOfBirth=?,Gender=?,PhoneNumber=?,Country=?,Address=?,Religion=?,YearOfAdmission=?,YearOfGraduation=?,Image=?,ShowProfile=?,User=? where Id=?";
		
		String query="update profilestudents set Name=? , IdentityCardNumber=? , DateOfBirth= ? , Gender= ? , PhoneNumber= ? , Country= ? , Address= ? , Religion = ? , YearOfAdmission = ? , YearOfGraduation= ? , Image= ? , ShowProfile= ? , User= ?  where Id=?";
		List<Object> params = new ArrayList<>();
		
		params.add(c.getName());
		params.add(c.getIdentityCardNumber());
		params.add(c.getDateOfBirth());
		params.add(c.getGender());
		params.add(c.getPhoneNumber());
		params.add(c.getCountry());
		params.add(c.getAddress());
		params.add(c.getReligion());
		params.add(c.getYearOfAdmission());
		params.add(c.getYearOfGraduation());
		params.add(c.getImage());
		
		params.add(c.isShowProfile());
		//params.add(c.getUserId());
		params.add(c.getStudentId());
		params.add(c.getStudentId());
		
		try {
			
			return executeUpdate(query, params);

		} catch (SQLException ex) {

			// Logger.getLogger(ExamsService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return false;
	}
	

}
