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
import grouptwo.quizexam.model.Profilestudent;
import grouptwo.quizexam.service.CourseService;
import grouptwo.quizexam.service.ProfilestudentService;
import grouptwo.quizexam.utils.CalculationHelper;


@WebServlet("/ListStudent")
public class ListStudentCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListStudentCourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Profilestudent> prfi_Stu= null;
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
				prfi_Stu=ProfilestudentService.getAllProfilesutudent(idCourse,(page-1)*ParamaterStatic.amoutResult,ParamaterStatic.amoutResult);
			}
				
		}
		else
		{
			request.setAttribute("idCourse", request.getParameter("idCourse"));
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
				prfi_Stu=ProfilestudentService.getAllProfilesutudent(idCourse,page-1,ParamaterStatic.amoutResult);
				getServletContext().setAttribute("numberPage",numberPage);
				getServletContext().setAttribute("idCourse",idCourse);
			}
			else
			{
				page=Integer.parseInt(request.getParameter("page"));
				prfi_Stu=ProfilestudentService.getAllProfilesutudent(idCourse,(page-1)*ParamaterStatic.amoutResult,ParamaterStatic.amoutResult);
			}	
		}
	
		request.setAttribute("list",prfi_Stu);
		RequestDispatcher dispatcher 
        = this.getServletContext()//
              .getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/listStudentForCourses.jsp");
		 dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
