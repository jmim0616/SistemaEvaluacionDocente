package system.pack.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {

//	@Autowired
//	PersonaDaoJpaRepository personaDaoJpaRepository;
//	
//	@Autowired
//	BienDaoJpaRepository bienDaoJpaRepository;
	
	@GetMapping(value = "/test1")
	public String showTest1(Model model) {
		
//		PersonaEntity personaEntity = new PersonaEntity(500, "vlad", "123", "vlad@gmail.com", new Date(), new Date(), new Date());
//		personaDaoJpaRepository.save(personaEntity);
//		model.addAttribute("personas", personaDaoJpaRepository.findByNombre("vlad"));
//		BienEntity bienEntity1 = new BienEntity(1000, "carro", 100000000, new Date());
//		BienEntity bienEntity2 = new BienEntity(1001, "carro", 200000000, new Date());
//		bienEntity1.setPersona(personaEntity);
//		bienEntity2.setPersona(personaEntity);
//		bienDaoJpaRepository.save(bienEntity1);
//		bienDaoJpaRepository.save(bienEntity2);
//		model.addAttribute("bienes", bienDaoJpaRepository.findByTipo("carro"));


//		model.addAttribute("bienes", bienDaoJpaRepository.findByTipo("carro"));

		return "test1";
	}
	
	
	@GetMapping(value = "/test2")
	public String showPrueba2(Model model) {


//		model.addAttribute("bienes", bienDaoJpaRepository.findByTipo("empresa"));

		return "test2";
	}
	
	
}
