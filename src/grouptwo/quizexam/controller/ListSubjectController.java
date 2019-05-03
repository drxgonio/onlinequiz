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
import grouptwo.quizexam.model.Subject;
import grouptwo.quizexam.service.CourseService;
import grouptwo.quizexam.service.SubjectService;


@WebServlet("/ListSubject")
public class ListSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListSubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subject> coureseLs= null;
		int page=1;
		if(request.getParameter("page")==null)
		{
			int numberPage;
			//Dem so trang
			numberPage=lamTron(CourseService.countCourse(),ParamaterStatic.amoutResult);
			coureseLs=SubjectService.getAllSubject(page-1,ParamaterStatic.amoutResult);
			getServletContext().setAttribute("numberPage",numberPage);
		}
		else
		{
			page=Integer.parseInt(request.getParameter("page"));
			coureseLs=SubjectService.getAllSubject((page-1)*ParamaterStatic.amoutResult,ParamaterStatic.amoutResult);
		}	
		request.setAttribute("list",coureseLs);
		RequestDispatcher dispatcher 
        = this.getServletContext()//
              .getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/listSubject.jsp");
		 dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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