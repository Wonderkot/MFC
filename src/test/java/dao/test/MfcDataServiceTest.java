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
import ru.udm.pfr.models.MfcData;

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

	@Test
	public void test() {
		for (MfcData data : mfcService.getOldValues(1L)) {
			System.out.println(data.getId());
			//mfcService.insertRecord(data);
		}
	}

}
