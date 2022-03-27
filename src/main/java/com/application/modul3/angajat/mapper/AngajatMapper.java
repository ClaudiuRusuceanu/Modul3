package com.application.modul3.angajat.mapper;

import org.springframework.stereotype.Component;

import com.application.modul3.angajat.Angajat;
import com.application.modul3.angajat.dto.AngajatCreateDTO;
import com.application.modul3.angajat.dto.AngajatDTO;

@Component
public class AngajatMapper {
	
	public AngajatDTO angajat2AngajatDTO(Angajat angajat) {
		AngajatDTO angajatDTO = new AngajatDTO();
		angajatDTO.setId(angajat.getId());
		angajatDTO.setNume(angajat.getNume());
		angajatDTO.setVarsta(angajat.getVarsta());
		return angajatDTO;
	}
	
	public Angajat angajatDTO2Angajat(AngajatDTO angajatDTO) {
		Angajat angajat = new Angajat();
		angajat.setNume(angajatDTO.getNume());
		angajat.setVarsta(angajatDTO.getVarsta());
		return angajat;
	}
	
	public Angajat angajatCreateDTO2Angajat(AngajatCreateDTO angajatDTO) {
		Angajat angajat = new Angajat();
		angajat.setNume(angajatDTO.getNume());
		angajat.setVarsta(angajatDTO.getVarsta());
		return angajat;
	}

}
