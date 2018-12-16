package payments.api.ro;

import javax.validation.constraints.NotNull;

public class UserRO {
	private String id;

	@NotNull(message = "Name is required")
	private String name;

	@NotNull(message = "EmailId is required")
	private String emailId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
