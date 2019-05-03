package grouptwo.quizexam.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.DateUtil;

import grouptwo.quizexam.model.Exam;
import grouptwo.quizexam.model.User;
import grouptwo.quizexam.service.ExamService;
import grouptwo.quizexam.service.ProfilestudentService;
import grouptwo.quizexam.service.SubjectService;
import grouptwo.quizexam.utils.TimeUltils;

/**
 * Servlet implementation class HomeQuizController
 */
@WebServlet("/HomeQuizController")
public class HomeQuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeQuizController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		HttpSession sessionn=request.getSession();
		User user=(User) sessionn.getAttribute("loginedUser");
		int idUser=user.getUserId();
		idUser = ProfilestudentService.getIdStudentByUser(idUser);
		
		List<Integer> lsIdExamOfUser=ExamService.getLsIdOfUser(idUser);
		List<Exam> lsExamOfUser=new ArrayList<>();
		
		// Lay tat ca ngay kiem tra trong thang
		List<Integer> lsDateExamInMonth=new ArrayList<>();
		List<String> lsTenKhoaHoc=new ArrayList<>(); 
		List<Integer> lsIdExamInMonth=new ArrayList<>();
				
		int month =LocalDateTime.now().getMonthValue();
		
		//Get Ds exam của user khi đã có list id exam của user đó
		for(int c:lsIdExamOfUser)
		{
			Exam exam = new Exam();
			exam = ExamService.getExamById(c);
			if (TimeUltils.isInHappyHour(exam.getTimeStarting().toString(), exam.getTimeFinishing().toString())) {
			lsExamOfUser.add(exam);
			}
			
			// kiem tra xem bai kiem tra co nam trong thang nay khong
			if((exam.getTimeStarting().getMonth()+1)==month)
			{
				lsDateExamInMonth.add(exam.getTimeStarting().getDate());
				lsTenKhoaHoc.add(exam.getSubjectObject().getSubjectName()+"--"+exam.getName());
				lsIdExamInMonth.add(exam.getId());
				
			}
			
		}
		request.setAttribute("lsExam", lsExamOfUser);
		request.setAttribute("lsDateExamInMonth", lsDateExamInMonth);
		request.setAttribute("lsTenKhoaHoc",lsTenKhoaHoc);
		request.setAttribute("lsIdExamInMonth",lsIdExamInMonth);
		
		RequestDispatcher dispatcher 
        = this.getServletContext()//
              .getRequestDispatcher("/WEB-INF/Views/SinhVien/trangchu.jsp");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
