package projectone.util;

import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import projectone.controller.ReimbursementController;
public class HibernateUtil {
	
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(HibernateUtil.class);

	public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
            	logger.info("Creating SessionFactory....");
            	Logger log = Logger.getLogger("org.hibernate");
                log.setLevel(Level.INFO); 
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                    logger.info("Destroying service registry");
                }
            }
        }
        logger.info("Returning sessionFactory");
        return sessionFactory;
    }
	
	  public static void shutdown() {
	        // Close caches and connection pools
		  logger.info("closing cashe and connection pools");
	        getSessionFactory().close();
	    }

}
