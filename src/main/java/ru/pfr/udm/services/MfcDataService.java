/**
 * 
 */
package ru.pfr.udm.services;

import java.util.List;

import ru.udm.pfr.models.MfcData;

/**
 * @author pd199717
 *
 */
public interface MfcDataService {

	public List<MfcData> getOldValues(Long id);	
	
	public void insertRecord(MfcData mfcData);
	
	public void setDeleted();	
}