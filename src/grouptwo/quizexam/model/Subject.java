package grouptwo.quizexam.model;

public class Subject {

	private int subjectID;
	private String subjectName;
	private String faculty;
	private int credit;
	private String type;
	private boolean activate;

	
	public Subject() {
	}
	public Subject( String subjectName, String faculty, int credit, String type, boolean activate) {
		super();
		this.subjectName = subjectName;
		this.faculty = faculty;
		this.credit = credit;
		this.type = type;
		this.activate = activate;
	}

	public Subject(int subjectID, String subjectName, String faculty, int credit, String type, boolean activate) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.faculty = faculty;
		this.credit = credit;
		this.type = type;
		this.activate = activate;
	}
	public Subject( String subjectName, String faculty, int credit, String type, boolean activate,int subjectID) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
		this.faculty = faculty;
		this.credit = credit;
		this.type = type;
		this.activate = activate;
	}


	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

}
