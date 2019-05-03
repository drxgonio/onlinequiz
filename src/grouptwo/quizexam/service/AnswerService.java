package grouptwo.quizexam.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grouptwo.quizexam.model.Answer;

public class AnswerService extends BaseService {

	public AnswerService() {
		super();
	}
	public static List<Answer> getAllAnswers() {
		String query = "Select * from answers";
		List<Answer> lstAnswers = new ArrayList<>();

		try {
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				Answer answers = new Answer(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3));
				lstAnswers.add(answers);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return lstAnswers;
	}
	public static List<Answer> getAllAnswersQuestion(int name) {
		String query = "Select * from answers where Question="+name;
		List<Answer> lstAnswers = new ArrayList<>();

		try {
			ResultSet rs = excuteQuery(query);
			while (rs.next()) {
				Answer answers = new Answer(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3));
				lstAnswers.add(answers);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return lstAnswers;
	}

	public static Answer getAnswersById(int id) {
		String query = "Select * from answers where Id = " +id;
		Answer answer = null;
		try
		{
			ResultSet rs = excuteQuery(query);
			while(rs.next())
			{
				answer = new Answer(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3));
			}
			
			return answer;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());

		}
		return null;
	}
	public static List<Answer> getAnswersByIdForQuestion(int id_questiton) {
		String query = "Select * from onlinequiz.answers where Question = ?";
		List<Object> params = new ArrayList<>();
		params.add(id_questiton);
		
		try {
			List<Answer> lstAnswers = new ArrayList<>();

			ResultSet rs = excuteQuery(query,params);
			while (rs.next()) {
				Answer answers = new Answer(rs.getInt("Id"),rs.getInt("Question"),rs.getString("Answer"));
				lstAnswers.add(answers);
			}
			return lstAnswers;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public Answer getAnswersByName(String answer) {
		return null;
	}

	public static boolean deleteAnswers(int id) {
		String query="Delete from answers where Id=?";
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

	public static boolean updateAnswers(Answer answer) {
		{
			String query ="update answers set "
					+ "Question = ?,"
					+ "Answer = ?,"
					+ "Where Id= ?";
			List<Object> params= new ArrayList<>();
			params.add(answer.getQuestionId());
			params.add(answer.getAnswer());
			params.add(answer.getId());
			try {
				boolean action = executeUpdate(query, params);
				return action;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}
	}
	public static int returnIdAnsAfterInsert(Answer answer)
	{
		if(addAnswers(answer))
		{
			String sql=" SELECT * FROM answers WHERE id= LAST_INSERT_ID()";
			
			try {
				ResultSet rs = excuteQuery(sql);
				rs.next();
				return rs.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return -1;
	}

	public static boolean addAnswers(Answer answer) {
		String query="Insert into answers (Question,Answer)"
				+ "values (?,?)";
		List<Object> params = new ArrayList<>();
		params.add(answer.getQuestionId());
		params.add(answer.getAnswer());
		try {
			boolean action = executeUpdate(query, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
}