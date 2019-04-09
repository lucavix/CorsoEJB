package biz.opengte.corso.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Local({AdderLocal.class})
@Remote({AdderRemote.class})
public class Adder implements AdderLocal,AdderRemote {
	@Override
	public int add(int a, int b) {
		return a+b;
	}
	
	@Override
	public int addRemote(int a, int b) {
		return a+b;
	}
}
