/**
 * 
 */
package ru.pfr.udm.services;

import java.util.List;

import ru.udm.pfr.models.MfcService;

/**
 * @author pd199717
 *
 */
public interface MfcServiceService {
	public List<MfcService> getServiceList();
	public MfcService getByid(Long id);
}
