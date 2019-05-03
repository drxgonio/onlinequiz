package grouptwo.quizexam.model;

import grouptwo.quizexam.service.CourseService;
import grouptwo.quizexam.service.ProfilestudentService;

public class DetailCourse {

	public DetailCourse() {
	}
	public DetailCourse(int courseId, int studentId) {
		this.courseId = courseId;
		this.studentId = studentId;
		profileStudent=ProfilestudentService.getProfilestudentById(studentId);
		courseObject=CourseService.getCourseById(courseId);
	}
	private int courseId;
	private int studentId;
	private Course courseObject;
	private Profilestudent profileStudent;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Course getCourseObject() {
		return courseObject;
	}
	public void setCourseObject(Course courseObject) {
		this.courseObject = courseObject;
	}
	public Profilestudent getProfileStudent() {
		return profileStudent;
	}
	public void setProfileStudent(Profilestudent profileStudent) {
		this.profileStudent = profileStudent;
	}
}
