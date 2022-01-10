package projectone.util;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void notNullTest() {
		SessionFactory result = HibernateUtil.getSessionFactory();
		assertNotEquals(null, result);
	}

}
