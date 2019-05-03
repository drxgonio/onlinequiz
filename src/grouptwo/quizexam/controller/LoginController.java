package grouptwo.quizexam.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grouptwo.quizexam.model.User;
import grouptwo.quizexam.service.UserService;
import grouptwo.quizexam.utils.AppUtils;
import grouptwo.quizexam.utils.EncryptionHelper;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher //
         = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/SinhVien/loginView.jsp");
		 	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	
			String userName=request.getParameter("userName");
			String pw=request.getParameter("passWord");
			String password = EncryptionHelper.MD5(pw);
			User userAccount=UserService.findAcc(userName,password);
			if(userAccount==null)
			{
				String error="Ä�Äƒng nháº­p khÃ´ng thÃ nh cÃ´ng";
				request.setAttribute("error", error);
				RequestDispatcher dispatcher //
	            = this.getServletContext().getRequestDispatcher("/WEB-INF/Views/SinhVien/loginView.jsp");
				dispatcher.forward(request, response);
		            return;
			}
			AppUtils.storeLoginedUser(request.getSession(), userAccount);
			
			  int redirectId = -1;
		        try {
		            redirectId = Integer.parseInt(request.getParameter("redirectId"));
		        } catch (Exception e) {
		        }
		        String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
		        if (requestUri != null) {
		        	RequestDispatcher dispatcher //
		            = this.getServletContext()//
		                  .getRequestDispatcher(requestUri);
		        	 dispatcher.forward(request, response);
		        } else {
		            // Máº·c Ä‘á»‹nh sau khi Ä‘Äƒng nháº­p thÃ nh cÃ´ng
		            // chuyá»ƒn hÆ°á»›ng vá»� trang /userInfo
		        	
		            response.sendRedirect(request.getContextPath() +"/HomeQuizController");
		        }
	}

}
