package biz.opengte.corso.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class Greeter {
	
	public String greet() {
		return "Hello, World";
	}
}
