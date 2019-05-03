package grouptwo.quizexam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grouptwo.quizexam.utils.TimeUltils;

/**
 * Servlet implementation class CountDownController
 */
@WebServlet("/CountDown")
public class CountDownController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	boolean isCount=false;
	int count=0;
	public CountDownController() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		HttpSession session=request.getSession();
	
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();	
		long timeLimit;
		String timeFinshing=(String) session.getAttribute("timeFinishing");
		String currentTime=TimeUltils.getCurrentTime();
		timeLimit=TimeUltils.timeConLai(timeFinshing, currentTime)/1000;
		System.out.println(timeFinshing);
		System.out.println(currentTime);
		System.out.println(timeLimit);
		if (timeLimit >= 0) {
			out.print(TimeUltils.getMinutes(timeLimit)+" : "+TimeUltils.getSecondRemain(timeLimit));
		}
		else
		{
			out.print("Bạn đã thi xong ùi!");
			session.setAttribute("isComplete",true);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
