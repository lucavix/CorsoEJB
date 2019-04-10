package biz.opengte.corso.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateful;

@Stateful
@Remote(CounterRemote.class)
public class Counter implements CounterRemote {

	private Integer i = 0;
	@Override
	public Integer inc() {
		return ++i;
	}

	@Override
	public Integer dec() {
		return --i;
	}

	@Override
	public Integer get() {
		return i;
	}

	@Override
	public void set(Integer i) {
		this.i = i;		
	}
	
}
