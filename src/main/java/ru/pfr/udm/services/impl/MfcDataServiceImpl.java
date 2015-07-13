package ru.pfr.udm.services.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.pfr.udm.services.MfcDataService;
import ru.udm.pfr.dao.MfcDao;
import ru.udm.pfr.dao.MfcDataDao;
import ru.udm.pfr.dao.MfcServiceDao;
import ru.udm.pfr.models.Mfc;
import ru.udm.pfr.models.MfcData;
import ru.udm.pfr.models.MfcService;

@Service
public class MfcDataServiceImpl implements MfcDataService {
	private static Logger log = LogManager.getLogger(MfcDataServiceImpl.class);

	@Autowired
	MfcDataDao mfcDataDao;

	@Autowired
	MfcDao mfcDao;

	@Autowired
	MfcServiceDao mfcServiceDao;

	@Override
	public MfcData getOldValues(Long mfcId, Long serviceId) {		
		Mfc district = mfcDao.findOne(mfcId);		
		MfcService mfcService = mfcServiceDao.findOne(serviceId);
		log.info("Получаем старые значения для района {} для услуги {}",
				district.getTitle(),mfcService.getId());
		MfcData mfcData = mfcDataDao
				.findFirstByMfcAndMfcServiceAndIsDeleted(district, mfcService,
						false);		
		if (mfcData != null) {
			log.info("Запись найдена");
			log.info(mfcData.getField3());
		}
		else {
			log.warn("Запись не найдена");
		}
		return mfcData;
	}

	@Override
	public void insertRecord(MfcData mfcData) {
		log.info("Проверяем запись с идентификатором {} на существование",
				mfcData.getId());
		MfcData existedRecord = mfcDataDao.findOne(mfcData.getId());
		if (existedRecord == null) {
			log.info("Запись не была найдена, будет добавлена новая запись");
			mfcDataDao.save(mfcData);
		} else {
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
		log.warn("{} записей будет помечено как удалённые!", mfcDatas.size());
		for (MfcData mfcData : mfcDatas) {
			mfcData.setIsDeleted(true);
			mfcDataDao.save(mfcData);
		}
	}

}
