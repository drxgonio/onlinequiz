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

import grouptwo.quizexam.model.Course;
import grouptwo.quizexam.model.Exam;
import grouptwo.quizexam.model.Subject;
import grouptwo.quizexam.service.CourseService;
import grouptwo.quizexam.service.ExamService;
import grouptwo.quizexam.service.SubjectService;

/**
 * Servlet implementation class GrantExamControler
 */
@WebServlet("/GrantExam")
public class GrantExamControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrantExamControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			if(request.getParameter("subjectId")!=null)
			{
				int idSubject=Integer.parseInt(request.getParameter("subjectId"));
				List<Exam> lsExam=new ArrayList<>();
				lsExam=ExamService.getExamForSubject(idSubject);
				request.setAttribute("lsExam", lsExam);
			}
			else
			{
				List<Course> lsCourses=CourseService.getAllCourse();
				List<Subject> lsSubject=SubjectService.getAllSubjects();
				request.setAttribute("lsCourse", lsCourses);
				request.setAttribute("lsSubject", lsSubject);
			}
		
					
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
