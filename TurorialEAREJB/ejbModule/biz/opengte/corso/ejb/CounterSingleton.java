package biz.opengte.corso.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Singleton
@Startup
@Lock(LockType.READ)
public class CounterSingleton {

	private Integer counter;

	@PostConstruct
	private void init() {
		this.counter = 0;
	}

	public Integer getCounter() {
		return counter;
	}

	@Lock(LockType.WRITE)
	@AccessTimeout(value=1000)
	public void inc() {
		counter++;
		System.out.println(counter);
	}

	@Lock(LockType.WRITE)
	@AccessTimeout(value=1000)
	public void dec() {
		counter--;
		System.out.println(counter);
	}
}
