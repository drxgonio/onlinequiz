package grouptwo.quizexam.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grouptwo.quizexam.model.Course;
import grouptwo.quizexam.model.Subject;
import grouptwo.quizexam.service.CourseService;
import grouptwo.quizexam.service.SubjectService;

@WebServlet("/AddCourse")
public class AddCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCourseController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		List<Subject> lstSubject = SubjectService.getAllSubjects();
		request.setAttribute("lstSubject", lstSubject);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/addCourse.jsp");
		dispatcher.forward(request, response);	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Boolean isActivate = request.getParameter("ckbActivate")!=null;
		String name = request.getParameter("name");
		String dayOfWeek = request.getParameter("dayOfWeek");
		int startPart = Integer.parseInt(request.getParameter("startPart"));
		int endPart = Integer.parseInt(request.getParameter("endPart"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		String room = request.getParameter("room");
		Date fromDate = Date.valueOf(request.getParameter("fromDate"));
		Date endDate = Date.valueOf(request.getParameter("endDate"));
		int subjectId = Integer.parseInt(request.getParameter("sltSubject"));
		
		System.out.println(request.getParameter("sltSubject"));

		CourseService.addCourse(new Course(subjectId,fromDate,endDate,dayOfWeek,startPart,endPart,amount,room,isActivate,0,name));
		response.sendRedirect("ListCourse");
	}

}

