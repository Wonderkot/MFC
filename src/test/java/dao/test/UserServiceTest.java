/**
 * 
 */
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

import ru.pfr.udm.services.UserService;
import ru.udm.pfr.dao.MfcDao;
import ru.udm.pfr.dao.MfcServiceDao;

/**
 * @author wonderkot
 *
 */
@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/application-config.xml"})
public class UserServiceTest {
	@Resource
    private EntityManagerFactory emf;
    protected EntityManager em;
    
    @Resource
    private MfcServiceDao  serviceDao;
    
    @Resource
    private UserService userService;
    
    @Resource
    private MfcDao mfcDao;
 
    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }
	
	@Test 
	public void testService() {
		long count = serviceDao.count();
		System.out.println(count);
	}
	
	@Test
	public void testMfc() {
		long count = mfcDao.count();
		System.out.println(count);
	}
}
