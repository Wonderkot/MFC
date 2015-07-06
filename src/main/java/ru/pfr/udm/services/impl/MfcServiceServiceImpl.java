/**
 * 
 */
package ru.pfr.udm.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.pfr.udm.services.MfcServiceService;
import ru.udm.pfr.dao.MfcServiceDao;
import ru.udm.pfr.models.MfcService;

/**
 * @author pd199717
 *
 */
@Service
public class MfcServiceServiceImpl implements MfcServiceService {
	@Autowired
	MfcServiceDao mfcServiceDao;
	
	@Override
	public List<MfcService> geServiceList() {
		return (List<MfcService>) mfcServiceDao.findAll();
	}

}
