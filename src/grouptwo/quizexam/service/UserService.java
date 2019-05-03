package grouptwo.quizexam.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grouptwo.quizexam.model.User;
public class UserService extends BaseService {

	public UserService() {
		super();
	}
	public static  List<User> getAllUsers() {
		String query = "Select * from users";
		List<User> lstUsers = new ArrayList<>();

		try {
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				User users = new User(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getBoolean(5));
				lstUsers.add(users);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return lstUsers;
	}

	public static  User getUsersById(int id) {
		String query = "Select * from users where UserId = " +id;
		User user=null;
		try
		{
			
			ResultSet rs = excuteQuery(query);
			while(rs.next()) {
					user = new User(
					
					rs.getString("UserName"),
					rs.getString("Email"),
					rs.getString("Password"),
					rs.getInt("RoleUser"),
					rs.getBoolean("Activate"));
			
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());

		}
		return user;
	}

	public static  User getUsersByName(String UserName) {
		String query = "SELECT * FROM onlinequiz.users where UserName='"+UserName+"'";
		User user=null;
		try
		{
			
			ResultSet rs = excuteQuery(query);
			while(rs.next()) {
					user = new User(
					rs.getInt("UserId"),
					rs.getString("UserName"),
					rs.getString("Email"),
					rs.getString("Password"),
					rs.getInt("RoleUser"),
					rs.getBoolean("Activate"));
			
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());

		}
		return user;
	}

	public static  boolean deleteUsers(int id) {
		String query="Delete from users where Id=?";
		List<Object> params= new ArrayList<>();
		params.add(id);
		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateUsers(User user) {
		{
			String query ="update users set  UserName=?,Email = ?,Password = ?,RoleUser = ?,Activate = ? Where UserId= ?";
			List<Object> params= new ArrayList<>();
			params.add(user.getUserName());
			params.add(user.getEmail());
			params.add(user.getPassword());
			params.add(user.getRoleuser());
			params.add(user.getActivate());
			params.add(user.getUserId());
			//System.out.println(user.getUserName()+user.getEmail()+user.getPassword()+user.getRoleuser()+user.getActivate());
			try {
				boolean action = executeUpdate(query, params);
				return action;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	public static boolean ChangePass(String pass,int UserId) {
		{
			String query ="update users set Password = ? Where UserId= ?";
			List<Object> params= new ArrayList<>();
			params.add(pass);
			params.add(UserId);
			try {
				boolean action = executeUpdate(query, params);
				return action;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}

	public static boolean addUsers(User user) {
		String query="Insert into users (UserName,Email,Password,RoleUser,Activate)"
				+"values (?,?,?,?,?)";
	List<Object> params= new ArrayList<>();
	params.add(user.getUserName());
	params.add(user.getEmail());
	params.add(user.getPassword());
	params.add(user.getRoleuser());
	params.add(user.getActivate());
	try {
		boolean action = executeUpdate(query, params);
		return action;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;


	}
	public static User findAcc(String userName, String password) {
		String sql="select * from users where UserName=? and Password=?";
		List<Object> param=new ArrayList<>();
		param.add(userName);
		param.add(password);
		try
		{
			ResultSet rs= excuteQuery(sql,param);
			while(rs.next())
			{
				User users = new User(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getBoolean(6));
				return users;
			}
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
