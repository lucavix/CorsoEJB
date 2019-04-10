package biz.opengte.corso.ejb;

import javax.ejb.Stateless;

import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class EjbB {

	public String methodB() {
		return "B";
	}
}
