package grouptwo.quizexam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grouptwo.quizexam.data.ParamaterStatic;
import grouptwo.quizexam.model.Answer;
import grouptwo.quizexam.model.Question;
import grouptwo.quizexam.service.QuestionService;

/**
 * Servlet implementation class DoTestController
 */
@WebServlet("/DoTest")
public class DoTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoTestController() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if((boolean)session.getAttribute("isStart")==true && session.getAttribute("isComplete")==null)
		{	
		int idExam = (int) session.getAttribute("idExamCurent");
		int page = 1;
		List<Question> lsQusAllParent = new ArrayList<>();
		List<Question> lsQusChild = new ArrayList<>();
		
		if (request.getParameter("page") == null) {//loadTrang 
			//loi o day
			lsQusAllParent = QuestionService.getQuestionForExam(idExam);
			session.setAttribute("lsQusAllParent", lsQusAllParent);
			int numberPage = lamTron(lsQusAllParent.size(), ParamaterStatic.amoutResult);
			lsQusChild = lsQusAllParent.subList((page - 1) * ParamaterStatic.amoutResult,
					(page - 1) * ParamaterStatic.amoutResult + ParamaterStatic.amoutResult);
			session.setAttribute("numberPage", numberPage);
		} 
		else 
		{
			lsQusAllParent = (List<Question>) session.getAttribute("lsQusAllParent");
			int numberPage = lamTron(lsQusAllParent.size(), ParamaterStatic.amoutResult);
			page = Integer.parseInt(request.getParameter("page"));
			if (page == numberPage)
				lsQusChild = lsQusAllParent.subList((page - 1) * ParamaterStatic.amoutResult, lsQusAllParent.size());
			else
				lsQusChild = lsQusAllParent.subList((page - 1) * ParamaterStatic.amoutResult,
						(page - 1) * ParamaterStatic.amoutResult + ParamaterStatic.amoutResult);
		}
		request.setAttribute("lsQus", lsQusChild);
		RequestDispatcher dispatcher = this.getServletContext()//
				.getRequestDispatcher("/WEB-INF/Views/SinhVien/tranglambaithi.jsp");
		dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = this.getServletContext()//
					.getRequestDispatcher("/Submit");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		HttpSession session=request.getSession();
		String[] answerSelect=request.getParameterValues("answerSelect[]");
		List<Question> lsQusAllParent=(List<Question>)session.getAttribute("lsQusAllParent");
		for(Question i:lsQusAllParent)
		{
			for(String c:answerSelect)
			{
				if(GetQus(c)==i.getQuestionId())
				{
					int ansSel=GetAns(c);
					for(Answer answer:i.getLsAnswer())
					{		//reset tick
						if(answer.getisTick()==true)
						{
							answer.setTick(false);
							i.setIsTick(false);
						}
						//tick true
						if(ansSel==answer.getId())
						{
							answer.setTick(true);
							i.setIsTick(true);
						}
					}
				}
			}
		}		
		session.setAttribute("lsQusAllParent", lsQusAllParent);
		
		
	}

	private int lamTron(int numberFilm, int row) {
		int kq;
		if (numberFilm % row != 0) {
			kq = numberFilm / row + 1;
		} else {
			kq = numberFilm / row;
		}
		return kq;

	}
	   public static int GetQus(String a) {
	    	String b[]=a.split("_");
	    	return Integer.parseInt(b[0]);
	    }
	    public static int GetAns(String a) {
	    	String b[]=a.split("_");
	    	return Integer.parseInt(b[1]);
	    }

}
