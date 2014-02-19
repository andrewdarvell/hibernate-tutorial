package org.hibernate.tutorial.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null;

	static {
		try {
			Configuration configuration=new Configuration().configure();
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

			// If you miss the below line then it will complaing about a missing dialect setting
			serviceRegistryBuilder.applySettings(configuration.getProperties());

			ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			//sessionFactory = configuration.buildSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}