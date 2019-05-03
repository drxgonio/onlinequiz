package grouptwo.quizexam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grouptwo.quizexam.model.Subject;
import grouptwo.quizexam.service.SubjectService;

@WebServlet("/AddSubject")
public class AddSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddSubjectController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/addSubject.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		Boolean isActivate = request.getParameter("ckbActivate")!=null;
		String name = request.getParameter("txtName");
		String faculty = request.getParameter("txtFaculty");
		//System.out.println(request.getParameter("txtCredit"));
		int credit = Integer.parseInt(request.getParameter("txtCredit"));
		String type = request.getParameter("txtType");
		
		SubjectService.addSubjects(new Subject(name,faculty,credit,type,isActivate));
		
		response.sendRedirect("ListSubject");
	}

}
