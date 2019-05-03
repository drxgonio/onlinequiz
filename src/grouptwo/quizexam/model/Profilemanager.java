
package grouptwo.quizexam.model;

import java.util.Date;

public class Profilemanager {

	private Integer managerId;
	private String name;
	private Date dateOfBirth;
	private String gender;
	private String phoneNumber;
	private String image;
	private boolean showProfile;
	private Integer userId;
	
	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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



	public Profilemanager()
	{
	}
	
	public Profilemanager(String name, Date dateOfBirth, String gender, String phoneNumber, String image,
			boolean showProfile, Integer userId) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.image = image;
		this.showProfile = showProfile;
		this.userId = userId;
	}

	public Profilemanager(Integer managerId, String name, Date dateOfBirth, String gender, String phoneNumber,
			String image, boolean showProfile, Integer userId) {
		super();
		this.managerId = managerId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.image = image;
		this.showProfile = showProfile;
		this.userId = userId;
	}

}

