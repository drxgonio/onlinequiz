package grouptwo.quizexam.controller;

import java.io.IOException;
import java.sql.Date;

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


@WebServlet("/EditCourse")
public class EditCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EditCourseController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command=request.getParameter("command");
		String id=request.getParameter("id");
		String subjectName=request.getParameter("subjectName");
		Course course=CourseService.getCourseById(Integer.parseInt(id));
		Subject subject=SubjectService.getSubjectsById(Integer.parseInt(id));
		request.setAttribute("course", course);
		request.setAttribute("subject", subject);
		request.setAttribute("subjectName", subjectName);
		 RequestDispatcher dispatcher;
		 switch(command)
			{
			case "delete":
				CourseService.deleteCourse(Integer.parseInt(id));
				String contextPath=request.getContextPath();
				response.sendRedirect(contextPath+"/ListCourse");
				break;
			case "update":
		
					  dispatcher = request.getServletContext()
				                .getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/editCourse.jsp");
					 
				        dispatcher.forward(request, response);
				        command="";
				        break;
			}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		////
		String Subject=request.getParameter("Subject");
		Subject SubjectID=SubjectService.getSubjectsByName(Subject);
		String DateOfWeek=request.getParameter("DateOfWeek");
		String PartOfStarting=request.getParameter("PartOfStarting");
		String PartOfEnding=request.getParameter("PartOfEnding");
		String NumofStudents=request.getParameter("NumofStudents");
		String Room=request.getParameter("Room");
		String DateOfStarting=request.getParameter("DateOfStarting");
		String DateOfEnding=request.getParameter("DateOfEnding");
		String Teacher=request.getParameter("Teacher");
		String Name=request.getParameter("Name");
		boolean Activate=true;
		
		
		//System.out.println(Subject+DateOfWeek+PartOfStarting+PartOfEnding+NumofStudents+Room+DateOfStarting+DateOfEnding+Teacher+Name+Activate+id+     b);
		CourseService.updateCourse(new Course(SubjectID.getSubjectID(),Date.valueOf(DateOfStarting),Date.valueOf(DateOfEnding),DateOfWeek,
				Integer.parseInt(PartOfStarting),Integer.parseInt(PartOfEnding),Integer.parseInt(NumofStudents),Room,Activate,Integer.parseInt(Teacher),Name,Integer.parseInt(id)));
		
		String contextPath=request.getContextPath();
		response.sendRedirect(contextPath+"/ListCourse");
		
		
		
		
	}

}
