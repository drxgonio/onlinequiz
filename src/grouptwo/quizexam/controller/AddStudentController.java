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
import grouptwo.quizexam.service.BaseService;
import grouptwo.quizexam.service.ProfilestudentService;
import grouptwo.quizexam.service.UserService;
import grouptwo.quizexam.utils.EncryptionHelper;

@WebServlet("/AddStudent")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddStudentController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/addStudent.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String message ="";
		try
		{
			String username = request.getParameter("username");
			String email	= request.getParameter("email");
			String password = EncryptionHelper.MD5(request.getParameter("password"));
			String confirmpw = request.getParameter("confirm");
			String fullname = request.getParameter("fullname");
			int	cmnd		= Integer.parseInt(request.getParameter("cmnd"));
			String date = request.getParameter("birthday");
			java.sql.Date birthday = java.sql.Date.valueOf(date);
			String gender	= request.getParameter("gender");
			String phone	= request.getParameter("phone");
			String country	= request.getParameter("country");
			String address	= request.getParameter("address");
			String religion	= request.getParameter("region");
			int admission 	= Integer.parseInt(request.getParameter("admission"));
			int graduation 	= Integer.parseInt(request.getParameter("graduation"));
			
			if(confirmpw.equals(password))
			{
				UserService.addUsers(new User(username,email,password,1,true));
				int userId = BaseService.getIdAfterInsert();
				ProfilestudentService.addProfilestudent(new Profilestudent(fullname,cmnd,birthday,gender,phone,country,address,religion,admission,graduation,"",true,userId));

				response.sendRedirect("ListAllStudent");
				return;
			}
			else {
				message += "Mật khẩu không trùng khớp";

			}
		}
		catch(NumberFormatException ne) 
		{
			message+="Mời nhập định dạng số cho CMND, năm học, năm tốt nghiệp";
		}
		catch(NullPointerException e) 
		{
			message+="Vui lòng điền đầy đủ thông tin";
		}
		catch(IllegalArgumentException e)
		{
			message+="Vui lòng điền ngày sinh";

		}
		

			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/Views/QLSinhVien_MonHoc/addStudent.jsp");
			dispatcher.forward(request, response);
		
	}

}
