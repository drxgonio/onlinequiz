package grouptwo.quizexam.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import grouptwo.quizexam.model.DetailResult;

public class DetailResultService extends BaseService {

	public DetailResultService() {
		// TODO Auto-generated constructor stub
	}
	public static boolean addDetailResult(DetailResult deRs)
	{
		String sql="insert into detailresult value(?,?)";
		List<Object> params=new ArrayList<>();
		params.add(deRs.getResultId());
		params.add(deRs.getAnswerId());
		
		try
		{
			return executeUpdate(sql, params);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
		
	}
}
