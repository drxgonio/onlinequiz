package grouptwo.quizexam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grouptwo.quizexam.model.Answer;
import grouptwo.quizexam.model.Question;
import grouptwo.quizexam.model.Subject;
import grouptwo.quizexam.service.AnswerService;
import grouptwo.quizexam.service.BaseService;
import grouptwo.quizexam.service.QuestionService;
import grouptwo.quizexam.service.SubjectService;


@WebServlet("/AddQuestion")
public class AddQuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		List<Subject> lstSubject = SubjectService.getAllSubjects();
		
		request.setAttribute("lstSubject", lstSubject);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/Views/QLCauHoi/addQuestion.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
			
		String level=request.getParameter("radLevel");
		
		String subject=request.getParameter("subjects");
		String question=request.getParameter("question");
		
		
		switch(level)
		{
			case "de":
				level="Dễ";
				break;
			case "tb":
				level="Trung Bình";
				break;
			case "kh":
				level="Khó";
				break;
		}
		
		QuestionService.addQuestions(new Question(question, "", level,-1, -1, Integer.parseInt(subject)));
		int questionId = BaseService.getIdAfterInsert();
		
		
		String radAns=request.getParameter("radAns");
		String correctAns = request.getParameter(radAns);

		for(int i = 1; i<=4; i++)
		{
			String ans = request.getParameter("ans"+i);
			AnswerService.addAnswers(new Answer(questionId,ans));

			if(ans == correctAns)
			{
				int ansId = BaseService.getIdAfterInsert();
				QuestionService.updateCorrectAnswer(questionId, ansId);
			}
		}
		
		response.sendRedirect("ListQuestion");
		
	}

}