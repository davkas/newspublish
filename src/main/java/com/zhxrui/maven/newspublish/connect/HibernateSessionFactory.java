package com.zhxrui.maven.newspublish.connect;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {
	//  配置文件路径
	private static String CONFIG_FILE_LOCATION="/hibernate.cfg.xml";
	//实例化ThreadLocal类
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	//实例话Configuration
	private static Configuration configuration = new Configuration();
	//声明SessionFactory接口
	private static SessionFactory sessionFactory;
	//定义configFile属性
	private static String configFile=CONFIG_FILE_LOCATION;
	static{
		try {
			configuration.configure(configFile);
			ServiceRegistry sr = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(sr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private HibernateSessionFactory(){}
	public static Session getSession()throws HibernateException{
		Session session=(Session) threadLocal.get();
		if(session == null || !session.isOpen()){
			if(sessionFactory == null){
				rebuildSessionFactory();
			}
			session=(sessionFactory !=null )?sessionFactory.openSession()
					:null;
			threadLocal.set(session);
		}
		return session;
	}
	private static void rebuildSessionFactory() {
		// TODO Auto-generated method stub
		try {
			configuration.configure(configFile);
			/*		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
			ServiceRegistry registry = builder.buildServiceRegistry(); 
			sessionFactory = configuration.buildSessionFactory(registry);*/
			ServiceRegistry sr = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(sr);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void closeSession() throws HibernateException{
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);;
		if(session != null){
			session.close();
		}
	}
	public static Configuration getConfiguration() {
		return configuration;
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void setConfigFile(String configFile) {
		HibernateSessionFactory.configFile = configFile;
		sessionFactory=null;
	}
}
