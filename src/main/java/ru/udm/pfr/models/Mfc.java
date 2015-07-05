/**
 * 
 */
package ru.udm.pfr.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author wonderkot
 *
 */
@Entity
public class Mfc {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	@NotNull
	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
