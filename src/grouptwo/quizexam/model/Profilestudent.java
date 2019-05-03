
package grouptwo.quizexam.model;

import java.sql.Date;

public class Profilestudent {

	private Integer studentId;
	private String name;
	private Integer identityCardNumber;
	private Date dateOfBirth;
	private String gender;
	private String phoneNumber;
	private String country;
	private String address;
	private String religion;
	private Integer yearOfAdmission;
	private Integer yearOfGraduation;
	private String image;




	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdentityCardNumber() {
		return identityCardNumber;
	}

	public void setIdentityCardNumber(Integer identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public Integer getYearOfAdmission() {
		return yearOfAdmission;
	}

	public void setYearOfAdmission(Integer yearOfAdmission) {
		this.yearOfAdmission = yearOfAdmission;
	}

	public Integer getYearOfGraduation() {
		return yearOfGraduation;
	}

	public void setYearOfGraduation(Integer yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isShowProfile() {
		return showProfile;
	}

	public void setShowProfile(boolean showProfile) {
		this.showProfile = showProfile;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	private boolean showProfile;
	private Integer userId;
	
	public Profilestudent() {
		super();
	}

	public Profilestudent(String name, Integer identityCardNumber, Date dateOfBirth, String gender, String phoneNumber,
			String country, String address, String religion, Integer yearOfAdmission, Integer yearOfGraduation,
			String image, boolean showProfile, Integer userId,int id) {
		super();
		this.name = name;
		this.identityCardNumber = identityCardNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.address = address;
		this.religion = religion;
		this.yearOfAdmission = yearOfAdmission;
		this.yearOfGraduation = yearOfGraduation;
		this.image = image;
		this.showProfile = showProfile;
		this.userId = userId;
		this.studentId=id;
	}
	public Profilestudent(String name, Integer identityCardNumber, Date dateOfBirth, String gender, String phoneNumber,
			String country, String address, String religion, Integer yearOfAdmission, Integer yearOfGraduation,
			String image, boolean showProfile, Integer userId) {
		super();
		this.name = name;
		this.identityCardNumber = identityCardNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.address = address;
		this.religion = religion;
		this.yearOfAdmission = yearOfAdmission;
		this.yearOfGraduation = yearOfGraduation;
		this.image = image;
		this.showProfile = showProfile;
		this.userId = userId;
	}


	public Profilestudent(Integer studentId, String name, Integer identityCardNumber, Date dateOfBirth, String gender,
			String phoneNumber, String country, String address, String religion, Integer yearOfAdmission,
			Integer yearOfGraduation, String image, boolean showProfile, Integer userId) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.identityCardNumber = identityCardNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.address = address;
		this.religion = religion;
		this.yearOfAdmission = yearOfAdmission;
		this.yearOfGraduation = yearOfGraduation;
		this.image = image;
		this.showProfile = showProfile;
		this.userId = userId;
	}
	

}

