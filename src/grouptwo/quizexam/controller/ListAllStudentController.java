
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
import grouptwo.quizexam.service.ProfilestudentService;
import grouptwo.quizexam.utils.CalculationHelper;


@WebServlet("/ListAllStudent")
public class ListAllStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListAllStudentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Profilestudent> prfi_Stu= null;
		int page=1;
		if(request.getParameter("page")==null)
		{
			int numberPage;
			numberPage= CalculationHelper.rouding(ProfilestudentService.countProfile(),ParamaterStatic.amoutResult);
			prfi_Stu=ProfilestudentService.getAllStudent(page-1,ParamaterStatic.amoutResult);
			getServletContext().setAttribute("numberPage",numberPage);
		}
		else
		{
			page=Integer.parseInt(request.getParameter("page"));
			prfi_Stu=ProfilestudentService.getAllStudent((page-1)*ParamaterStatic.amoutResult,ParamaterStatic.amoutResult);
		}	
		request.setAttribute("list",prfi_Stu);
		RequestDispatcher dispatcher 
         = this.getServletContext()//
               .getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/listStudent.jsp");
		 dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
