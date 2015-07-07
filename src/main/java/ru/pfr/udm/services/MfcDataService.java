/**
 * 
 */
package ru.pfr.udm.services;

import ru.udm.pfr.models.MfcData;

/**
 * @author pd199717
 *
 */
public interface MfcDataService {

	public MfcData getOldValues(Long mfc,Long service);	
	
	public void insertRecord(MfcData mfcData);
	
	public void setDeleted();	
}