package biz.opengte.corso.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EjbA {
	@EJB
	EjbB ejbB;
	
	public String methodA() {
		return "A " + ejbB.methodB();
	}

}
