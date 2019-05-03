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
import grouptwo.quizexam.service.CourseService;
import grouptwo.quizexam.service.DetailExamService;
import grouptwo.quizexam.service.ExamService;
import grouptwo.quizexam.service.QuestionService;
import grouptwo.quizexam.service.SubjectService;
import grouptwo.quizexam.utils.CalculationHelper;

@WebServlet("/EditExam")
public class EditExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Question> lstOldQuestion;
	List<Question> lstNewQuestion;

	int amountPerPage;
	Subject subject;
	List<Integer> lstNumType;
	Exam exam;
	
    public EditExamController() {
        super();
        amountPerPage = 10;
        
    }
    public void init() throws ServletException {
    	super.init();
    	lstOldQuestion = new ArrayList<>();
    	lstNewQuestion = new ArrayList<>();
        lstNumType = new ArrayList<>();
        exam = new Exam();
        for(int i= 0;i<3;i++)
        {
        	lstNumType.add(0);
        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		if(request.getParameter("examId")!=null)
		{

			int examId = Integer.parseInt(request.getParameter("examId"));
			exam = ExamService.getExamById(examId);
			lstNewQuestion = QuestionService.getQuestionForExam(examId);
			lstOldQuestion = QuestionService.getQuestionForExam(examId);
			subject = SubjectService.getSubjectsById(exam.getSubjectId());
			lstNumType.set(2, exam.getNumDifficult());
			lstNumType.set(1, exam.getNumNormal());
			lstNumType.set(0, exam.getNumEasy());
		}
		
		
		List<Question> lstCurrentQuestions = new ArrayList<>();
		int page=1;
		
		String action = request.getParameter("action");
		if(action!=null)
		{
			if(action.equals("DELETE"))
			{
				String test = request.getParameter("deleteId");
				int idDeleteItem = Integer.parseInt(test);
				for(Question q: lstNewQuestion)
				{
					if (q.getQuestionId()==idDeleteItem)
					{
						if(q.getLevel().equals("Dễ"))
						{
							lstNumType.set(0, lstNumType.get(0)-1);
						}
						if(q.getLevel().equals("Trung bìnhh"))
						{
							lstNumType.set(1, lstNumType.get(1)-1);
						}
						if(q.getLevel().equals("Khó"))
						{
							lstNumType.set(2, lstNumType.get(2)-1);
						}
						lstNewQuestion.remove(q);

						break;
					}
				}
			}
			if(action.equals("DELETEALL"))
			{
				lstNewQuestion.clear();
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
				for(Question q : lstNewQuestion)
				{
					if( q.getQuestionId() == newQuestion.getQuestionId())
					{
						isContain = true;
						break;
					}
				}
				if(!isContain){
					for(Question q:lstNewQuestion) {
						if(q.getQuestionId() == replaceId) {
							int index = lstNewQuestion.indexOf(q);
							lstNewQuestion.set(index, newQuestion);
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
				for(Question q : lstNewQuestion)
				{
					if( q.getQuestionId() == newQuestion.getQuestionId())
					{
						isContain = true;
						break;
					}
				}
				if(!isContain){
					lstNewQuestion.add(0, newQuestion);
					switch(newQuestion.getLevel())
					{
						case "Dễ": lstNumType.set(0, lstNumType.get(0)+1);break;
						case "Trung bình": lstNumType.set(1, lstNumType.get(1)+1);break;
						case "Khó": lstNumType.set(2, lstNumType.get(2)+1);break;
					}
				}
			}
		}
		
		if(lstNewQuestion.size()>0)
		{
			
			page = request.getParameter("page") == null? 1 :Integer.parseInt(request.getParameter("page")) ;
		}
		
		
		if(lstNewQuestion.size()>0)
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
					
					int numberPage = CalculationHelper.rouding(lstNewQuestion.size(),amountPerPage);
					getServletContext().setAttribute("numberPage",numberPage);
			}
		}

		//phÃ¢n trang
		int startPage = amountPerPage*(page-1);
		int finishPage = amountPerPage*page-1> lstNewQuestion.size()-1? lstNewQuestion.size() :amountPerPage*page-1;
		lstCurrentQuestions = lstNewQuestion.subList(startPage, finishPage);
		
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

		try {
			request.setAttribute("nameExam", exam.getName());
			request.setAttribute("timeOpen", exam.getTimeStarting());
			request.setAttribute("closeTime", exam.getTimeFinishing());
			request.setAttribute("limitTime", exam.getLimitTime());			

		}
		catch(Exception e)
		{
			
		}
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/Views/QLDeThi/editExam.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		try {
			java.util.Date openTime  = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("timeOpen"));
			Timestamp tO = new Timestamp(openTime.getTime());
			exam.setTimeStarting(tO);
			java.util.Date closeTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("closeTime"));
			Timestamp tC = new Timestamp(closeTime.getTime());
			exam.setTimeFinishing(tC);

			
			String nameExam = request.getParameter("nameExam");
			exam.setName(nameExam);

			int limitTime = Integer.parseInt(request.getParameter("limitTime"));
			exam.setLimitTime(limitTime);

			int totalQuestion = lstNumType.get(0) + lstNumType.get(1) + lstNumType.get(2);
			exam.setNumQuestions(totalQuestion);

			exam.setSubjectId(subject.getSubjectID());
			exam.setNumDifficult(lstNumType.get(2));
			exam.setNumNormal(lstNumType.get(1));
			exam.setNumEasy(lstNumType.get(0));

			ExamService.UpdateExam(exam);
			
			int examId = exam.getId();
			for(Question q: lstOldQuestion) {
				int id = q.getQuestionId();
				DetailExamService.deleteDetailExams(examId,id);
			}
			for(Question q: lstNewQuestion) {
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

		if(lstNewQuestion.size()==0)
		{
			subject = SubjectService.getSubjectsById(subjectId);
			json= new Gson().toJson(subject);
		}
		resp.getWriter().print(json);
	}
	
	protected void createRandExam(int numEasy, int numNormal, int numDifficult) {
		lstNewQuestion = new ArrayList<>();

		// taking random question
		List<Question> lstQuestionType = new ArrayList<>();
		try {
			lstQuestionType = QuestionService.getRandQuestionByLevelSubject("Dễ", numEasy, subject.getSubjectID());
		}
		catch(NullPointerException e )
		{}
		lstNumType.set(0, lstQuestionType==null?0:lstQuestionType.size());
		lstNewQuestion.addAll(lstQuestionType);
		
		try {
			lstQuestionType = QuestionService.getRandQuestionByLevelSubject("Trung bình", numNormal, subject.getSubjectID());
		}
		catch(NullPointerException e )
		{}
		lstNumType.set(1, lstQuestionType==null?0:lstQuestionType.size());
		lstNewQuestion.addAll(lstQuestionType);
		
		try {
			lstQuestionType = QuestionService.getRandQuestionByLevelSubject("Khó", numDifficult, subject.getSubjectID());
		}
		catch(NullPointerException e )
		{}
		lstNumType.set(2, lstQuestionType==null?0:lstQuestionType.size());
		lstNewQuestion.addAll(lstQuestionType);
	}
}
