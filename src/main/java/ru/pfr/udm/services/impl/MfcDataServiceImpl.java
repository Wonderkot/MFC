package ru.pfr.udm.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.pfr.udm.services.MfcDataService;
import ru.udm.pfr.dao.MfcDao;
import ru.udm.pfr.dao.MfcDataDao;
import ru.udm.pfr.models.Mfc;
import ru.udm.pfr.models.MfcData;

@Service
public class MfcDataServiceImpl implements MfcDataService {
	private static Logger log = LogManager.getLogger(MfcDataServiceImpl.class);

	@Autowired
	MfcDataDao mfcDataDao;

	@Autowired
	MfcDao mfcDao;

	@Override
	public List<MfcData> getOldValues(Long id) {
		log.info("Получаем старые значения по идентификатору МФЦ(района) {}",
				id);
		Mfc mfc = mfcDao.findOne(id);
		List<MfcData> mfcDatas = mfcDataDao
				.findAllByMfcAndIsDeleted(mfc, false);
		if (mfcDatas != null && !mfcDatas.isEmpty()) {
			log.info("Получено записей: {}", mfcDatas.size());
		} else {
			log.warn("Записей не найдено");
		}
		return mfcDatas;
	}

	@Override
	public void insertRecord(MfcData mfcData) {
		log.info("Проверяем запись с идентификатором {} на существование",
				mfcData.getId());
		MfcData existedRecord = mfcDataDao.findOne(mfcData.getId());
		if (existedRecord == null) {
			log.info("Запись не была найдена, будет добавлена новая запись");
			mfcDataDao.save(mfcData);
		}
		else {
			log.info("Запись была найдена, будет произведено обновление");
			existedRecord.setField1(mfcData.getField1());
			existedRecord.setField2(mfcData.getField2());
			existedRecord.setField3(mfcData.getField3());
			existedRecord.setField4(mfcData.getField4());
			mfcDataDao.save(existedRecord);
		}
	}

	@Override
	public void setDeleted() {
		log.info("Ищем записи, которые не помечены для удаления");
		List<MfcData> mfcDatas = mfcDataDao.findAllByIsDeleted(false);
		log.warn("{} записей будет помечено как удалённые!",mfcDatas.size());
		for (MfcData mfcData : mfcDatas) {
			mfcData.setIsDeleted(true);
			mfcDataDao.save(mfcData);
		}
	}

}
