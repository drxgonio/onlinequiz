package grouptwo.quizexam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import grouptwo.quizexam.model.Exam;
import grouptwo.quizexam.service.ExamService;


@WebServlet("/SearchListExam")
public class SearchListExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchListExamController() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String character = request.getParameter("character");

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		List<Exam> qsl = ExamService.searchExam(toLower(character));

		// respone result
		String json = new Gson().toJson(qsl);
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private String toLower(String result)
	{
		String strUpper = result.toLowerCase();
		return strUpper;
	}

}
