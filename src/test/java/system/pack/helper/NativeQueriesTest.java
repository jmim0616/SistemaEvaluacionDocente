package system.pack.helper;
//package system.pack.helper;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.JpaHibernateApplication;
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.entities.Course;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = JpaHibernateApplication.class)
//public class NativeQueriesTest {
//
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	EntityManager entity_manager;
//
//	@org.junit.Before
//	public void Before() {
//
//		logger.info("*******************");
//
//	}
//
//	@Test
//	public void native_queries_typed() {
//
//		Query query = entity_manager.createNativeQuery("select * from course", Course.class);
//		List<Course> result_list = query.getResultList();
//		logger.info("select * from course -> {}", result_list);
//
//	}
//
//	@Test
//	public void native_queries_typed_where_parameters() {
//
//		Query query = entity_manager.createNativeQuery("select * from course where id = ?", Course.class);
//		query.setParameter(1, 1001L);
//		List<Course> result_list = query.getResultList();
//		logger.info("select * from course where id = ? -> {}", result_list);
//
//	}
//
//	@Test
//	public void native_queries_typed_where_named_parameters() {
//
//		Query query = entity_manager.createNativeQuery("select * from course where id = :id", Course.class);
//		query.setParameter("id", 1001L);
//		List<Course> result_list = query.getResultList();
//		logger.info("select * from course where id = :id -> {}", result_list);
//
//	}
//
//	@Test
//	@Transactional
//	public void native_queries_to_update() {
//
//		Query query = entity_manager.createNativeQuery("update course set last_updated_date = sysdate()", Course.class);
//		int result_rows_updated = query.executeUpdate();
//		logger.info("update course set last_updated_date = sysdate() -> {}", result_rows_updated);
//
//	}
//
//}
