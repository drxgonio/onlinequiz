package grouptwo.quizexam.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import grouptwo.quizexam.model.Roleuser;




public class RoleuserService extends BaseService {

	public RoleuserService() {
		super();
	}

	public static  boolean addRoleuser(String RoleuserName)
	{
		String sql="insert into roleusers(RoLeName) values(?)";
		List<Object> param= new ArrayList<>();
		param.add(RoleuserName);
			try {
				return executeUpdate(sql,param);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		return false;
	}
	public static  List<Roleuser> getAllRoleuser()
	{
		String sql="select * from roleusers";
		List<Roleuser> list=null;
		Roleuser qsc=null;
		try {
			ResultSet rs=excuteQuery(sql);
			list=new ArrayList<>();
			
			while(rs.next())
			{
				qsc=new Roleuser();
				qsc.setId(rs.getInt(1));
				qsc.setRoleName(rs.getString(2));
				list.add(qsc);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
	public static  Roleuser getRoleuser(int id)
	{
		Roleuser qsc=new Roleuser();
		String sql="select * from roleusers where Id=?";
		List<Object> param= new ArrayList<>();
		param.add(id);
		try {
			ResultSet rs=excuteQuery(sql,param);
			while(rs.next())
			{
				qsc=new Roleuser();
				qsc.setId(rs.getInt(1));
				qsc.setRoleName(rs.getString(2));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return qsc;
		
		
	}
	public static  Roleuser getRoleuser(String name)
	{
		Roleuser qsc=new Roleuser();
		String sql="select * from roleusers where RoleName=?";
		List<Object> param= new ArrayList<>();
		param.add(name);
		try {
			ResultSet rs=excuteQuery(sql,param);
			while(rs.next())
			{
				qsc=new Roleuser();
				qsc.setId(rs.getInt(1));
				qsc.setRoleName(rs.getString(2));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return qsc;
	}
	public static  boolean deleteRoleuser(int id_Roleuser)
	{
		String sql="delete from roleusers where Id=?";
		List<Object> param= new ArrayList<>();
		param.add(id_Roleuser);
		try {
			return executeUpdate(sql, param);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public static  boolean updateRoleuser(int id_Roleuser,String roleUserName)
	{
		String sql="update roleusers set RoleName=? where Id=?";
		List<Object> param= new ArrayList<>();
		param.add(roleUserName);
		param.add(id_Roleuser);
		try {
			return executeUpdate(sql, param);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	public static  int getIdRoleuser(String roleUserName)
	{
		int id=-1;
		String sql="select Id from roleusers where RoleName=?";
		List<Object> param= new ArrayList<>();
		param.add(roleUserName);
		try {
			ResultSet rs= excuteQuery(sql, param);
			while(rs.next())
			{
				id=rs.getInt(1);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;
	}
	public static  String getNameRoleuser(int id_Roleuser)
	{
		String Name=null;
		String sql="select RoleName  from roleusers where Id=?";
		List<Object> param= new ArrayList<>();
		param.add(id_Roleuser);
		try {
			ResultSet rs= excuteQuery(sql, param);
			while(rs.next())
			{
				Name=rs.getString(1);
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return Name;
	}

	public static List<Roleuser> getAllRoleUser() {
		String query = "Select * from roleuser";
		List<Roleuser> lstRoleUser = new ArrayList<>();

		try {
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				Roleuser roleUser = new Roleuser(
						rs.getInt("Id"), 
						rs.getString("RoleName"));
				lstRoleUser.add(roleUser);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return lstRoleUser;
	}

	public static Roleuser getRoleUserById(int id) {
		String query = "Select * from roleusers where Id = " +id;
		try
		{
			ResultSet rs = excuteQuery(query);
			rs.next();
			Roleuser roleuser = new Roleuser(rs.getInt("id"),
					rs.getString("RoleName"));
			return roleuser;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());

		}
		return null;
	}

	public static Roleuser getRoleUserByName(String subject) {
		return null;
	}

	public static boolean deleteRoleUser(int id) {
		String query="Delete from roleusers where Id=?";
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

	public static boolean updateRoleUser(Roleuser roleUser) {

		String query ="update roleusers set "
				+ "RoleName=?,"
				+ "Where Id= ?";
		List<Object> params= new ArrayList<>();
		params.add(roleUser.getRoleName());
		params.add(roleUser.getId());
		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static boolean addRoleUser(Roleuser roleUser) {
		String query="Insert into roleusers (RoleName)"
				+"values (?)";
	List<Object> params= new ArrayList<>();
	params.add(roleUser.getRoleName());
	try {
		boolean action = executeUpdate(query, params);
		return action;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;


	}
}
