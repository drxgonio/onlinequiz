package grouptwo.quizexam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grouptwo.quizexam.data.ParamaterStatic;
import grouptwo.quizexam.model.Exam;
import grouptwo.quizexam.model.Profilestudent;
import grouptwo.quizexam.service.CourseService;
import grouptwo.quizexam.service.ExamService;
import grouptwo.quizexam.service.ProfilestudentService;
import grouptwo.quizexam.utils.CalculationHelper;

/**
 * Servlet implementation class ListCoursesExamController
 */
@WebServlet("/ListCoursesExam")
public class ListCoursesExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCoursesExamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Exam> lstExam= null;
		int page=1;

		int idCourse = 0;

		
		if(request.getParameter("idCourse")==null)
		{
			getServletContext().setAttribute("lsCourses",CourseService.getAllCourse());
			if(getServletContext().getAttribute("idCourse")!=null)
			{
				idCourse=(int)getServletContext().getAttribute("idCourse");
			}
			if(request.getParameter("page")!=null)
			{
				page=Integer.parseInt(request.getParameter("page"));
				lstExam=ExamService.getAllExamForCourse(idCourse,(page-1)*ParamaterStatic.amoutResult,ParamaterStatic.amoutResult);
			}
				
		}
		else
		{
			if(request.getParameter("idCourse")!=getServletContext().getAttribute("idCourse")+"")
			{
				idCourse=Integer.parseInt(request.getParameter("idCourse"));
				getServletContext().setAttribute("idCourse",idCourse);
			}
			
			if(request.getParameter("page")==null)
			{
				int numberPage;
				//Dem so trang
				numberPage= CalculationHelper.rouding(ProfilestudentService.countProfileForCourse(idCourse),ParamaterStatic.amoutResult);
				lstExam=ExamService.getAllExamForCourse(idCourse,page-1,ParamaterStatic.amoutResult);
				getServletContext().setAttribute("numberPage",numberPage);
				getServletContext().setAttribute("idCourse",idCourse);
			}
			else
			{
				page=Integer.parseInt(request.getParameter("page"));
				lstExam=ExamService.getAllExamForCourse(idCourse,(page-1)*ParamaterStatic.amoutResult,ParamaterStatic.amoutResult);
			}	
		}
	
		request.setAttribute("list",lstExam);
		RequestDispatcher dispatcher 
        = this.getServletContext()//
              .getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/ListExamForCourse.jsp");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
