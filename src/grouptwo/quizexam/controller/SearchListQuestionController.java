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

import grouptwo.quizexam.model.Question;
import grouptwo.quizexam.service.QuestionService;

@WebServlet("/SearchListQuestion")
public class SearchListQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchListQuestionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String character=request.getParameter("character");
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		List<Question> qsl=QuestionService.searchQuestion(toLower(character));
		
		//respone result
		String json = new Gson().toJson(qsl);
		out.print(json);
	}
	
	private String toLower(String result)
	{
		String strUpper = result.toLowerCase();
		return strUpper;
	}


}
