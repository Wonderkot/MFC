/**
 * 
 */
package ru.udm.pfr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.udm.pfr.models.Mfc;
import ru.udm.pfr.models.MfcData;
import ru.udm.pfr.models.MfcService;

/**
 * @author pd199717
 *
 */
public interface MfcDataDao extends CrudRepository<MfcData, Long> {
	public MfcData findFirstByMfcAndMfcServiceAndIsDeleted(Mfc mfc,MfcService service,Boolean isDeleted);
	public List<MfcData> findAllByIsDeleted(Boolean isDeleted);
}
