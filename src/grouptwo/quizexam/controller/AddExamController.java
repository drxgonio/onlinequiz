package grouptwo.quizexam.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import grouptwo.quizexam.model.Course;
import grouptwo.quizexam.model.Exam;
import grouptwo.quizexam.model.Question;
import grouptwo.quizexam.model.Subject;
import grouptwo.quizexam.service.BaseService;
import grouptwo.quizexam.service.CourseService;
import grouptwo.quizexam.service.DetailExamService;
import grouptwo.quizexam.service.ExamService;
import grouptwo.quizexam.service.QuestionService;
import grouptwo.quizexam.service.SubjectService;
import grouptwo.quizexam.utils.CalculationHelper;

@WebServlet("/AddExam")
public class AddExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Question> lstQuestion;
	int amountPerPage;
	Subject subject;
	List<Integer> lstNumType;
    public AddExamController() {
        super();
        amountPerPage = 10;
    }
    @Override
    public void init() throws ServletException {
    	super.init();
        lstQuestion = new ArrayList<>();
        lstNumType = new ArrayList<>();
        
        for(int i= 0;i<3;i++)
        {
        	lstNumType.add(0);
        }
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		List<Question> lstCurrentQuestions = new ArrayList<>();
		int page=1;
		
		String action = request.getParameter("action");
		if(action!=null)
		{
			if(action.equals("DELETE"))
			{
				String test = request.getParameter("deleteId");
				int idDeleteItem = Integer.parseInt(test);
				for(Question q: lstQuestion)
				{
					if (q.getQuestionId()==idDeleteItem)
					{
						if(q.getLevel().equals("Dễ"))
						{
							lstNumType.set(0, lstNumType.get(0)-1);
						}
						if(q.getLevel().equals("Trung bình"))
						{
							lstNumType.set(1, lstNumType.get(1)-1);
						}
						if(q.getLevel().equals("Khó"))
						{
							lstNumType.set(2, lstNumType.get(2)-1);
						}
						lstQuestion.remove(q);

						break;
					}
				}
			}
			if(action.equals("DELETEALL"))
			{
				lstQuestion.clear();
				subject = new Subject();
				lstNumType = new ArrayList<>();
				 for(int i= 0;i<3;i++)
			        {
			        	lstNumType.add(0);
			        }
			}
			if (action.equals("UPDATE"))
			{
				int replaceId = Integer.parseInt(request.getParameter("replaceId"));
				int newId	= Integer.parseInt(request.getParameter("newId"));
				Question newQuestion = QuestionService.getQuestionsById(newId);
				boolean isContain = false;
				for(Question q : lstQuestion)
				{
					if( q.getQuestionId() == newQuestion.getQuestionId())
					{
						isContain = true;
						break;
					}
				}
				if(!isContain){
					for(Question q:lstQuestion) {
						if(q.getQuestionId() == replaceId) {
							int index = lstQuestion.indexOf(q);
							lstQuestion.set(index, newQuestion);
							break;
						}
					}
				}
				Question oldQuestion = QuestionService.getQuestionsById(replaceId);
				switch(oldQuestion.getLevel())
				{
					case "Dễ": lstNumType.set(0, lstNumType.get(0)-1);break;
					case "Trung bình": lstNumType.set(1, lstNumType.get(1)-1);break;
					case "Khó": lstNumType.set(2, lstNumType.get(2)-1);break;
				}
				switch(newQuestion.getLevel())
				{
					case "Dễ": lstNumType.set(0, lstNumType.get(0)+1);break;
					case "Trung bình": lstNumType.set(1, lstNumType.get(1)+1);break;
					case "Khó": lstNumType.set(2, lstNumType.get(2)+1);break;
				}
			}
			if (action.equals("ADD"))
			{
				int newId	= Integer.parseInt(request.getParameter("newId"));
				Question newQuestion = QuestionService.getQuestionsById(newId);

				boolean isContain = false;
				for(Question q : lstQuestion)
				{
					if( q.getQuestionId() == newQuestion.getQuestionId())
					{
						isContain = true;
						break;
					}
				}
				if(!isContain){
					lstQuestion.add(0, newQuestion);
					switch(newQuestion.getLevel())
					{
						case "Dễ": lstNumType.set(0, lstNumType.get(0)+1);break;
						case "Trung bình": lstNumType.set(1, lstNumType.get(1)+1);break;
						case "Khó": lstNumType.set(2, lstNumType.get(2)+1);break;
					}
				}
			}
		}
		
		if(lstQuestion.size()>0)
		{
			
			page = request.getParameter("page") == null? 1 :Integer.parseInt(request.getParameter("page")) ;
		}
		
		
		if(lstQuestion.size()>0)
		{
			
			page = request.getParameter("page") == null? 1 :Integer.parseInt(request.getParameter("page")) ;
		}
		else
		{
			if(request.getParameter("difficult")!=null
					&& request.getParameter("normal")!=null
					&& request.getParameter("easy")!=null)
			{
					int numEasy = Integer.parseInt(request.getParameter("easy"));
					int numNormal= Integer.parseInt(request.getParameter("normal"));
					int numDifficult = Integer.parseInt(request.getParameter("difficult"));

					createRandExam(numEasy, numNormal, numDifficult);
					
					int numberPage = CalculationHelper.rouding(lstQuestion.size(),amountPerPage);
					getServletContext().setAttribute("numberPage",numberPage);
			}
		}

		//phân trang
		int startPage = amountPerPage*(page-1);
		int finishPage = amountPerPage*page-1> lstQuestion.size()-1? lstQuestion.size() :amountPerPage*page-1;
		lstCurrentQuestions = lstQuestion.subList(startPage, finishPage);
		
		if(subject == null)
		{
			List<Subject> lstSubject = SubjectService.getAllSubjects();
			getServletContext().setAttribute("lstSubject", lstSubject);
			
		}
		if(subject!=null)
		{
			List<Question> lstQuestionChoose = QuestionService.getQuestionBySubjectId(subject.getSubjectID());
			getServletContext().setAttribute("lstQuestionChoose", lstQuestionChoose);
		}
	
		
		
		getServletContext().setAttribute("lstCurrentQuestion", lstCurrentQuestions);
		getServletContext().setAttribute("subject", subject);
		getServletContext().setAttribute("listType", lstNumType);
		
		List<Course> lstCourse = CourseService.getAllCourse();
		request.setAttribute("lstCourse", lstCourse);


		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/Views/QLDeThi/addExam.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		try {
			java.util.Date openTime  = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("timeOpen"));
			java.util.Date closeTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("closeTime"));
			Timestamp tO = new Timestamp(openTime.getTime());
			Timestamp tC = new Timestamp(closeTime.getTime());

			
			String nameExam = request.getParameter("nameExam");
			int limitTime = Integer.parseInt(request.getParameter("limitTime"));
			int totalQuestion = lstNumType.get(0) + lstNumType.get(1) + lstNumType.get(2);
			
			ExamService.addExam(new Exam(nameExam, tO, totalQuestion,tC,subject.getSubjectID(),true,null,lstNumType.get(0),lstNumType.get(1),lstNumType.get(2),limitTime));
			
			int examId = BaseService.getIdAfterInsert();
			for(Question q: lstQuestion) {
				int id = q.getQuestionId();
				DetailExamService.addDetailExam(id,examId);
			}
			response.sendRedirect("ListExam");

		} catch (ParseException e) {
			doGet(request, response);
		}
		
		
		
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String test = req.getParameter("subjectId");
		int subjectId = Integer.parseInt(test);
		String json ="";

		if(lstQuestion.size()==0)
		{
			subject = SubjectService.getSubjectsById(subjectId);
			json= new Gson().toJson(subject);
		}
		resp.getWriter().print(json);
	}
	
	protected void createRandExam(int numEasy, int numNormal, int numDifficult) {
		lstQuestion = new ArrayList<>();

		// taking random question
		List<Question> lstQuestionType = new ArrayList<>();
		try {
			lstQuestionType = QuestionService.getRandQuestionByLevelSubject("Dễ", numEasy, subject.getSubjectID());
		}
		catch(NullPointerException e )
		{}
		lstNumType.set(0, lstQuestionType==null?0:lstQuestionType.size());
		lstQuestion.addAll(lstQuestionType);
		
		try {
			lstQuestionType = QuestionService.getRandQuestionByLevelSubject("Trung bình", numNormal, subject.getSubjectID());
		}
		catch(NullPointerException e )
		{}
		lstNumType.set(1, lstQuestionType==null?0:lstQuestionType.size());
		lstQuestion.addAll(lstQuestionType);
		
		try {
			lstQuestionType = QuestionService.getRandQuestionByLevelSubject("Khó", numDifficult, subject.getSubjectID());
		}
		catch(NullPointerException e )
		{}
		lstNumType.set(2, lstQuestionType==null?0:lstQuestionType.size());
		lstQuestion.addAll(lstQuestionType);
	}
}
