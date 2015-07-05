/**
 * 
 */
package ru.udm.pfr.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wonderkot
 *
 */
@Entity
@Table(name="Users")
public class User {
	@Id
    @GeneratedValue
    private Long id;
	@Column
	private String name;
	@Column
	private Integer role;
	
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

}
