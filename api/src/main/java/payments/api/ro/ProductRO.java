package payments.api.ro;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class ProductRO {

	@NotEmpty(message = "Product Name is required")
	@Getter
	@Setter
	private String name;

	@Min(value = 1, message = "Invalid Day of the month")
	@Max(value = 31, message = "Invalid Day of the month")
	private Integer paymentDueBy;

	@Getter
	@Setter
	private LocalDate dueDate;

	@JsonIgnore
	public Integer getPaymentDueBy() {
		return paymentDueBy;
	}

	@JsonProperty
	public void setPaymentDueBy(Integer dueDate) {
		this.paymentDueBy = dueDate;
	}

}
