package start_from_stateful;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.RemoteBinding;

import com.entity.testEntity;

/**
 * Session Bean implementation class StatefulBean
 */
@Stateful
@RemoteBinding(jndiBinding="StatefulFirst")
public class StatefulBean implements StatefulBeanRemote {
	
	@PersistenceContext(unitName="EjbPU")
	private EntityManager entityManager;   
	
	int i=0;
	
	@Override
	public String StartWithStateful() {
		return "Stateful session bean implementation first :"+i++;
	}

	@Override
	public void makeEntry(String s) {
		testEntity t = new testEntity(s);
		entityManager.persist(t);
	}

	@Override
	public String getEntry(int id) {
		testEntity t = entityManager.find(testEntity.class,id);
		return t.getName();
	}

	
	

}
