package grouptwo.quizexam.model;

public class Roleuser {

	private Integer id;
	private String roleName;

	public Roleuser() {
	}

	public Roleuser(String roleName) {
		this.roleName = roleName;
	}
	public Roleuser(Integer id,String roleName) {
		this.id=id;
		this.roleName = roleName;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



}
