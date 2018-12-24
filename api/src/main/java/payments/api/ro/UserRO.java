package payments.api.ro;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserRO {
	private String id;

	@NotNull(message = "Name is required")
	private String name;

	@NotNull(message = "EmailId is required")
	private String emailId;

}
