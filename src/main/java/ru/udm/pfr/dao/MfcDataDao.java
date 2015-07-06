/**
 * 
 */
package ru.udm.pfr.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.udm.pfr.models.Mfc;
import ru.udm.pfr.models.MfcData;

/**
 * @author pd199717
 *
 */
public interface MfcDataDao extends CrudRepository<MfcData, Long> {
	public List<MfcData> findAllByMfcAndIsDeleted(Mfc mfc,Boolean isDeleted);
	public List<MfcData> findAllByIsDeleted(Boolean isDeleted);
}
