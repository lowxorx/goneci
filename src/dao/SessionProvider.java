package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionProvider {

	private StandardServiceRegistry standardRegistry = getRegistry();
	private Metadata metadata = getMetatdata();
	private SessionFactory factory = getSessionFactory();
	private Session session;

	private final String CONFIG_FILE = "hibernate.cfg.xml";

	public SessionProvider() {
	}

	private StandardServiceRegistry getRegistry() {
		return standardRegistry == null ? new StandardServiceRegistryBuilder().configure(CONFIG_FILE).build()
				: standardRegistry;
	}

	private Metadata getMetatdata() {
		return metadata == null
				? new MetadataSources(standardRegistry).getMetadataBuilder()
						.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build()
				: metadata;
	}

	private SessionFactory getSessionFactory() {
		return factory == null ? metadata.getSessionFactoryBuilder().build() : factory;
	}

	public Session getSession() {
		return session == null ? factory.openSession() : session;
	}

}
