package grouptwo.quizexam.model;

public class DetailResult {
	public DetailResult() {		
	}
	public DetailResult(int resultId, int answerId) {
		super();
		this.resultId = resultId;
		this.answerId = answerId;
	}
	private int answerId;
	private int resultId;
	
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	
}
