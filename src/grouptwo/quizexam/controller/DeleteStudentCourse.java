package grouptwo.quizexam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grouptwo.quizexam.service.CourseService;


@WebServlet("/DeleteStudentCourse")
public class DeleteStudentCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DeleteStudentCourse() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String idCourse=request.getParameter("idCourse");
		String student=request.getParameter("student");
		CourseService.deleteDetailCourseInClass(Integer.parseInt(idCourse), Integer.parseInt(student));
		String contextPath=request.getContextPath();
		response.sendRedirect(contextPath+"/ListStudent?idCourse="+idCourse);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
