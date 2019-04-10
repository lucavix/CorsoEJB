package biz.opengate.corso;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import biz.opengte.corso.ejb.AdderRemote;

public class AdderCallRemote {
	final static Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
	static {
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
	}

	public static void main(String[] args) throws Exception {
		invokeStatelessBean();
	}

	private static AdderRemote lookupRemoteStatelessAdder() throws NamingException {
		final Context context = new InitialContext(jndiProperties);
		return (AdderRemote) context.lookup("ejb:TurorialEAR/TurorialEAREJB/Adder!biz.opengte.corso.ejb.AdderRemote");
	}

	private static void invokeStatelessBean() throws NamingException {
		final AdderRemote adder = lookupRemoteStatelessAdder();
		System.out.println("Obtained a remote stateless calculator for invocation");
		int a = 3;
		int b = 4;
		System.out.println("Adding " + a + " and " + b + " via the remote stateless calculator deployed on the server");
		int sum = adder.addRemote(a, b);
		System.out.println("Remote calculator returned sum = " + sum);
	}

}
