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


@WebServlet("/EditSubject")
public class EditSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command=request.getParameter("command");
		String id=request.getParameter("id");
		RequestDispatcher dispatcher;
		Subject subject=SubjectService.getSubjectsById(Integer.parseInt(id));
		request.setAttribute("subject", subject);
		 switch(command)
			{
			case "delete":
				SubjectService.deleteSubjects(Integer.parseInt(id));
				String contextPath=request.getContextPath();
				response.sendRedirect(contextPath+"/ListSubject");
				break;
			case "update":
				System.out.println("cc");
					  dispatcher = request.getServletContext()
				                .getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/editSubject.jsp");
					 
				        dispatcher.forward(request, response);
				        command="";
				        break;
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String txtName=request.getParameter("txtName");
		String txtFaculty=request.getParameter("txtFaculty");
		String txtCredit=request.getParameter("txtCredit");
		String txtType=request.getParameter("txtType");
		String Activate=request.getParameter("ckbActivate");
		
		SubjectService.updateSubjects(new Subject(txtName,txtFaculty,Integer.parseInt(txtCredit),txtType,Boolean.valueOf(Activate),Integer.parseInt(id)));
		String contextPath=request.getContextPath();
		response.sendRedirect(contextPath+"/ListSubject");
	}

}