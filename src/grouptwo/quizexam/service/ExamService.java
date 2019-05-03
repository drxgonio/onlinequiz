package grouptwo.quizexam.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grouptwo.quizexam.model.Exam;
import grouptwo.quizexam.model.Profilestudent;

public class ExamService extends BaseService{
	
	public ExamService() {
		super();
	}

	public static List<Exam> getAllExamForCourse(int idCourse,int firstReSult, int amoutResult) {
		String query = "SELECT * FROM detailcourseexams,exams where detailcourseexams.Exam=exams.Id and Course=? order by exams.Id LIMIT ?,?";
		List<Object> param=new ArrayList<>();
		param.add(idCourse);
		param.add(firstReSult);
		param.add(amoutResult);
		List<Exam> lstProFile = new ArrayList<>();
		try {
			ResultSet rs = excuteQuery(query,param);
			while (rs.next()) {
				Exam exam = new Exam(
						rs.getInt("Id"), 
						rs.getString("name"),
						rs.getTimestamp("timeStarting"), 
						rs.getInt("numQuestions"), 
						rs.getTimestamp("timeFinishing"), 
						rs.getInt("Subject"), 
						rs.getBoolean("activate"), 
						rs.getInt("creator"), 
						rs.getInt("numDiffi"), 
						rs.getInt("numNormal"), 
						rs.getInt("numEasy"), 
						rs.getInt("limitTime"));
						
						
				lstProFile.add(exam);
			}
			return lstProFile;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return null;
	
	}
	public static List<Exam> getAllExam() {
		
		String query = "SELECT * FROM onlinequiz.exams";
		List<Exam> lstExams = new ArrayList<>();

		try {
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				Exam exam = new Exam(
						rs.getInt("Id"), 
						rs.getString("name"),
						rs.getTimestamp("timeStarting"), 
						rs.getInt("numQuestions"), 
						rs.getTimestamp("timeFinishing"), 
						rs.getInt("Subject"), 
						rs.getBoolean("activate"), 
						rs.getInt("creator"), 
						rs.getInt("numDiffi"), 
						rs.getInt("numNormal"), 
						rs.getInt("numEasy"), 
						rs.getInt("limitTime"));
				lstExams.add(exam);
	        }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}	
		return lstExams;
		
	}

	public static Exam getExamById(int id) {
		String query = "Select * from exams where Id = " +id;
		try
		{
			ResultSet rs = excuteQuery(query);
			rs.next();
			Exam exams = new Exam(rs.getInt("Id"), 
					rs.getString("name"),
					rs.getTimestamp("timeStarting"), 
					rs.getInt("numQuestions"), 
					rs.getTimestamp("timeFinishing"), 
					rs.getInt("Subject"), 
					rs.getBoolean("activate"), 
					rs.getInt("creator"), 
					rs.getInt("numDiffi"), 
					rs.getInt("numNormal"), 
					rs.getInt("numEasy"), 
					rs.getInt("limitTime"));
			return exams;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());

		}
		return null;
	}
	public static List<Integer> getLsIdOfUser(int idUser)
	{
		List<Integer> lsId=null;
		List<Object> param=new ArrayList<>();
		String sql="select exam from detailcourses dc, detailcourseexams dce where dc.course = dce.course and dc.student = ? and (student,exam) not in (select Student,Exam from resulttests)";
		param.add(idUser);
		try {
			lsId=new ArrayList<>();
			ResultSet rs=excuteQuery(sql, param);
			while(rs.next())
			{
				lsId.add(rs.getInt(1));
			}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return lsId;
	}
	/*public Exam getExamByName(String subject) {
		String query = "Select * from Exams where Name = " +subject;
		try
		{
			ResultSet rs = excuteQuery(query);
			Exam exams = new Exam(
					rs.getInt(1),
					rs.getString(2),
					rs.getDate(3),
					rs.getInt(4),
					rs.getDate(5),
					rs.getInt(6),rs.getBoolean(7),
					rs.getString(8));
			return exams;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());

		}
		return null;
	}*/
	
	public static boolean deleteExam(int id) {
		String query = "DELETE FROM exams WHERE Id=?" ;
		List<Object> params=new ArrayList<>();
		params.add(id);
		try {
			
			return executeUpdate(query,params);
			
		}
		catch(SQLException ex) {
			
			//Logger.getLogger(ExamsService.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}
	public static boolean InsertExam(String name,Date timeStarting,int NumQuestions,Date timeFinishing,int classlop,int avtivate,String creator)
	{
		String query="Insert into Exams(exams.Name,TimeStarting,NumQuestions,TimeFinishing,Class,Avtivate,Creator) values(?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<>();
		params.add(name);
		params.add(timeStarting);
		params.add(NumQuestions);
		params.add(timeFinishing);
		params.add(classlop);
		params.add(avtivate);
		params.add(creator);
		try {
			return executeUpdate(query,params);
			
		}
		catch(SQLException ex) {
			
			//Logger.getLogger(ExamsService.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return false;
	}
	public static boolean UpdateExam(Exam exam)
	{
		String query="update Exams set Name=?,"
				+ "TimeStarting=?,"
				+ "NumQuestions=?,"
				+ "TimeFinishing=?,"
				+ "Subject=?,"
				+ "Activate=?,"
				+ "Creator=?,"
				+ "NumDiffi=?,"
				+ "NumNormal=?,"
				+ "NumEasy=?,"
				+ "LimitTime=?  "
				+ "where Id=?";
		List<Object> params=new ArrayList<>();
		params.add(exam.getName());
		params.add(exam.getTimeStarting());
		params.add(exam.getNumQuestions());
		params.add(exam.getTimeFinishing());
		params.add(exam.getSubjectId());
		params.add(exam.isActivate());
		params.add(null);
		params.add(exam.getNumDifficult());
		params.add(exam.getNumNormal());
		params.add(exam.getNumEasy());
		params.add(exam.getLimitTime());
		params.add(exam.getId());
		try {
			return executeUpdate(query, params);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return false;
	}

	public static int countExam() {
		String sql="select count(id) from  exams;";
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

	public static List<Exam> getAllExam(int firstResult, int amoutResult) {
	
		String query = "select * from exams order by Id LIMIT ?,?";
		List<Object> param=new ArrayList<>();
		param.add(firstResult);
		param.add(amoutResult);
		List<Exam> lstExam =null;

		try {	
			lstExam= new ArrayList<>();
			ResultSet rs = excuteQuery(query,param);
			while (rs.next()) {
				Exam questions = new Exam(
						rs.getInt("Id"), 
						rs.getString("name"), 
						rs.getTimestamp("TimeStarting"), 
						rs.getInt("NumQuestions"), 
						rs.getTimestamp("TimeFinishing"), 
						rs.getInt("Subject"), 
						rs.getBoolean("Activate"),	 
						rs.getInt("Creator"),
						rs.getInt("NumDiffi"),
						rs.getInt("NumNormal"), 
						rs.getInt("NumEasy"), rs.getInt("LimitTime"));
				lstExam.add(questions);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return lstExam;
	}

	public static List<Exam> searchExam(String character) {
		String sql="SELECT * FROM exams WHERE id LIKE ?";
		
		List<Exam> lstExams = new ArrayList<>();
		try {
			ResultSet rs = searchExcuteQuery(sql,character);
			while (rs.next()) {
				Exam exams = new Exam(
						rs.getInt("Id"), 
						rs.getString("name"), 
						rs.getTimestamp("TimeStarting"), 
						rs.getInt("NumQuestions"), 
						rs.getTimestamp("TimeFinishing"), 
						rs.getInt("Subject"), 
						rs.getBoolean("Activate"),	 
						rs.getInt("Creator"),
						rs.getInt("NumDiffi"),
						rs.getInt("NumNormal"), 
						rs.getInt("NumEasy"), 
						rs.getInt("LimitTime"));
				lstExams.add(exams);
			}
			return lstExams;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return null;
	}
	public static boolean addExam(Exam exam)
	{
		String query="Insert into onlinequiz.exams(Name,TimeStarting,TimeFinishing,NumQuestions,Subject,Activate,Creator,NumDiffi,NumNormal,NumEasy,LimitTime) "
				+ " value(?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> params = new ArrayList<>();
		params.add(exam.getName());
		params.add(exam.getTimeStarting());
		params.add(exam.getTimeFinishing());
		params.add(exam.getNumQuestions());
		params.add(exam.getSubjectId());
		params.add(exam.isActivate());
		params.add(null);
		params.add(exam.getNumDifficult());
		params.add(exam.getNumNormal());
		params.add(exam.getNumEasy());
		params.add(exam.getLimitTime());

		try {
			return executeUpdate(query, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return false;
	}

	public static List<Exam> getExamForSubject(int idSubject) {
		String sql="select * from exams where subject=?";
		List<Object> params = new ArrayList<>();
		params.add(idSubject);
		List<Exam> lstExams = new ArrayList<>();
		try {
			ResultSet rs = excuteQuery(sql);
			while (rs.next()) {
				Exam exam = new Exam(
						rs.getInt("Id"), 
						rs.getString("name"),
						rs.getTimestamp("timeStarting"), 
						rs.getInt("numQuestions"), 
						rs.getTimestamp("timeFinishing"), 
						rs.getInt("Subject"), 
						rs.getBoolean("activate"), 
						rs.getInt("creator"), 
						rs.getInt("numDiffi"), 
						rs.getInt("numNormal"), 
						rs.getInt("numEasy"), 
						rs.getInt("limitTime"));
				lstExams.add(exam);
	        }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}	
		return lstExams;
	}

	

}
