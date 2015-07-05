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

import ru.udm.pfr.dao.UserDao;

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
    private UserDao userService;
 
    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }
	@Test
	public void getCount() {		
		long count = userService.count();
		System.out.println(count);		
	}
}
