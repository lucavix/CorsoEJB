package biz.opengte.corso.ejb;

public interface CounterRemote {
	abstract Integer inc();
	abstract Integer dec();
	abstract Integer get();
	abstract void set(Integer i);	

}
