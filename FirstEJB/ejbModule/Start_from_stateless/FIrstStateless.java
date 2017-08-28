package Start_from_stateless;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.RemoteBinding;

import com.entity.HSQLTestEntity;
import com.entity.testEntityStateless;

import callback.listener.InterceptorTest;

/**
 * Session Bean implementation class FIrstStateless
 */
@Interceptors ({InterceptorTest.class})
@Stateless
@RemoteBinding(jndiBinding="StatelessFirst")
public class FIrstStateless implements FIrstStatelessRemote {
	
	int i=0;
	
	@Resource
	private SessionContext context;
	
	@PersistenceContext(unitName="EjbPU")
	private EntityManager entityManager;
	
	@PersistenceContext(unitName="EjbHsqlDefault")
	private EntityManager em;
	
	
	@Override
	public String start() {
		// TODO Auto-generated method stub
		return "Stateless session bean implementation first"+i++;
	}

	
	 public void createTimer(long duration) {
	      context.getTimerService().createTimer(duration, "Hello World!");
	   }

	   @Timeout
	   public void timeOutHandler(Timer timer){
	      System.out.println("timeoutHandler : " + timer.getInfo());        
	      timer.cancel();
	   }
	
	   
	@Override
	public void makeEntryStateless(String s) {
		testEntityStateless t = new testEntityStateless(s);
		entityManager.persist(t);
	}

	@Override
	public testEntityStateless getEntryStateless(int id) {
		testEntityStateless t = entityManager.find(testEntityStateless.class,id);
		return t;
	}


	@Override
	public testEntityStateless makeEntryEntity(testEntityStateless e) {
		return entityManager.merge(e);
	}


	@Override
	public void hsql_insert(String s) {
		em.persist(new HSQLTestEntity(s));
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<HSQLTestEntity> getHsql(int id) {
		 return em.createQuery("SELECT e FROM HSQLTestEntity e").getResultList();
	}
	
	
}
