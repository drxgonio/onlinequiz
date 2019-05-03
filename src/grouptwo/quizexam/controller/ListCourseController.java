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
import grouptwo.quizexam.model.Course;
import grouptwo.quizexam.service.CourseService;


@WebServlet("/ListCourse")
public class ListCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListCourseController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Course> coureseLs= null;
		int page=1;
		if(request.getParameter("page")==null)
		{
			int numberPage;
			//Dem so trang
			numberPage=lamTron(CourseService.countCourse(),ParamaterStatic.amoutResult);
			coureseLs=CourseService.getAllCourse(page-1,ParamaterStatic.amoutResult);
			getServletContext().setAttribute("numberPage",numberPage);
		}
		else
		{
			page=Integer.parseInt(request.getParameter("page"));
			coureseLs=CourseService.getAllCourse((page-1)*ParamaterStatic.amoutResult,ParamaterStatic.amoutResult);
		}	
		request.setAttribute("list",coureseLs);
		RequestDispatcher dispatcher 
        = this.getServletContext()//
              .getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/listCourse.jsp");
		 dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
