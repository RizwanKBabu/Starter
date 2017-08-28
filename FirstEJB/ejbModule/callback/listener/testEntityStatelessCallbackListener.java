package callback.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import com.entity.testEntity;
import com.entity.testEntityStateless;

public class testEntityStatelessCallbackListener {

	 @PrePersist
	   public void prePersist(testEntityStateless test){
	      System.out.println("testEntityStatelessCallbackListener.prePersist:" 
	         + "FromEJB to be created with FIRSTDB id: "+test.getId());
	   }

	   @PostPersist
	   public void postPersist(Object test){
	      System.out.println("testEntityStatelessCallbackListener.postPersist::"
	         + "FromEJB created with FIRSTDB id: "+((testEntityStateless)test).getId());
	   }

	   @PreRemove
	   public void preRemove(testEntityStateless test) {
	      System.out.println("testEntityStatelessCallbackListener.preRemove:"
	         + " About to delete FromEJB: " + test.getId());
	   }

	   @PostRemove
	   public void postRemove(testEntityStateless test){
	      System.out.println("testEntityStatelessCallbackListener.postRemove::"
	         + " Deleted FromEJB: " + test.getId());
	   }

	   @PreUpdate
	   public void preUpdate(testEntityStateless test){
	      System.out.println("testEntityStatelessCallbackListener.preUpdate::"
	         + " About to update FromEJB: " + test.getId());
	   }

	   @PostUpdate
	   public void postUpdate(testEntityStateless test){
	      System.out.println("testEntityStatelessCallbackListener.postUpdate::"
	         + " Updated FromEJB: " + test.getId());
	   }

	   @PostLoad
	   public void postLoad(testEntityStateless test){
	      System.out.println("testEntityStatelessCallbackListener.postLoad::"
	         + " Loaded FromEJB: " + test.getId());
	   }
	
}
