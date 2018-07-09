package system.pack.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.ws.rs.core.Variant.VariantListBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


	/*
  	this class is responsible for define configuration of the project in the development environment.
	it defines:
	-the data source of the project for development environment
	-the EntityManagerFactory of the project for development environment
	-the Hibernate properties that EntityManagerFactory and JPA will be use
	-the the Transaction Manager of the project that provides access to create, open, close, commit, rollback
	 transactions with ACID properties.
 */


//establish the source bean for define the beans in the Spring IoC Container.
@Configuration
//this configures the component scanning directive, effectively replacing the XML, its defines when spring will go to search
//the beans of the application to later inject them.
@ComponentScan("system.pack")
//@ComponentScan(basePackages = { "system.pack" }, excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
//enable transactional support for the application, similar to the support found in Spring's <tx:*> XML namespace.
@EnableTransactionManagement
//Annotation to enable JPA repositories. Will scan the package of the annotated configuration 
//class for Spring Data repositories by default.
@EnableJpaRepositories(basePackages = { "system.pack.daoInterface" })
//used to read configurations from properties file using Spring’s Environment interface and @Value annotations. 
@PropertySource("classpath:QAapplication.properties")
//Spring Profiles provide a way to segregate parts of your application configuration and make it be available only 
//in certain environments. Any @Component or @Configuration can be marked with @Profile to limit when it is loaded
//Consider a basic scenario – we have a bean that should only be active during development, but not deployed in production.
//We annotate that bean with a “dev” profile, and it will only be present in the container during development 
//– in production, the dev simply won’t be active
@Profile(value="QA")
public class QaApplicationContext {

	//Environment interface for read configurations from properties files
	@Resource
	private Environment environment;
	
	//setting the variable name of the properties files variables 

	private static final String PROPERTY_NAME_DATA_BASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_USER = "db.user";
	private static final String PROPERTY_NAME_DATA_BASE_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_H2_CONSOLE = "spring.h2.console.enabled";
	private static final String PROPERTY_NAME_H2_CONSOLE_PATH = "spring.h2.console.path";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_GENERATE_STATISTICS = "hibernate.generate_statistics";

	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.package_to_scan";
	
	//Defining the data source of the development environment
	@Bean 
	public DataSource dataSource() {
		
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
			dataSource.setDriverClassName(environment.getProperty(PROPERTY_NAME_DATA_BASE_DRIVER));
			dataSource.setUsername(environment.getProperty(PROPERTY_NAME_DATABASE_USER));
			dataSource.setPassword(environment.getProperty(PROPERTY_NAME_DATA_BASE_PASSWORD));
			dataSource.setUrl(environment.getProperty(PROPERTY_NAME_DATABASE_URL));
			
			return dataSource;
		
	}

	//Defining the EntityManagerFactory of the project for development environment, which is responsible of data access, maintain the state of entitys
	//during the transaction, do changes CRUD with to the entities with the help of Hibernate and JPA.
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();

		entityManager.setDataSource(dataSource());
		entityManager.setPackagesToScan(environment.getProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));

		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		entityManager.setJpaVendorAdapter(jpaVendorAdapter);
		entityManager.setJpaProperties(hibernateProperties());
		
		return entityManager;

	}
	


	//Setting the Hibernate properties that EntityManagerFactory and JPA will be use
	public Properties hibernateProperties() {

		Properties jpaProperties = new Properties();

		jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_DIALECT,
				environment.getProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL,
				environment.getProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL));
		jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
				environment.getProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL,
				environment.getProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
		jpaProperties.setProperty(PROPERTY_NAME_HIBERNATE_GENERATE_STATISTICS,
				environment.getProperty(PROPERTY_NAME_HIBERNATE_GENERATE_STATISTICS));
		jpaProperties.setProperty(PROPERTY_NAME_H2_CONSOLE,
				environment.getProperty(PROPERTY_NAME_H2_CONSOLE));
		jpaProperties.setProperty(PROPERTY_NAME_H2_CONSOLE_PATH,
				environment.getProperty(PROPERTY_NAME_H2_CONSOLE_PATH));

		
		return jpaProperties;

	}

	//Defining the  Transaction Manager of the project that provides access to create, open, close, commit, rollback
	//transactions with ACID properties.
	@Bean/*(name="transactionManager")*/
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {

		JpaTransactionManager transactionManager = new JpaTransactionManager();

		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;

	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	}
