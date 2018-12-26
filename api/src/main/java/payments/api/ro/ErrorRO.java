package payments.api.ro;

import lombok.Data;

@Data
public class ErrorRO {

	private String message;

	public ErrorRO(String message) {
		this.message = message;
	}

}
