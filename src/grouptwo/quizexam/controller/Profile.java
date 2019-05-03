package grouptwo.quizexam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grouptwo.quizexam.model.Profilestudent;
import grouptwo.quizexam.model.User;
import grouptwo.quizexam.service.ProfilestudentService;
import grouptwo.quizexam.service.UserService;
import grouptwo.quizexam.utils.EncryptionHelper;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession user1=request.getSession();
		User UserName1=(User)user1.getAttribute("loginedUser");
		String UserName=UserName1.getUserName();
		User user= UserService.getUsersByName(UserName);	
		Profilestudent student=ProfilestudentService.getProfilestudentByUser(user.getUserId());
		request.setAttribute("user", user);
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/Views/Shared/profile.jsp");
	 
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String passCu=request.getParameter("passCu");
		String passMoi=request.getParameter("passMoi");
		String passXacNhan=request.getParameter("passXacNhan");
		String id=request.getParameter("idUser");
		//System.out.println(passMoi+id);
		passMoi = EncryptionHelper.MD5(passMoi);
		UserService.ChangePass(passMoi,Integer.parseInt(id));
		String contextPath=request.getContextPath();
		response.sendRedirect(contextPath+"/Profile");
	}

}
