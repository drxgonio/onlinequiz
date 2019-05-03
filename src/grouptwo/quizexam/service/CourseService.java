package grouptwo.quizexam.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grouptwo.quizexam.model.Course;


public class CourseService extends BaseService {
	
	public CourseService() {
		super();
	}

	public static List<Course> getAllCourse() {
		
		String query = "Select * from onlinequiz.courses";
		List<Course> lstCourse = new ArrayList<>();

		try {
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				Course course = new Course(
						rs.getInt("Subject"), 
						rs.getDate("DateOfStarting"), 
						rs.getDate("DateOfEnding"), 
						rs.getString("DateOfWeek"), 
						rs.getInt("PartOfStarting"), 
						rs.getInt("PartOfEnding"), 
						rs.getInt("NumOfStudents"), 
						rs.getString("Room"), 
						rs.getBoolean("Activate"),
						rs.getInt("Teacher"),
						rs.getString("Name"),
						rs.getInt("Id"));
				lstCourse.add(course);
	        }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}	
		return lstCourse;
		
	}
	public static List<Integer> getAllId()
	{
		String sql="select id from courses";
		List<Integer> lsID = new ArrayList<>();
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
			
				lsID.add(rs.getInt(1));
	        }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}	
		return lsID;
	}
	public static Course getCourseById(int id) {
		String query = "Select * from onlinequiz.courses where Id = " +id;
		try
		{
			ResultSet rs = excuteQuery(query);
			rs.next();
			Course course = new Course(
					
					rs.getInt("Subject"), 
					rs.getDate("DateOfStarting"), 
					rs.getDate("DateOfEnding"), 
					rs.getString("DateOfWeek"), 
					rs.getInt("PartOfStarting"), 
					rs.getInt("PartOfEnding"), 
					rs.getInt("NumOfStudents"), 
					rs.getString("Room"), 
					rs.getBoolean("Activate"),
					rs.getInt("Teacher"),
					rs.getString("Name"),
					rs.getInt("Id"));
			return course;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());

		}
		return null;
	}
	public static Course getCourseByNameSubject(String subject) {
		return null;
	}
	public static boolean deleteCourse(int id) {
		String query = "DELETE FROM onlinequiz.courses WHERE Id = ?";
		
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
	public static boolean deleteDetailCourse(int id) {
		String query = "DELETE FROM onlinequiz.detailcourses WHERE Id = ?";
		
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
	//xoa sinh vien ra khoi lop hoc
	public static boolean deleteDetailCourseInClass(int idCourse,int student) {
		String query = "DELETE FROM onlinequiz.detailcourses WHERE Course = ? and Student=?";
		
		List<Object> params = new ArrayList<>();
		params.add(idCourse);
		params.add(student);
		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean updateCourse(Course course)
	{
		String query = "UPDATE onlinequiz.courses SET Subject= ? ,DateOfStarting= ? , DateOfEnding= ? , DateOfWeek= ? ,PartOfStarting = ? , PartOfEnding= ? ,NumOfStudents= ? , Room = ? ,Activate = ?,Teacher = ? ,Name= ? WHERE Id=?";
		List<Object> params = new ArrayList<>();
		params.add(course.getSubjectId());
		params.add(course.getDateOfStarting());
		params.add(course.getDateOfEnding());
		params.add(course.getDateOfWeek());
		params.add(course.getPartOfStarting());
		params.add(course.getPartOfEnding());
		params.add(course.getNumberOfStudent());
		params.add(course.getRoom());
		params.add(course.isActivate());
		params.add(course.getTeacher());
		params.add(course.getName());
		params.add(course.getCourseId());
	

		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	public static boolean addCourse(Course course) {
		String query = "INSERT INTO onlinequiz.courses (Subject, DateOfStarting, DateOfEnding,DateOfWeek,PartOfStarting,PartOfEnding,NumOfStudents,Room,Activate,Name) " + 
				"VALUES (?,?,?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<>();
		params.add(course.getSubjectId());
		params.add(course.getDateOfStarting());
		params.add(course.getDateOfEnding());
		params.add(course.getDateOfWeek());
		params.add(course.getPartOfStarting());
		params.add(course.getPartOfEnding());
		params.add(course.getNumberOfStudent());
		params.add(course.getRoom());
		params.add(course.isActivate());
		params.add(course.getName());
		
		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	public static boolean addStudentCourse(int courseId, int studentId)
	{
		String query = "INSERT INTO onlinequiz.detailcourses (Course, Student) " + 
				"VALUES (?,?)";
		List<Object> params = new ArrayList<>();
		params.add(courseId);
		params.add(studentId);

		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	public static int countCourse() {
		String sql="select count(id) from courses";
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

	public static List<Course> getAllCourse(int firstResult, int amoutResult) {
		String query = "select * from courses order by Id LIMIT ?,?";
		List<Object> param=new ArrayList<>();
		param.add(firstResult);
		param.add(amoutResult);
		List<Course> lstCourse =null;

		try {	
			lstCourse= new ArrayList<>();
			ResultSet rs = excuteQuery(query,param);
			while (rs.next()) {
				Course courses = new Course(
						rs.getInt("Subject"), 
						rs.getDate("DateOfStarting"), 
						rs.getDate("DateOfEnding"), 
						rs.getString("DateOfWeek"), 
						rs.getInt("PartOfStarting"), 
						rs.getInt("PartOfEnding"), 
						rs.getInt("NumOfStudents"), 
						rs.getString("Room"), 
						rs.getBoolean("Activate"),
						rs.getInt("Teacher"),
						rs.getString("Name"),
						rs.getInt("Id")
);
				lstCourse.add(courses);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return lstCourse;
	}
}