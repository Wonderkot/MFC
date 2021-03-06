/**
 * 
 */
package ru.udm.pfr.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * @author wonderkot
 * Класс, описывающий услугу
 */
@Entity
public class MfcService {
	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 10000)
	@NotNull
	private String title;
	@Transient
	private MfcData mfcData;

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

	/**
	 * @return возвращает значение mfcData
	 */
	public MfcData getMfcData() {
		return mfcData;
	}

	/**
	 * @param устанавливает значение mfcData в mfcData
	 */
	public void setMfcData(MfcData mfcData) {
		this.mfcData = mfcData;
	}

}
