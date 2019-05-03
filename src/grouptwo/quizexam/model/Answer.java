package grouptwo.quizexam.model;

import java.io.Serializable;

public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Integer questionId;
	private String answer;

	private boolean isTick;
	public Answer() {
	}

	public Answer(int id, Integer questionId, String answer) {
		this.id = id;
		this.questionId = questionId;
		this.answer = answer;
	}
	public Answer(Integer questionId, String answer) {
		this.questionId = questionId;
		this.answer = answer;

	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean getisTick() {
		return isTick;
	}

	public void setTick(boolean isTick) {
		this.isTick = isTick;
	}

	
}
