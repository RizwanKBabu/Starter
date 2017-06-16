package test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

<<<<<<< Upstream, based on branch 'master' of https://github.com/RizwanKBabu/Starter.git
<<<<<<< Upstream, based on branch 'master' of https://github.com/RizwanKBabu/Starter.git
public class Tester {
=======
class Test {
>>>>>>> b4d57bc Changing Class name
=======
class Tester {
>>>>>>> ae76f14 Solving Conflicts

	public static void main(String[] args)
	{
		java.util.Date d = new java.util.Date();
		Calendar c = Calendar.getInstance();
		System.out.println(d.getTime());
		System.out.println(new Date(d.getTime()));
		
		System.out.println(new Date(System.currentTimeMillis()));
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.util.Date desiredDate = cal.getTime();
		System.out.println(desiredDate);
		
		
		
	}
	
}
