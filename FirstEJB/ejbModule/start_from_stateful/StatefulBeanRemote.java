package start_from_stateful;

import javax.ejb.Remote;

@Remote
public interface StatefulBeanRemote {

	String StartWithStateful();
	
	void makeEntry(String s);
	
	String getEntry(int id);
}
