package grouptwo.quizexam.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetailCourseExamService extends BaseService  {

	public DetailCourseExamService() {
		super();
	}

	public static boolean addGrantExamForCourse(int idCourse, int idExam) {
		String sql="insert into detailcourseexams values(?,?)";
		List<Object> params=new ArrayList<>();
		params.add(idCourse);
		params.add(idExam);
		try {
			boolean action = executeUpdate(sql, params);
			return action;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
