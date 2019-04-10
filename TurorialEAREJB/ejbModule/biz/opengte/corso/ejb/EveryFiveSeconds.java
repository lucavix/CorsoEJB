package biz.opengte.corso.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EveryFiveSeconds {
	
	@Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
	public void doJob() {
		System.out.println(System.currentTimeMillis());
	}
}
