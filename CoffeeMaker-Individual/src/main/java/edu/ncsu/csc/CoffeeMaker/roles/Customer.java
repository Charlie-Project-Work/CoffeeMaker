package edu.ncsu.csc.CoffeeMaker.roles;

import javax.persistence.Entity;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Customer extends User {

//	@Id
//	@GeneratedValue
	// @JsonIgnore // ignores id for json serialize
	// private Long id;

	// private String name;
	// private String type;

	@Min(0) // shouldn't be less than 0
	private Integer money;

	public void setMoney(final Integer money) {
		this.money = money;
	}

	public Integer getMoney() {
		return this.money;
	}

	@Override
	public void setName(final String name) {
		super.setName(name);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setType(final String type) {
		super.setType(type);
	}

	@Override
	public String getType() {
		return super.getType();
	}

	@Override
	public void setId(final long id) {
		super.setId(id);
	}

	/**
	 * Get the ID of the user
	 *
	 * @return the ID
	 */
	@Override
	@JsonProperty("id")
	public Long getId() {
		return super.getId();
	}

}
