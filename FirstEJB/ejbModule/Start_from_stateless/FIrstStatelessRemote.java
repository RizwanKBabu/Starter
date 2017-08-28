package Start_from_stateless;

import java.util.List;

import javax.ejb.Remote;

import com.entity.HSQLTestEntity;
import com.entity.testEntityStateless;

@Remote
public interface FIrstStatelessRemote {

	String start();
	void makeEntryStateless(String s);
	testEntityStateless getEntryStateless(int id);
	testEntityStateless makeEntryEntity(testEntityStateless e);
	void createTimer(long milliseconds);
	void hsql_insert(String s);
	List<HSQLTestEntity> getHsql(int id);
	
}
