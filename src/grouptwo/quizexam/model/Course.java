package grouptwo.quizexam.model;

import java.sql.Date;

import grouptwo.quizexam.service.SubjectService;

public class Course {
	
	private Integer courseId;
	private Integer subjectId;
	private Subject subjectIdObject;
	private Date dateOfStarting;
	private Date dateOfEnding;
	private String dateOfWeek;
	private Integer partOfStarting;
	private Integer partOfEnding;
	private Integer numberOfStudent;
	private String room;
	private boolean activate;
	private Integer teacherId;
	private String name;
	
	
	public Course() {
	}
	public Course(Integer subjectId, Date dateOfStarting, Date dateOfEnding, String dateOfWeek, Integer partOfStarting,
			Integer partOfEnding, Integer numberOfStudent, String room, boolean activate,Integer teacherId,String name,Integer courseId) {
		this.subjectId = subjectId;
		this.dateOfStarting = dateOfStarting;
		this.dateOfEnding = dateOfEnding;
		this.dateOfWeek = dateOfWeek;
		this.partOfStarting = partOfStarting;
		this.partOfEnding = partOfEnding;
		this.numberOfStudent = numberOfStudent;
		this.room = room;
		this.activate = activate;
		this.name = name;
		this.courseId=courseId;
		this.subjectIdObject=SubjectService.getSubjectsById(subjectId);

	}
	public Course(Integer subjectId, Date dateOfStarting, Date dateOfEnding, String dateOfWeek, Integer partOfStarting,
			Integer partOfEnding, Integer numberOfStudent, String room, boolean activate, Integer teacherId,String name) {
		this.subjectId = subjectId;
		this.dateOfStarting = dateOfStarting;
		this.dateOfEnding = dateOfEnding;
		this.dateOfWeek = dateOfWeek;
		this.partOfStarting = partOfStarting;
		this.partOfEnding = partOfEnding;
		this.numberOfStudent = numberOfStudent;
		this.room = room;
		this.activate = activate;
		this.teacherId = teacherId;
		this.name = name;
		this.subjectIdObject=SubjectService.getSubjectsById(subjectId);
		
	}


	
	public Integer getCourseId() {
		return courseId;
	}
	public Integer getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
	public Date getDateOfStarting() {
		return dateOfStarting;
	}
	public void setDateOfStarting(Date dateOfStarting) {
		this.dateOfStarting = dateOfStarting;
	}
	public Date getDateOfEnding() {
		return dateOfEnding;
	}
	public void setDateOfEnding(Date dateOfEnding) {
		this.dateOfEnding = dateOfEnding;
	}
	public String getDateOfWeek() {
		return dateOfWeek;
	}
	public void setDateOfWeek(String dateOfWeek) {
		this.dateOfWeek = dateOfWeek;
	}
	public Integer getPartOfStarting() {
		return partOfStarting;
	}
	public void setPartOfStarting(Integer partOfStarting) {
		this.partOfStarting = partOfStarting;
	}
	public Integer getPartOfEnding() {
		return partOfEnding;
	}
	public void setPartOfEnding(Integer partOfEnding) {
		this.partOfEnding = partOfEnding;
	}
	public Integer getNumberOfStudent() {
		return numberOfStudent;
	}
	public void setNumberOfStudent(Integer numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public boolean isActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	public Integer getTeacher() {
		return teacherId;
	}
	public void setTeacher(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Subject getSubjectIdObject() {
		return subjectIdObject;
	}
	public void setSubjectIdObject(Subject subjectIdObject) {
		this.subjectIdObject = subjectIdObject;
	}
	
	
	

}
