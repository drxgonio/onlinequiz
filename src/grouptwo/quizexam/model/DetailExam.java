package grouptwo.quizexam.model;

public class DetailExam {

	public DetailExam() {
	}
	public DetailExam(int examId, int questionId) {
		this.examId = examId;
		this.questionId = questionId;
	}
	private int examId;	
	private int questionId;

	
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getExamId() {
		return examId;
	}
	public int getQuestionId() {
		return questionId;
	}
}
