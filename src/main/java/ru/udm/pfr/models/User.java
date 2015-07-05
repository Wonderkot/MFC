/**
 * 
 */
package ru.udm.pfr.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author wonderkot
 *
 */
@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	@NotNull
	private String name;
	@Column
	@NotNull
	private Integer role;

	@OneToOne
	@JoinColumn(name = "district")
	private Mfc mfc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Mfc getMfc() {
		return mfc;
	}

	public void setMfc(Mfc mfc) {
		this.mfc = mfc;
	}

}
