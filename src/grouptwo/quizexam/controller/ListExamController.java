package grouptwo.quizexam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grouptwo.quizexam.data.ParamaterStatic;
import grouptwo.quizexam.model.Course;
import grouptwo.quizexam.model.Exam;
import grouptwo.quizexam.model.Subject;
import grouptwo.quizexam.service.CourseService;
import grouptwo.quizexam.service.DetailCourseExamService;
import grouptwo.quizexam.service.ExamService;
import grouptwo.quizexam.service.SubjectService;

@WebServlet("/ListExam")
public class ListExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListExamController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Exam> exl= null;
		int page=1;
		if(request.getParameter	("page")==null)
		{
			int numberPage;
			//Dem so trang
			numberPage=lamTron(ExamService.countExam(),ParamaterStatic.amoutResult);
			exl=ExamService.getAllExam(page-1,ParamaterStatic.amoutResult);
			getServletContext().setAttribute("numberPage",numberPage);
			List<Course> lsCourses=CourseService.getAllCourse();
			List<Subject> lsSubject=SubjectService.getAllSubjects();
			getServletContext().setAttribute("lsCourse", lsCourses);	
		}
		else
		{
			page=Integer.parseInt(request.getParameter("page"));
			exl=ExamService.getAllExam((page-1)*ParamaterStatic.amoutResult,ParamaterStatic.amoutResult);
		}	
		request.setAttribute("list",exl);
		
		RequestDispatcher dispatcher 
        = this.getServletContext()//
              .getRequestDispatcher("/WEB-INF/Views/QLDeThi/ManageExam.jsp");
		 dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		if(request.getParameter("idCourse")!=null && request.getParameter("idExam")!=null)
		{
			int idCourse=Integer.parseInt(request.getParameter("idCourse"));
					int idExam=Integer.parseInt(request.getParameter("idExam"));
			if(DetailCourseExamService.addGrantExamForCourse(idCourse,idExam))
			{
				out.println("1");
			}
			else
			{
				out.println("0");
			}
				
			
		}
	}
	private int lamTron(int numberFilm,int row)
	{
		int kq;
		if(numberFilm%row!=0)
		{
			kq=numberFilm/row+1;
		}
		else
		{
			kq=numberFilm/row;
		}
		return kq;
		
	}

}
