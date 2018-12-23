package payments.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "payment_due_by")
	private Integer paymentDueBy;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<ProductPayment> payments;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPaymentDueBy() {
		return paymentDueBy;
	}

	public void setPaymentDueBy(Integer paymentDueBy) {
		this.paymentDueBy = paymentDueBy;
	}

	public List<ProductPayment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<ProductPayment> payments) {
		this.payments = payments;
	}

}
