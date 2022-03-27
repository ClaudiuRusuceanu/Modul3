package com.application.modul3.departament;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.departament.dto.DepartamentDTO;
import com.application.modul3.departament.mapper.DepartamentMapper;

@RestController
@RequestMapping("/departaments")
public class DepartamentController {

	@Autowired
	private DepartamentService departamentService;
	@Autowired
	private DepartamentMapper departamentMapper;

	@PostMapping
	public DepartamentDTO createDepartament(@RequestBody DepartamentDTO departamentDTO) {
		Departament createDepartament = departamentService
				.createDepartament(departamentMapper.departamentDTO2Departament(departamentDTO));
		return departamentMapper.departament2DepartamentDTO(createDepartament);
	}

	@GetMapping("/list")
	public List<DepartamentDTO> getAllDepartaments() {
		return departamentMapper.departamentList2DepartamentListDTO(departamentService.getAllDepartaments());
	}

	@GetMapping("/{id}")
	public void getDepartamentById(@PathVariable Integer id) {
		departamentService.deleteDepartamentById(id);
	}
	
	@PutMapping("/{id}")
	public Departament updateDepartament(@RequestBody Departament departament, Integer id) {
		return departamentService.updateDepartament(departament, id);
	}

}
