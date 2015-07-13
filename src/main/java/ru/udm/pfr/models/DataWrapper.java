/**
 * 
 */
package ru.udm.pfr.models;

import java.util.List;

/**
 * @author pd199717
 *
 */
public class DataWrapper {
	private Mfc mfc;
	private List<MfcService> services;
	private User user;	
	/**
	 * @return возвращает значение mfc
	 */
	public Mfc getMfc() {
		return mfc;
	}
	/**
	 * @param устанавливает значение mfc в mfc
	 */
	public void setMfc(Mfc mfc) {
		this.mfc = mfc;
	}
	/**
	 * @return возвращает значение services
	 */
	public List<MfcService> getServices() {
		return services;
	}
	/**
	 * @param устанавливает значение services в services
	 */
	public void setServices(List<MfcService> services) {
		this.services = services;
	}
	/**
	 * @return возвращает значение user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param устанавливает значение user в user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
