/**
 * 
 */
package ru.udm.pfr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author pd199717
 *
 */
@Entity
public class MfcData {
	@Id
	@GeneratedValue
	public Long id;

	@OneToOne
	@JoinColumn(name = "service")
	public MfcService mfcService;
	@OneToOne
	@JoinColumn(name = "district")
	public Mfc mfc;
	public String field1;
	public String field2;
	public String field3;
	public String field4;
	public String date;
	@OneToOne
	@JoinColumn(name = "user")
	public User user;
	public Boolean isOpfr;
	public Boolean isDeleted;

	/**
	 * @return возвращает значение id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param устанавливает
	 *            значение id в id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return возвращает значение mfcService
	 */
	public MfcService getMfcService() {
		return mfcService;
	}

	/**
	 * @param устанавливает
	 *            значение mfcService в mfcService
	 */
	public void setMfcService(MfcService mfcService) {
		this.mfcService = mfcService;
	}

	/**
	 * @return возвращает значение mfc
	 */
	public Mfc getMfc() {
		return mfc;
	}

	/**
	 * @param устанавливает
	 *            значение mfc в mfc
	 */
	public void setMfc(Mfc mfc) {
		this.mfc = mfc;
	}

	/**
	 * @return возвращает значение field1
	 */
	public String getField1() {
		return field1;
	}

	/**
	 * @param устанавливает
	 *            значение field1 в field1
	 */
	public void setField1(String field1) {
		this.field1 = field1;
	}

	/**
	 * @return возвращает значение field2
	 */
	public String getField2() {
		return field2;
	}

	/**
	 * @param устанавливает
	 *            значение field2 в field2
	 */
	public void setField2(String field2) {
		this.field2 = field2;
	}

	/**
	 * @return возвращает значение field3
	 */
	public String getField3() {
		return field3;
	}

	/**
	 * @param устанавливает
	 *            значение field3 в field3
	 */
	public void setField3(String field3) {
		this.field3 = field3;
	}

	/**
	 * @return возвращает значение field4
	 */
	public String getField4() {
		return field4;
	}

	/**
	 * @param устанавливает
	 *            значение field4 в field4
	 */
	public void setField4(String field4) {
		this.field4 = field4;
	}

	/**
	 * @return возвращает значение date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param устанавливает
	 *            значение date в date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return возвращает значение user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param устанавливает
	 *            значение user в user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return возвращает значение isOpfr
	 */
	public Boolean getIsOpfr() {
		return isOpfr;
	}

	/**
	 * @param устанавливает
	 *            значение isOpfr в isOpfr
	 */
	public void setIsOpfr(Boolean isOpfr) {
		this.isOpfr = isOpfr;
	}

	/**
	 * @return возвращает значение isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param устанавливает
	 *            значение isDeleted в isDeleted
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
