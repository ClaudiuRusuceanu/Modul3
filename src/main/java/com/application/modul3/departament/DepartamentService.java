package com.application.modul3.departament;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.exception.ResourceNotFoundException;

@Service
public class DepartamentService {

	@Autowired
	private DepartamentRepository departamentRepository;

	public Departament createDepartament(Departament departament) {
		return departamentRepository.saveAndFlush(departament);
	}

	public List<Departament> getAllDepartaments() {
		return departamentRepository.findAll();
	}

	public Departament findDepartamentById(Integer id) {
		return departamentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Departamentul nu poate fi gasit"));
	}

	public void deleteDepartamentById(Integer id) {
		departamentRepository.deleteById(id);
	}

	public Departament updateDepartament(Departament departament, Integer id) {
		Departament departamentUpdate = findDepartamentById(id);
		departamentUpdate.setNume(departament.getNume());
		departamentRepository.flush();
		return departamentUpdate;
	}
}
