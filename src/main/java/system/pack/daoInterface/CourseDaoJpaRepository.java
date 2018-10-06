package system.pack.daoInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import system.pack.entity.CourseEntity;
import system.pack.entity.TeacherEntity;

public interface CourseDaoJpaRepository extends JpaRepository<CourseEntity, Integer> {


	CourseEntity findById(int id);
	
	Optional<CourseEntity> findByGroupId(int groupId);

//	@Query("Select  c  From Course c where name like '%course'")
//	List<TeacherEntity> courseWith100StepsInName();
//
//	@Query(value = "select c From Course c where name like '%course%'", nativeQuery = true)
//	List<TeacherEntity> courseWithcourseInNameUsingNativeQuery();
//
//	@Query(name = "query_get_all_courses_where")
//	List<TeacherEntity> courseWithcourseInNameUsingNamedQuery(String name);
	
}
