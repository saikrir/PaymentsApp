package payments.api.ro;

import lombok.Data;

@Data
public class IdRO {
	private Integer id;

	public IdRO(Integer id) {
		this.id = id;
	}
}
