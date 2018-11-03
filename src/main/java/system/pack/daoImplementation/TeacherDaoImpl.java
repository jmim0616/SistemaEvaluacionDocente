package system.pack.daoImplementation;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.SubjectDaoInterface;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private SubjectDaoInterface subjectDaoInterfacel;

	@Override
	public void create(TeacherEntity teacherEntity) {

		entityManager.merge(teacherEntity);
		
	}

	@Override
	public void update(TeacherEntity teacherEntity) {
		
		entityManager.merge(teacherEntity);
		
	}

	@Override
	public void updateState(TeacherEntity teacherEntity) {
		
		entityManager.merge(teacherEntity);
		
	}

	@Override
	public TeacherEntity findById(int id) {
		
		TeacherEntity teacher =  entityManager.find(TeacherEntity.class, id);
		
		return teacher;
	}
	
	@Override
	public Optional<TeacherEntity> findByName(String name) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.name =:name", TeacherEntity.class);
		
		query.setParameter("name", name);
		
		Optional<TeacherEntity> teacher = query.getResultList().stream().findFirst();
		
		return teacher;
	}

	@Override
	public TeacherEntity findByLastName(String lastName) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.lastName =:lastName", TeacherEntity.class);
		
		query.setParameter("lastName", lastName);
		
		TeacherEntity teacher = query.getSingleResult();
		
		return teacher;

	}

	@Override
	public TeacherEntity findByIdentificationType(String identificationType) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.identificationType =:identificationType", TeacherEntity.class);
		
		query.setParameter("identificationType", identificationType);
		
		TeacherEntity teacher = query.getSingleResult();
		
		return teacher;
		
	}

	@Override
	public TeacherEntity findByTeacherStatusId(int teacherStatusId) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.teacherStatus.teacherStatusId =:teacherStatusId", TeacherEntity.class);
		
		query.setParameter("teacherStatusId", teacherStatusId);
		
		TeacherEntity teacher = query.getSingleResult();
		
		return teacher;
		
	}

	@Override
	public boolean isValidTeacherId(int teacherId) {
		return findById(teacherId) != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherEntity> getTeachers(TeacherBean teacherBean) {
		String sql = "select teachers.* from teachers";
		
		if (!teacherBean.getSubjectSearch().equals("")){
			sql += ", subjects_by_teacher where "
					+ "teachers.teacherId = subjects_by_teacher.teacherId"
					+ " and subjects_by_teacher.subjectId = :subjectId ";
		}
		
		if (!teacherBean.getTeacherId().equals("")){
			if (!teacherBean.getSubjectSearch().equals(""))
				sql += " and subjects_by_teacher.teacherId = :teacherId";
			else
				sql += " where teacherId = :teacherId";
		}
		
		if (!teacherBean.getName().equals("")){
			if ((!teacherBean.getSubjectSearch().equals("")) || (!teacherBean.getTeacherId().equals("")))
				sql += " and upper(name) like CONCAT('%',:name,'%')";	
			else
				sql += " where upper(name) like CONCAT('%',:name,'%')";
					
		}
		
		System.out.println("Sql: " + sql);
		Query query = entityManager.createNativeQuery (sql, TeacherEntity.class);
		
		if (!teacherBean.getSubjectSearch().equals("")){

			if (subjectDaoInterfacel.findByName(teacherBean.getSubjectSearch()).isPresent()){
				query.setParameter("subjectId", subjectDaoInterfacel.findByName(teacherBean.getSubjectSearch()).get().getSubjectId());
			}
			else{
				query.setParameter("subjectId", "");
			}
			
		}
		
		if (!teacherBean.getTeacherId().equals("")){
			query.setParameter("teacherId", teacherBean.getTeacherId());
		}
		
		if (!teacherBean.getName().equals("")){
			query.setParameter("name", teacherBean.getName().toUpperCase());			
		}
		
		System.out.println("Size of list: " + query.getResultList().size());
		
		return query.getResultList();
		
	}

	

	
	
}
