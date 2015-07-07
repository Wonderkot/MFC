package dao.test;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.pfr.udm.services.MfcDataService;
import ru.udm.pfr.dao.MfcDao;
import ru.udm.pfr.dao.MfcDataDao;
import ru.udm.pfr.dao.MfcServiceDao;
import ru.udm.pfr.models.Mfc;
import ru.udm.pfr.models.MfcData;
import ru.udm.pfr.models.MfcService;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/application-config.xml" })
public class MfcDataServiceTest {
	@Resource
	private EntityManagerFactory emf;
	protected EntityManager em;

	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@Resource
	private MfcDataService mfcService;

	@Resource
	private MfcDao mfcdao;

	@Resource
	private MfcServiceDao mfcServiceDao;
	
	@Resource
	private MfcDataDao mfcDataDao;

	@Test
	public void testService() {
		mfcServiceDao.findOne(1L);
	}
	
	@Test 
	public void testMfc() {
		mfcdao.findOne(1L);
	}
	
	@Test
	public void testMfcData() {
		MfcService service = mfcServiceDao.findOne(1L);
		Mfc mfc = mfcdao.findOne(1L);
		MfcData mfcData = mfcDataDao.findFirstByMfcAndMfcServiceAndIsDeleted(mfc, service, false);		
		
		service.setMfcData(mfcData);
		System.out.println(service.getMfcData().getField1());
		
	}

}
