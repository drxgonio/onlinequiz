package grouptwo.quizexam.model;

import java.sql.Date;

import grouptwo.quizexam.service.ExamService;
 
public class ResultTest {

	private int resultId;
	private int score;
	private int examID;
	private Exam examObject;
	private int studentId;
	private Date startTime;
	private Date finishTime;

	public ResultTest() {
		super();
	}

	public ResultTest(int score, int examID, int studentId, Date startTime, Date finishTime) {
		super();
		this.score = score;
		this.examID = examID;
		this.studentId = studentId;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	
	public ResultTest(int resultId, int score, int examID, int studentId, Date startTime, Date finishTime) {
		super();
		this.resultId = resultId;
		this.score = score;
		this.examID = examID;
		this.studentId = studentId;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getExamID() {
		return examID;
		
	}
	public void setExamID(int examID) {
		
		this.examID = examID;
		this.examObject=ExamService.getExamById(examID);
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Exam getExamObject() {
		return examObject;
	}

	public void setExamObject(Exam examObject) {
		this.examObject = examObject;
	}
}
