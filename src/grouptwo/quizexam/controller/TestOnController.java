package grouptwo.quizexam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grouptwo.quizexam.model.Exam;

import grouptwo.quizexam.service.ExamService;

import grouptwo.quizexam.utils.TimeUltils;

/**
 * Servlet implementation class TestOnController
 */
@WebServlet("/TestOn")
public class TestOnController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestOnController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws  IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter print=response.getWriter();
		if (session.getAttribute("isStart") == null) {
			int idExam = Integer.parseInt(request.getParameter("id"));
			Exam exam = new Exam();
			exam = ExamService.getExamById(idExam);
				if (TimeUltils.isInHappyHour(exam.getTimeStarting().toString(), exam.getTimeFinishing().toString())) {
					request.setAttribute("exam", exam);
					session.setAttribute("idExamCurent", idExam);
					session.setAttribute("isStart", false);
					session.setAttribute("TimeMinuteLimit", exam.getLimitTime());
					RequestDispatcher dispatcher = this.getServletContext()//
							.getRequestDispatcher("/WEB-INF/Views/SinhVien/TrangXacNhanThi.jsp");
					dispatcher.forward(request, response);
				} else {
					
					print.println("Exam was closed, because timeout! return home and select exam another");
				}
			

		} else {
			if ((boolean) session.getAttribute("isStart") == false) {
				session.setAttribute("isStart", true);
				int timeminuteLimit=(int) session.getAttribute("TimeMinuteLimit");
				String timeStarting=TimeUltils.getCurrentTime();
				String timeFinishing=TimeUltils.addTime(timeStarting, timeminuteLimit);
				session.setAttribute("timeStarting", timeStarting);
				session.setAttribute("timeFinishing", timeFinishing);

			}
			if (request.getParameter("id") != null) {
				int idExam = Integer.parseInt(request.getParameter("id"));
				if (idExam != (int) session.getAttribute("idExamCurent")) {
					RequestDispatcher dispatcher = this.getServletContext()//
							.getRequestDispatcher("/HomeQuizController");
					dispatcher.forward(request, response);
					return;
				}
			}

			RequestDispatcher dispatcher = this.getServletContext()//
					.getRequestDispatcher("/DoTest");
			dispatcher.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public static boolean isInHappyHour(String startHour, String endHour) {

		boolean result = false;

		SimpleDateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date start = null;
		try {
			start = (Date) hourFormat.parse(startHour);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date end = null;
		try {
			end = (Date) hourFormat.parse(endHour);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date  now = new Date(System.currentTimeMillis());
		String nowHourStr = hourFormat.format(now.getTime());
		try {
			Date nowHour = (Date) hourFormat.parse(nowHourStr);
			if (nowHour.after(start) && nowHour.before(end) || (nowHour.equals(start) || (nowHour.equals(end)))) {
				result = true;
			}

		} catch (ParseException e) {
			result = false;
		}

		return result;

	}

}
