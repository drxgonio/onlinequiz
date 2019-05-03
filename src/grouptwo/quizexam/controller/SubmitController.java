package grouptwo.quizexam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import grouptwo.quizexam.model.Answer;
import grouptwo.quizexam.model.DetailResult;
import grouptwo.quizexam.model.Question;
import grouptwo.quizexam.model.User;
import grouptwo.quizexam.service.BaseService;
import grouptwo.quizexam.service.DetailResultService;
import grouptwo.quizexam.service.ResultTestService;
import grouptwo.quizexam.utils.TimeUltils;

/**
 * Servlet implementation class SubmitController
 */
@WebServlet("/Submit")
public class SubmitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("loginedUser");
		int idStu=user.getUserId();
		/*kiem tra xem submit co dung giá»� hay khong*/
		String timeFinishingExam=(String) session.getAttribute("timeFinishing");
		String timeStrarting=(String) session.getAttribute("timeStarting");
		String currentTimeSubmit=TimeUltils.getCurrentTime();
		int idExam=(int) session.getAttribute("idExamCurent");
		if(TimeUltils.invalidSubmit(timeFinishingExam, currentTimeSubmit))
		{

			List<Question> lsQus=new ArrayList<>();
			List<DetailResult> lsDeRS=new ArrayList<>();
			lsQus=(List<Question>) session.getAttribute("lsQusAllParent");
			double course=10.0/lsQus.size();
			double grade=0;
			for(Question qus:lsQus)
			{
				for(Answer ans:qus.getLsAnswer())
				{
					if(ans.getisTick())
					{
						DetailResult deRs=new DetailResult();
						if(ans.getId()==qus.getCorrectAnswerID())
						{
							grade+=course;
						}
						deRs.setAnswerId(ans.getId());
						lsDeRS.add(deRs);
					}
				}
			}
			
			if(ResultTestService.addResultTest(grade, idExam, idStu, timeStrarting, currentTimeSubmit))
			{
				int idResult=BaseService.getIdAfterInsert();
				for(DetailResult ders:lsDeRS)
				{
					ders.setResultId(idResult);
					DetailResultService.addDetailResult(ders);
				}
			}
			request.setAttribute("grade", grade);
			System.out.println("tong diem cua ban la:"+grade);
			session.removeAttribute("exam");
			session.removeAttribute("isStart");
			session.removeAttribute("TimeMinuteLimit");
			session.removeAttribute("timeStarting");
			session.removeAttribute("timeFinishing");
			session.removeAttribute("lsQusAllParent");
			session.removeAttribute("numberPage");
			session.removeAttribute("isComplete");
			RequestDispatcher dispatcher 
	         = this.getServletContext()//
	               .getRequestDispatcher("/WEB-INF/Views/SinhVien/TrangXacNhanPdf.jsp");
			 dispatcher.forward(request, response);
		}
		
		
		
		
		
	}

}
