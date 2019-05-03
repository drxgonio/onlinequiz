package grouptwo.quizexam.model;

import java.util.List;

import grouptwo.quizexam.service.AnswerService;

public class Question {

	private int questionId;
	private String question;
	private String image;
	private String level;
	private int subjectID;
	private List<Answer> lsAnswer;
	private Answer answerCorrect;
	private int creatorID;
	private int correctAnswerID;
	private boolean isTick;

	
	public Question() {
		super();
	}

	public Question(int questionId, String question, String image, String level,int subjectID,int creatorID,
			int correctAnswerID) {
		this.questionId = questionId;
		this.question = question;
		this.image = image;
		this.level = level;
		
		this.subjectID = subjectID;
		this.creatorID = creatorID;
		this.correctAnswerID = correctAnswerID;
		
		this.lsAnswer= AnswerService.getAnswersByIdForQuestion(questionId);
		this.answerCorrect= AnswerService.getAnswersById(correctAnswerID);
	}
	public Question( String question, String image, String level,int creatorID,
			int correctAnswerID, int subjectID) {
		this.question = question;
		this.image = image;
		this.level = level;
		this.subjectID = subjectID;
		this.creatorID = creatorID;
		this.correctAnswerID = correctAnswerID;
	}

	public Question( String question, String image, String level, int subjectID,
			int correctAnswerID,int creatorID,int questionId) {
		this.question = question;
		this.image = image;
		this.level = level;
		this.subjectID = subjectID;
		this.creatorID = creatorID;
		this.correctAnswerID = correctAnswerID;

		this.questionId=questionId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public int getCreatorID() {
		return creatorID;
	}
	public void setCreatorID(int creatorID) {
		this.creatorID = creatorID;
	}
	public int getCorrectAnswerID() {
		return correctAnswerID;
	}
	public void setCorrectAnswerID(int correctAnswerID) {
		this.correctAnswerID = correctAnswerID;
	}

	public List<Answer> getLsAnswer() {
		return lsAnswer;
	}

	public void setLsAnswer(List<Answer> lsAnswer) {
		this.lsAnswer = lsAnswer;
	}

	public Answer getAnswerCorrect() {
		return answerCorrect;
	}

	public void setAnswerCorrect(Answer answerCorrect) {
		this.answerCorrect = answerCorrect;
	}
	public boolean getIsTick() {
		return isTick;
	}
	public void setIsTick(boolean b) {
		this.isTick = b;
	}

		
}
