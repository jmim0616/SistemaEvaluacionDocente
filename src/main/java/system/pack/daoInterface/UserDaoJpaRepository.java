package system.pack.daoInterface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import system.pack.entity.TeacherEntity;
import system.pack.entity.UserEntity;

public interface UserDaoJpaRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByName(String name);
	
	UserEntity findById(int id);

//	@Query("Select  c  From Course c where name like '%course'")
//	List<TeacherEntity> courseWith100StepsInName();
//
//	@Query(value = "select c From Course c where name like '%course%'", nativeQuery = true)
//	List<TeacherEntity> courseWithcourseInNameUsingNativeQuery();
//
//	@Query(name = "query_get_all_courses_where")
//	List<TeacherEntity> courseWithcourseInNameUsingNamedQuery(String name);
	
}
