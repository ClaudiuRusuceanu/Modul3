package com.application.modul3.angajat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.angajat.dto.AngajatDTO;
import com.application.modul3.angajat.mapper.AngajatMapper;

@RestController
@RequestMapping("/angajati")
public class AngajatController {
	
	@Autowired
	private AngajatService angajatService;
	
	@Autowired
	private AngajatMapper angajatMapper;

	
	@PostMapping
	public AngajatDTO createAngajat(@RequestBody AngajatDTO angajatDTO) {
		Angajat createdAngajat = angajatService.createAngajat(angajatMapper.angajatDTO2Angajat(angajatDTO));
		return angajatMapper.angajat2AngajatDTO(createdAngajat);
	}
	
	@DeleteMapping("/id")
	public void deleteAngajatById(@PathVariable Integer id) {
		angajatService.deleteAngajat(id);
	}
}
