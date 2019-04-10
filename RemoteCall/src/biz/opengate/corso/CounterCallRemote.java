package biz.opengate.corso;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import biz.opengte.corso.ejb.CounterRemote;

public class CounterCallRemote {
	final static Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
	static {
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
	}

	public static void main(String[] args) throws Exception {
		invokeStatelessBean();
	}

	private static CounterRemote lookupRemoteStatelessAdder() throws NamingException {
		final Context context = new InitialContext(jndiProperties);
		return (CounterRemote) context.lookup("ejb:TurorialEAR/TurorialEAREJB/Counter!biz.opengte.corso.ejb.CounterRemote?stateful");
	}

	private static void invokeStatelessBean() throws NamingException {
		final CounterRemote counter = lookupRemoteStatelessAdder();
		int i = counter.get();
		System.out.println("Current value = " + i);
		for(int x=0;x<20;x++) {
			System.out.println("Inc: " + counter.inc());
		}
	}

}
