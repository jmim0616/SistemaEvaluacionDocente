package system.pack.boImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import system.pack.bointerface.DepartmentBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.DepartmentBean;
import system.pack.vo.TeacherBean;

@Service
public class DepartmentBoImpl implements DepartmentBoInterface {
	
	@Transactional
	@Override
	public JsonResponse create(DepartmentBean departmentBean, BindingResult bindingResult) {
		
	 return null;
	}

	@Transactional
	@Override
	public JsonResponse update(DepartmentBean departmentBean, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}


	@Transactional
	@Override
	public JsonResponse search() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
}
