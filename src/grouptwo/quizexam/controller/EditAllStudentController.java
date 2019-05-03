package grouptwo.quizexam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grouptwo.quizexam.model.Profilestudent;
import grouptwo.quizexam.model.User;
import grouptwo.quizexam.service.ProfilestudentService;
import grouptwo.quizexam.service.UserService;
import grouptwo.quizexam.utils.EncryptionHelper;


@WebServlet("/EditAllStudent")
public class EditAllStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAllStudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String command=request.getParameter("command");
		
		String id=request.getParameter("id");

		Profilestudent profilestudent= ProfilestudentService.getProfilestudentById(Integer.parseInt(id));
		User user=UserService.getUsersById(Integer.parseInt(id));
		request.setAttribute("profilestudent", profilestudent);
		request.setAttribute("user", user);
		
		String contextPath;
		 RequestDispatcher dispatcher;
		 switch(command)
			{
			case "delete":
			
				ProfilestudentService.deleteProfilestudent(Integer.parseInt(id));
				 contextPath=request.getContextPath();
				response.sendRedirect(contextPath+"/ListAllStudent");
				break;
			
			case "update":
		
					  dispatcher = request.getServletContext()
				                .getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/editAllStudent.jsp");
					 
				        dispatcher.forward(request, response);
				        command="";
				        break;
			}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String id=request.getParameter("id");
		String userprofile=request.getParameter("userprofile");
		String passwordUser= EncryptionHelper.MD5(request.getParameter("passwordUser"));
		String email=request.getParameter("email");
		String RoleUser="1";
		//////////////////////////////
		String IdentityCardNumber=request.getParameter("IdentityCardNumber");
		String Name=request.getParameter("Name");
		String PhoneNumber=request.getParameter("PhoneNumber");
		String DateOfBirth=request.getParameter("DateOfBirth");
		String GenDer=request.getParameter("GenDer");
		//String GenDer="Ná»¯";
		String Country=request.getParameter("Country");
		String Adress=request.getParameter("Adress");
		String Religion=request.getParameter("Religion");
		String YearOfAdmission=request.getParameter("YearOfAdmission");
		String YearOfGraduation=request.getParameter("YearOfGraduation");
		String Image=null;
		boolean ShowProfile=true;
		String User="1";
		System.out.println("dadsa:"+GenDer);
		
		UserService.updateUsers(new User(userprofile,email,passwordUser,Integer.parseInt(RoleUser),true,Integer.parseInt(id)));
		ProfilestudentService.UpdateProfilestudent(new Profilestudent(Name,Integer.parseInt(IdentityCardNumber),java.sql.Date.valueOf(DateOfBirth),GenDer,PhoneNumber,Country,Adress,Religion,Integer.parseInt(YearOfAdmission),Integer.parseInt(YearOfGraduation),Image,ShowProfile,Integer.parseInt(User),Integer.parseInt(id)));
		//Load lai Servlet ListAllStudent
		String contextPath=request.getContextPath();
		response.sendRedirect(contextPath+"/ListAllStudent");
	}

}